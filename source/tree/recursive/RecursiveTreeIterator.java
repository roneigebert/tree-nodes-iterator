package tree.recursive;

import lombok.val;
import tree.TreeIterator;
import tree.TreeElement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class RecursiveTreeIterator implements TreeIterator {

    @Override
    public void iterate( Object object, Consumer<TreeElement> consumer ) {
        iterateObject( null, object, consumer );
    }

    private void iterateObject(String path, Object object, Consumer<TreeElement> consumer) {
        if ( object instanceof List ){
            List objectAsList = ((List)object);
            for (int i = 0; i < objectAsList.size(); i++) {
                val element = objectAsList.get( i );
                iterateObject( (path == null ? "" : path) + "[" + i + "]", element, consumer );
            }
        } else if ( object instanceof Map ){
            Iterator<Map.Entry<Integer, Integer>> entries = ((Map)object).entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry entry = entries.next();
                iterateObject( (path == null ? "" : path + ".") + entry.getKey(), entry.getValue(), consumer );
            }
        } else {
            consumer.accept( new TreeElementValue(object, path) );
        }
    }

}
