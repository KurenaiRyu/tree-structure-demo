package org.kurenai.binarytree;

/**
 * 二叉搜索树
 *
 * @author Kurenai
 * @since 2019-04-06 9:01
 */

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree(int val) {
        root = new TreeNode(val);
    }

    public TreeNode find(int val) {
        TreeNode current = root;
        while (current.val != val) {
            if (val < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public boolean insert(int val) {
        if (root == null){
            root = new TreeNode(val);
            return true;
        }

        TreeNode parent = null;
        TreeNode current = root;
        while (current != null) {
            parent = current;
            if (val < current.val) {
                current = current.left;
            } else if(val > current.val) {
                current = current.right;
            } else {
                return true;
            }
        }
        if (val < parent.val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }
        return true;
    }

    public TreeNode minNode() {
        TreeNode current = root;
        TreeNode last = null;
        while (current != null) {
            last = current;
            current = current.left;
        }
        return last;
    }

    public TreeNode maxNode() {
        TreeNode current = root;
        TreeNode last = null;
        while (current != null) {
            last = current;
            current = current.right;
        }
        return last;
    }

    /**
     * 遍历
     *
     * 利用中序遍历能够以从小到大的顺序输出关键字
     */
    public void traversal() {
        TreeTraversal.recursionInOrderTraversal(root);
    }

    public boolean delete(int val) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;
        while (current.val != val) {
            parent = current;
            if (val < current.val) {
                current = current.left;
                isLeftChild = true;
            } else{
                current = current.right;
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }
        }
        //如果为叶节点，则简单删除
        if (current.left == null && current.right == null) {
            if (current == root) {  //根节点
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        //有一个子节点
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode delNode) {
        TreeNode successorParent = delNode;
        TreeNode successor = delNode;
        TreeNode current = delNode.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (delNode.right != successor) {
            successorParent.left = successor.right;
        }
        successor.right = delNode.right;
        return successor;
    }
}
