package tree;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.Test;
import power.io.IO;

import java.util.function.Consumer;

import static org.junit.Assert.assertEquals;

public abstract class TreeIteratorTest {

    abstract TreeIterator createTreeIterator();

    @Test
    public void simpleIteratorTest(){
        TreeElementCounter consumer = new TreeElementCounter();
        Object object = readFileTree( "tree1.json" );
        createTreeIterator().iterate( object, consumer );
        assertEquals( 5, consumer.counter );
    }

    @Test
    public void complexIteratorTest(){
        TreeElementCounter consumer = new TreeElementCounter();
        Object object = readFileTree( "tree2.json" );
        createTreeIterator().iterate( object, consumer );
        assertEquals( 1404, consumer.counter );
    }

    @SneakyThrows
    Object readFileTree( String fileName ){
        val file = IO.file( "tests-resources/" + fileName );
        return new ObjectMapper().readValue( file, Object.class );
    }

    class TreeElementCounter implements Consumer<TreeElement> {

        int counter = 0;

        @Override
        public void accept(TreeElement treeElement) {
            counter++;
            System.out.println( treeElement.getPath() + " => " + treeElement.getValue() );
        }

    }

}