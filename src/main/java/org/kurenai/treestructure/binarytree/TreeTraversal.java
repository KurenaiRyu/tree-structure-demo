package org.kurenai.treestructure.binarytree;

import java.util.Stack;

/**
 * 树的遍历
 *
 * @author Kurenai
 * @since 2019-04-05 1:00
 */

public class TreeTraversal {

    /**
     * 递归先序遍历
     * @param root 树的根节点
     */
    public static void recursionPreOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            recursionPreOrderTraversal(root.left);
            recursionPreOrderTraversal(root.right);
        }
    }

    /**
     * 非递归先序遍历树
     * @param root 树的根节点
     */
    public static void preOrderTraversal(TreeNode root) {
        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<>();
        // 新建一个游标节点为根节点
        TreeNode node = root;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                System.out.print(node.val + " ");
                // 为了之后能找到该节点的右子树，暂存该节点
                treeNodeStack.push(node);
                node = node.left;
            }

            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop().right;
            }
        }
    }

    /**
     * 递归中序遍历
     * @param root 树的根节点
     */
    public static void recursionInOrderTraversal(TreeNode root) {
        if (root != null) {
            recursionInOrderTraversal(root.left);
            System.out.print(root.val + " ");
            recursionInOrderTraversal(root.right);
        }
    }

    /**
     * 非递归中序遍历
     * @param root 树的根节点
     */
    public static void inOrderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }

            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    /**
     * 递归后序遍历
     * @param root 树的根节点
     */
    public static void recursionPostOrderTraversal(TreeNode root) {
        if (root != null) {
            recursionPostOrderTraversal(root.left);
            recursionPostOrderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    /**
     * 非递归后序遍历
     * @param root 树的根节点
     */
    public static void postOrderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisit = null;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }

            //查看当前栈顶元素
            node = treeNodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                System.out.print(node.val + " ");
                treeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
            }
        }
    }
}
