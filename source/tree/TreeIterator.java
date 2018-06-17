package tree;

import java.util.function.Consumer;

public interface TreeIterator {

    void iterate(Object object, Consumer<TreeElement> consumer);

}
