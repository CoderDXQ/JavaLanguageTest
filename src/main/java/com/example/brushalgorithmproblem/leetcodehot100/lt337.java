package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/4 8:42 下午
 */
//打家劫舍III
public class lt337 {

    //    动态规划  树形DP
    public static int rob(TreeNode root) {

        return 0;
    }

    //    记忆化搜索
    public static int rob1(TreeNode root) {

        return 0;
    }

    public static void main(String[] args) {

        TreeNode root = BinaryTreeUtils.create(new String[]{"3", "2", "3", null, "3", null, "1"});
        TreeNode root1 = BinaryTreeUtils.create(new String[]{"3", "4", "5", "1", "3", null, "1"});

        System.out.println(rob(root));
        System.out.println(rob(root1));

        System.out.println();

        System.out.println(rob1(root));
        System.out.println(rob1(root1));

    }

}
