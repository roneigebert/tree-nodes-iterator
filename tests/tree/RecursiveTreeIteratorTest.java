package tree;

import tree.recursive.RecursiveTreeIterator;

public class RecursiveTreeIteratorTest extends TreeIteratorTest {

    @Override
    TreeIterator createTreeIterator() {
        return new RecursiveTreeIterator();
    }

}
