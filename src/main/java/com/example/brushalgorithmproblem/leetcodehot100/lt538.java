package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/1 10:53 下午
 */
//把二叉搜索树转换为累加树
public class lt538 {

    public static int sum = 0;

    //    反序中序遍历
    public static TreeNode convertBST(TreeNode root) {
//        初始化
        sum = 0;

        return InverseInOrder(root);
    }

    public static TreeNode InverseInOrder(TreeNode root) {

        if (root != null) {
            InverseInOrder(root.right);
            sum += root.val;
            root.val = sum;
            InverseInOrder(root.left);
        }
        return root;

    }

    //    Morris遍历
    public static TreeNode convertBST1(TreeNode root) {

//        初始化
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
//            没有后继结点
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            } else {
//                找到node的后继结点
                TreeNode succ = getSuccessor(node);
//                没加过线索
                if (succ.left == null) {
//                    加线索
                    succ.left = node;
//                    继续往右走 目的是继续加线索
                    node = node.right;
                } else {
//                    加过线索  解除线索进行计算
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }

        return root;
    }

    //    找到node的后继结点
    private static TreeNode getSuccessor(TreeNode node) {
//        寻找右子树的最左节点
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 4, 1};

        TreeNode root = BinaryTreeUtils.create1(nums);

//        BinaryTreeUtils.layerOrder(convertBST(root));
        BinaryTreeUtils.layerOrder(convertBST1(root));

    }

}
