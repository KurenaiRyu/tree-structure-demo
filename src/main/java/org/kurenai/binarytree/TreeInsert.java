package org.kurenai.binarytree;

/**
 * 树的插入
 *
 * @author Kurenai
 * @since 2019-04-05 3:08
 */

public class TreeInsert {

    /**
     * 递归有序插入
     * @param root 树的根节点
     * @param val 插入的数值
     */
    public static void recursionOrderedInsert(TreeNode root, int val) {
        //
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

    /**
     * 递归无序插入
     * @param root 树的根节点
     * @param val 插入的数值
     */
    public static void recursionDisorderInsert(TreeNode root, int val) {
        /**
         * 有错误
         */
//            if (root.left == null) {
//                root.left = new TreeNode(val);
//            } else if (root.right == null){
//                root.right = new TreeNode(val);
//            } else {
//                recursionOrderedInsert(root.left, val);
//                recursionOrderedInsert(root.right, val);
//            }
    }
}
