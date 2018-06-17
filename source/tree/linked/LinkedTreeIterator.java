package tree.linked;

import tree.TreeIterator;
import tree.TreeElement;

import java.util.function.Consumer;

public class LinkedTreeIterator implements TreeIterator {

    @Override
    public void iterate(Object object, Consumer<TreeElement> consumer ){
        LinkedElement currentElement = LinkedElementFactory.of( null, object );
        while ( true ){
            if ( currentElement == null ){
                break;
            } else if ( currentElement.isValue() ){
                consumer.accept( currentElement );
                currentElement = currentElement.previous();
            } else if ( currentElement.hasNext() ){
                currentElement = currentElement.next();
            } else {
                currentElement = currentElement.previous();
            }
        }
    }


}
