package com.example.brushalgorithmproblem.swordtooffer;

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
     * 建树
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
     * 先序遍历
     *
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root == null) {
            System.out.println("根为空");
            return;
        }

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
    public static void inOrer(TreeNode root) {
        if (root == null) {
            System.out.println("根为空");
            return;
        }

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
    public static void postOrer(TreeNode root) {
        if (root == null) {
            System.out.println("根为空");
            return;
        }

        if (root.left != null) {
            preOrder(root.left);
        }

        if (root.right != null) {
            preOrder(root.right);
        }

        System.out.println(root.val + " ");
    }

    public static void layerOrder(TreeNode root) {
        if (root == null) {
            System.out.println("根为空");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val + " ");
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }


}
