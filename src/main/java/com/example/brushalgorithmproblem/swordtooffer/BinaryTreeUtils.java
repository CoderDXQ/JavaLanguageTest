package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/1 9:50 下午
 */

//二叉树相关的工具类 帮助刷题时的代码调试  提高速度和效率
public class BinaryTreeUtils {

    /**
     * 先序遍历
     *
     * @param root
     */
    private static void preOrder(TreeNode root) {

        System.out.println(root.val + " ");

        if (root.left != null) {
            preOrder(root.left);
        }

        if (root.right != null) {
            preOrder(root.right);
        }

    }

    /**
     * 中序遍历
     *
     * @param root
     */
    private static void inOrer(TreeNode root) {

        if (root.left != null) {
            preOrder(root.left);
        }

        System.out.println(root.val + " ");

        if (root.right != null) {
            preOrder(root.right);
        }

    }

    /**
     * 后序遍历
     *
     * @param root
     */
    private static void postOrer(TreeNode root) {

        if (root.left != null) {
            preOrder(root.left);
        }

        if (root.right != null) {
            preOrder(root.right);
        }

        System.out.println(root.val + " ");
    }


}
