package org.kurenai.binarytree;

import org.junit.Before;
import org.junit.Test;

public class TreeTraversalTest {

    TreeNode root;

    @Before
    public void fillTree() {
        //构造出来的树参照下面图片的连接
        //https://upload-images.jianshu.io/upload_images/2405011-5f5b0b136713f744.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1000/format/webp
        if (root == null) {
            int i = 1;
            //0 layer
            root = new TreeNode(i++);
            //1st layer
            root.left = new TreeNode(i++);
            root.right = new TreeNode(i++);
            //2nd layer
            root.left.left = new TreeNode(i++);
            root.right.right = new TreeNode(i++);
            //3rd layer
            root.left.left.right = new TreeNode(i++);
            //4th layer
            root.left.left.right.left = new TreeNode(i++);
            root.left.left.right.right = new TreeNode(i);
        }
    }

    @Test
    public void preOrderTraversalTest() {
        System.out.println("\n\nrecursionPreOrderTraversal\n=================");
        TreeTraversal.recursionPreOrderTraversal(root);
        System.out.println("\n\npreOrderTraversal\n=================");
        TreeTraversal.preOrderTraversal(root);
    }

    @Test
    public void inOrderTraversalTest() {
        System.out.println("\n\nrecursionInOrderTraversal\n=================");
        TreeTraversal.recursionInOrderTraversal(root);
        System.out.println("\n\ninOrderTraversal\n=================");
        TreeTraversal.inOrderTraversal(root);
    }

    @Test
    public void postOrderTraversalTest() {
        System.out.println("\n\nrecursionPostOrderTraversal\n=================");
        TreeTraversal.recursionPostOrderTraversal(root);
        System.out.println("\n\npostOrderTraversal\n=================");
        TreeTraversal.postOrderTraversal(root);
    }
}