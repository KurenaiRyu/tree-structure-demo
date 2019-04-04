package org.kurenai.treestructure.binarytree;

/**
 * 树的插入
 *
 * @author Kurenai
 * @since 2019-04-05 3:08
 */

public class TreeInsert {

    public static void recursionOrderedInsert(TreeNode root, int val) {
        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                recursionOrderedInsert(root.left, val);
            }
        } else if (val > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                recursionOrderedInsert(root.right, val);
            }
        }
    }

    public static void recursionDisorderInsert(TreeNode root, int val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else if (root.right == null){
                root.right = new TreeNode(val);
            } else {
                recursionOrderedInsert(root.left, val);
                recursionOrderedInsert(root.right, val);
            }
    }
}
