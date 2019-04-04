package org.kurenai.treestructure.binarytree;

/**
 * 树的节点
 *
 * @author Kurenai
 * @since 2019-04-05 0:54
 */

public class TreeNode {
    int val;
    /**
     * 左子树
     */
    TreeNode left;
    /**
     * 右子树
     */
    TreeNode right;

    /**
     * 构造方法
     * @param val 值
     */
    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "[" +
                "val: " + val +
                ", left: " + left +
                ", right: " + right +
                ']';
    }
}
