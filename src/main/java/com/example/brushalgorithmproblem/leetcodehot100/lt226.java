package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/16 2:14 上午
 */

//翻转二叉树
public class lt226 {

    //    改进先序遍历
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        int[] tree = new int[]{4, 2, 7, 1, 3, 6, 9};
        BinaryTreeUtils.layerOrder(invertTree(BinaryTreeUtils.create1(tree)));
    }
}
