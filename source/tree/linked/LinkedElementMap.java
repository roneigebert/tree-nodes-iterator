package tree.linked;

import java.util.Iterator;
import java.util.Map;

public class LinkedElementMap implements LinkedElement {

    final LinkedElement previous;
    final Map value;
    final Iterator<Map.Entry> iterator;
    Map.Entry currentEntry;

    public LinkedElementMap(LinkedElement previous, Map value) {
        this.previous = previous;
        this.value = value;
        this.iterator = ((Map)value).entrySet().iterator();
    }

    public static LinkedElement of(LinkedElement previous, Map map) {
        return new LinkedElementMap( previous, map );
    }

    @Override
    public LinkedElement previous() {
        return previous;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public LinkedElement next() {
        currentEntry = iterator.next();
        return LinkedElementFactory.of( this, currentEntry.getValue() );
    }

    @Override
    public Object value() {
        return value;
    }

    @Override
    public Object getValue() {
        throw new RuntimeException();
    }

    @Override
    public String getPath() {
        if ( previous == null ){
            return currentEntry.getKey().toString();
        }
        return previous.getPath() + "." + currentEntry.getKey();
    }
}
