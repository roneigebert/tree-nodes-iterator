package tree.linked;

import java.util.List;

public class LinkedElementAsList implements LinkedElement {

    final LinkedElement previous;
    final List value;
    int cursor = -1;

    public LinkedElementAsList(LinkedElement previous, List value) {
        this.previous = previous;
        this.value = value;
    }

    public static LinkedElement of(LinkedElement previous, List value) {
        return new LinkedElementAsList( previous, value );
    }

    @Override
    public boolean hasNext() {
        return cursor + 1 < value.size();
    }

    @Override
    public LinkedElement previous() {
        return previous;
    }

    @Override
    public LinkedElement next() {
        cursor++;
        return LinkedElementFactory.of( this, value.get(cursor) );
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
            return "[" + cursor + "]";
        }
        return previous.getPath() + "[" + cursor + "]";
    }

}
