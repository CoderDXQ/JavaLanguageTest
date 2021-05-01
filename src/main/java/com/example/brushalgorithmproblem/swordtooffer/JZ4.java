package com.example.brushalgorithmproblem.swordtooffer;

import java.util.Arrays;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/25 8:00 下午
 */
//重建二叉树
public class JZ4 {

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
//        退出条件
        if (pre.length == 0 || in.length == 0) {
            return null;
        }

//        if (pre.length == 1 || in.length == 1) {
//            return new TreeNode(pre[0]);
//        }

        TreeNode root = new TreeNode(pre[0]);

        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
//                copyOfRange()在截取时是左闭右开的
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
//                剪枝
                break;
            }
        }

        return root;
    }

    public static void print(TreeNode root) {
        System.out.println(root.val + " ");
        if (root.left != null) {
            print(root.left);
        }
        if (root.right != null) {
            print(root.right);
        }
    }


    public static void main(String[] args) {

//        [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
        int[] pre = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] in = new int[]{3, 2, 4, 1, 6, 5, 7};

//        int[] a=Arrays.copyOfRange(pre,0,3);
//        System.out.println(a.length);
//        for(int i=0;i<a.length;i++){
//            System.out.println(a[i]);
//        }

//        结果是这个
//        {1,2,5,3,4,6,7}
        print(reConstructBinaryTree(pre, in));
    }
}
