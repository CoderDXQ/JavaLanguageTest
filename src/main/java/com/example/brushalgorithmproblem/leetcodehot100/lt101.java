package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/16 10:52 上午
 */

//对称二叉树
public class lt101 {

    //    递归
    public static boolean isSymmetric(TreeNode root) {

        return check(root.left, root.right);

    }

    public static boolean check(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.val == root2.val && check(root1.left, root2.right) && check(root1.right, root2.left);
    }

    //    迭代 使用栈来模拟递归过程
    public static boolean isSymmetric1(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.empty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }


    public static void main(String[] args) {
        int[] tree = new int[]{1, 2, 2, 3, 4, 4, 3};
        System.out.println(isSymmetric(BinaryTreeUtils.create1(tree)));
        System.out.println(isSymmetric1(BinaryTreeUtils.create1(tree)));
    }

}
