package org.kurenai.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    BinarySearchTree tree;

    @BeforeEach
    public void init() {
        tree = new BinarySearchTree(5);
        for (int i = 0; i < 8; ++i) {
            tree.insert(i);
        }
    }

    @Test
    public void find() {
        assert 6 == tree.find(6).val;
    }

    @Test
    public void minNode() {
        assert 0 == tree.minNode().val;
    }

    @Test
    public void maxNode() {
        assert 7 == tree.maxNode().val;
    }

    @Test
    public void traversal() {
        tree.traversal();
    }
}