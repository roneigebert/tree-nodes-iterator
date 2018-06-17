package tree;

import tree.linked.LinkedTreeIterator;

public class LinkedTreeIteratorTest extends TreeIteratorTest {

    @Override
    TreeIterator createTreeIterator() {
        return new LinkedTreeIterator();
    }

}
