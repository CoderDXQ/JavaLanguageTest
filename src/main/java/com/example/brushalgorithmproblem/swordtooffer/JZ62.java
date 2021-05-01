package com.example.brushalgorithmproblem.swordtooffer;

import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/5 2:36 上午
 */
//二叉搜索树的第k个结点
public class JZ62 {


    public static TreeNode result = new TreeNode();
    public static int kk;

    //    使用递归的中序遍历
    public static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
//        初始化
        kk = k;
        result = null;
        inOrderForKthNode(pRoot);
        return result;
    }

    public static void inOrderForKthNode(TreeNode pRoot) {

        if (pRoot.left != null && kk > 0) {
            inOrderForKthNode(pRoot.left);
        }

        if (kk > 0) {
            kk--;
            if (kk == 0) {
                result = pRoot;
            }
        }

        if (pRoot.right != null && kk > 0) {
            inOrderForKthNode(pRoot.right);
        }
    }


    //    非递归的中序遍历 利用栈实现
    public static TreeNode KthNode1(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || pRoot != null) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
//            此时pRoot==null 所以需要弹栈
            pRoot = stack.pop();
//            System.out.println("k=" + k + " val=" + pRoot.val);
            if (--k == 0) {
//                System.out.println(pRoot.val);
                return pRoot;
            }
//            切换到右子树
            pRoot = pRoot.right;
        }

        return null;
    }


    public static void main(String[] args) {

        int[] trees = new int[]{5, 3, 7, 2, 4, 6, 8};
        int k = 3;

        TreeNode root = BinaryTreeUtils.create1(trees);

//        输出中序遍历
        BinaryTreeUtils.inOrder(root);
        System.out.println();

        System.out.println();

//        结果应该是4
        System.out.println(KthNode(root, k).val);

        System.out.println(KthNode1(root, k).val);

    }
}
