package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/16 12:09 上午
 */

//二叉树的直径
public class lt543 {

    //    不正确的解法
    public static int diameterOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        这里是不对的 这里默认了最长路径过根节点 实际上是可以不过的
        return depth(root.left) + depth(root.right);
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    //    正确解法
    private static int result = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        初始化
        result = 0;
        return dosomething(root);
    }

    public static int dosomething(TreeNode root) {
        if (root == null) {
            return 0;
        }

        result = Math.max((depth(root.left) + depth(root.right)), result);

        dosomething(root.left);
        dosomething(root.right);

        return result;
    }

    //    简化思路
    private static int max = 0;

    public static int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        初始化
        max = 0;
//        启动子树的深度计算
        deep(root);
        return max;
    }

    //    计算子树的深度   加以改进，可以记录子树的直径
    public static int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = deep(root.left);
        int right = deep(root.right);
//        计算并维护遍历到每个节点时的树的最大深度
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        int[] tree = new int[]{1, 2};
        System.out.println(diameterOfBinaryTree(BinaryTreeUtils.create1(tree)));
        System.out.println(diameterOfBinaryTree1(BinaryTreeUtils.create1(tree)));
        System.out.println(diameterOfBinaryTree2(BinaryTreeUtils.create1(tree)));

    }

}