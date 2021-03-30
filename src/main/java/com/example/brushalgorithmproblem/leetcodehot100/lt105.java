package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/30 9:18 上午
 */
public class lt105 {

    public static Map<Integer, Integer> indexMap;

    //  递归方法  使用Map加速查找
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
//            根据值找下标
            indexMap.put(inorder[i], i);
        }


        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {

        if (preorder_left > preorder_right) {
            return null;
        }

        int preroot = preorder_left;
//        找到中序遍历中根节点的下标
        int inroot = indexMap.get(preorder[preroot]);
        int size_left_subtree = inroot - inorder_left;

        TreeNode root = new TreeNode(preorder[preorder_left]);

        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inroot - 1);
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inroot + 1, inorder_right);

        return root;
    }


    public static void main(String[] args) {

        int[] proorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        BinaryTreeUtils.layerOrder(buildTree(proorder, inorder));

    }

}
