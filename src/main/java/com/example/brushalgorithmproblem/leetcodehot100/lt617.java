package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/15 11:27 下午
 */

//合并二叉树
public class lt617 {

    //    更改先序遍历 默认更改后返回root1
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
//        先合并根节点
        root1.val += root2.val;

//        必须要在这里赋值才有效  递归进去之后的变量同名但是不是同一个
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    public static void main(String[] args) {
        int[] tree1 = new int[]{1, 3, 2, 5};
        String[] tree2 = new String[]{"2", "1", "3", "#", "4", "#", "7"};

        BinaryTreeUtils.layerOrder(mergeTrees(BinaryTreeUtils.create1(tree1), BinaryTreeUtils.create(tree2)));

    }
}
