package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/21 5:56 下午
 */
//二叉树中的最大路径和
public class lt124 {

    public static int maxValue;

    //    更改一下后序遍历
    public static int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        jisun(root);
        return maxValue;
    }

    public static int jisun(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(jisun(root.left), 0);
        int right = Math.max(jisun(root.right), 0);
//        某个节点的最大路径和 如果某个节点的路径中没有这个结点  那这条路径就一分为二了
        int sum = left + right + root.val;
        maxValue = Math.max(sum, maxValue);
//        返回的时候只能返回左右子树的一边路径 因为可能还要跟根节点的右子树的一条线连接
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {

        int[] tree0 = new int[]{1, 2, 3};
        String[] tree1 = new String[]{"-10", "9", "20", null, null, "15", "7"};

        System.out.println(maxPathSum(BinaryTreeUtils.create1(tree0)));
        System.out.println(maxPathSum(BinaryTreeUtils.create(tree1)));
    }
}
