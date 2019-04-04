package org.kurenai.treestructure.binarytree;

import org.junit.Test;

/**
 * @author Kurenai
 * @since 2019-04-05 4:58
 */

public class TreeInsertTest {

    @Test
    public void treeInsert() {
        TreeNode orderedTree = new TreeNode(5);
        TreeNode disorderTree = new TreeNode(5);
        for (int i = 0; i < 5; ++i) {
            int random = (int)(Math.random() * 10);
            TreeInsert.recursionOrderedInsert(orderedTree, random);
            TreeInsert.recursionDisorderInsert(disorderTree, random);
        }
        System.out.println(orderedTree);
        System.out.println(disorderTree);

    }
}
