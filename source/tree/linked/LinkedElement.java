package tree.linked;

import tree.TreeElement;

public interface LinkedElement extends TreeElement {

    boolean hasNext();
    LinkedElement previous();
    LinkedElement next();

    default boolean isValue(){
        return false;
    }

}
