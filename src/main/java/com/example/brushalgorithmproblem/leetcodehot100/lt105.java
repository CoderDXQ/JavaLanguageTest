package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/30 9:18 上午
 */
public class lt105 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {


        return null;
    }

    public static void main(String[] args) {

        int[] proorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        BinaryTreeUtils.layerOrder(buildTree(proorder, inorder));

    }

}
