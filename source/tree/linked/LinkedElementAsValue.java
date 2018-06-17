package tree.linked;

public class LinkedElementAsValue implements LinkedElement {

    final LinkedElement previous;
    final Object value;

    public LinkedElementAsValue(LinkedElement previous, Object value) {
        this.previous = previous;
        this.value = value;
    }

    public static LinkedElement of(LinkedElement previous, Object object) {
        return new LinkedElementAsValue( previous, object );
    }

    @Override
    public boolean isValue() {
        return true;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public LinkedElement previous() {
        return previous;
    }

    @Override
    public LinkedElement next() {
        return null;
    }

    @Override
    public Object value() {
        return value;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public String getPath() {
        return previous.getPath();
    }

}
