package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/2 3:58 下午
 */
//二叉树的镜像
public class JZ18 {

    public static TreeNode Mirror(TreeNode pRoot) {

        if (pRoot == null) {
            return null;
        }
//        使用无参构造
        TreeNode temp = new TreeNode();
        temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;

        Mirror(pRoot.left);
        Mirror(pRoot.right);

        return pRoot;
    }

    public static void main(String[] args) {
        int[] tree = new int[]{8, 6, 10, 5, 7, 9, 11};
        TreeNode root = BinaryTreeUtils.create1(tree);
        BinaryTreeUtils.layerOrder(root);

        Mirror(root);
        BinaryTreeUtils.layerOrder(root);
    }
}
