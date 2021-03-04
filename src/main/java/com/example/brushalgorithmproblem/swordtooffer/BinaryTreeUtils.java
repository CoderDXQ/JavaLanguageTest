package com.example.brushalgorithmproblem.swordtooffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/1 9:50 下午
 */

//二叉树相关的工具类 帮助刷题时的代码调试  提高速度和效率
public class BinaryTreeUtils {
    //    主函数是测试用的
    public static void main(String[] args) {
        String[] tree1 = new String[]{"8", "8", "#", "9", "#", "2", "#", "5"};
        TreeNode root1 = BinaryTreeUtils.create(tree1);
        layerOrder(root1);

    }

    /**
     * 建树 建树的数组中包含"#"的调用这个方法 传入的数组是字符串数组
     *
     * @param tree
     * @return
     */
    public static TreeNode create(String[] tree) {
        if (tree == null || tree.length == 0 || tree[0] == "#") {
            return null;
        }

//        创建二叉树的节点数组
        TreeNode[] binaryTree = new TreeNode[tree.length];
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == "#") {
                binaryTree[i] = null;
            } else {
                binaryTree[i] = new TreeNode(Integer.valueOf(tree[i]));
            }
        }

//        连接二叉树
        int k = 1;
        for (int i = 0; i < binaryTree.length; i++) {
            if (binaryTree[i] != null) {
                if (k < binaryTree.length) {
                    binaryTree[i].left = binaryTree[k++];
                }
                if (k < binaryTree.length) {
                    binaryTree[i].right = binaryTree[k++];
                }
            }
        }

        return binaryTree[0];
    }

    /**
     * 建树 传入的是整型数组
     *
     * @param tree
     * @return
     */
    public static TreeNode create1(int[] tree) {
        if (tree == null || tree.length == 0) {
            return null;
        }

//        创建二叉树的节点数组
        TreeNode[] binaryTree = new TreeNode[tree.length];
        for (int i = 0; i < tree.length; i++) {
            binaryTree[i] = new TreeNode(tree[i]);
        }

//        连接二叉树
        int k = 1;
        for (int i = 0; i < binaryTree.length; i++) {
            if (binaryTree[i] != null) {
                if (k < binaryTree.length) {
                    binaryTree[i].left = binaryTree[k++];
                }
                if (k < binaryTree.length) {
                    binaryTree[i].right = binaryTree[k++];
                }
            }
        }

        return binaryTree[0];
    }


    /**
     * 先序遍历
     *
     * @param root
     */
    public static void postOrder(TreeNode root) {
        if (root == null) {
            System.out.println("根为空");
            return;
        }

        if (root.left != null) {
            postOrer(root.left);
        }

        if (root.right != null) {
            postOrer(root.right);
        }

        System.out.print(root.val + " ");

    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void inOrder(TreeNode root) {
        if (root == null) {
            System.out.println("根为空");
            return;
        }

        if (root.left != null) {
            inOrder(root.left);
        }

        System.out.print(root.val + " ");

        if (root.right != null) {
            inOrder(root.right);
        }

    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public static void postOrer(TreeNode root) {
        if (root == null) {
            System.out.println("根为空");
            return;
        }

        if (root.left != null) {
            postOrer(root.left);
        }

        if (root.right != null) {
            postOrer(root.right);
        }

        System.out.print(root.val + " ");
    }

    public static void layerOrder(TreeNode root) {
        if (root == null) {
            System.out.println("根为空");
            return;
        }
//        java中队列使用链表实现
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                stack.offer(node.left);
            }
            if (node.right != null) {
                stack.offer(node.right);
            }
        }
        System.out.println();
    }


}
