package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.ArrayList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/21 6:28 下午
 */
//验证二叉搜索树
public class lt98 {

    //    改一下遍历  这样只能保证每个节点与其左右子树的大小关系  亲缘关系长了以后不能保证
//    public static boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        if (root.left != null && root.left.val >= root.val) {
//            return false;
//        }
//        if (root.right != null && root.right.val <= root.val) {
//            return false;
//        }
//
//        return isValidBST(root.left) &&  isValidBST(root.right);
//    }


    //    使用上下限来控制多代之间的大小关系
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long low, long hight) {


        if (root == null) {
            return true;
        }

        if (root.val >= hight || root.val <= low) {
            return false;
        }

        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, hight);
    }


    public static ArrayList<Integer> array;

    //    线索二叉树中序遍历的结果是严格有序的
    public static boolean isValidBST1(TreeNode root) {
        array = new ArrayList<>();
        inOrder(root);

        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) >= array.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        array.add(root.val);
        inOrder(root.right);
    }


    public static void main(String[] args) {

        String[] tree = new String[]{"5", "1", "4", null, null, "3", "6"};

        System.out.println(isValidBST(BinaryTreeUtils.create(tree)));
        System.out.println(isValidBST1(BinaryTreeUtils.create(tree)));

    }
}
