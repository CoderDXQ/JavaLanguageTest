package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/15 5:02 下午
 */
public class lt104 {

    //    深度遍历 DFS
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        int[] trees = new int[]{1, 2, 2, 3, 4, 4, 3};

//        3
        System.out.println(maxDepth(BinaryTreeUtils.create1(trees)));
    }
}
