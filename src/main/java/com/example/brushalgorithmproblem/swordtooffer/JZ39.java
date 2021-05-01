package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 7:29 下午
 */
//平衡二叉树
//平衡树的规定：每个非叶节点的左右子树高度差都不能超过1
public class JZ39 {

    public static boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) == -1 ? false : true;
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

//        返回左子树的深度
        int left = depth(root.left);
        if (left == -1) {
            return -1;
        }
//        返回右子树的深度
        int right = depth(root.right);
        if (right == -1) {
            return -1;
        }
//        判断左右子树高度差
        if (Math.abs(left - right) > 1) {
            return -1;
        }

//        返回树的高度
        return 1 + Math.max(left, right);
    }


    public static void main(String[] args) {
        int[] trees = new int[]{1, 2, 3, 4, 5, 6, 7};

        TreeNode root = BinaryTreeUtils.create1(trees);

        System.out.println(IsBalanced_Solution(root));
    }
}
