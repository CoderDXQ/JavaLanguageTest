package com.example.brushalgorithmproblem.swordtooffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/31 5:18 下午
 */
//二叉树的深度
public class JZ38 {
    public static class TreeNode {
        String val = null;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val='" + val + '\'' +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void create(TreeNode a1, TreeNode a2, TreeNode a3) {
        if (!a2.val.equals("#")) {
            a1.left = a2;
        }
        if (!a3.val.equals("#")) {
            a1.right = a3;
        }
    }


    //    层序遍历方法
//    public static int TreeDepth(TreeNode root) {
//        if (root == null) return 0;
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        int depth = 0;
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            depth++;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//        }
//        return depth;
//    }

    //        递归分治方法
    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        String[] tree = {"1", "2", "3", "4", "5", "#", "6", "#", "#", "7", "#"};
        TreeNode[] treeNodes = new TreeNode[tree.length];
        for (int i = 0; i < tree.length; i++) {
            treeNodes[i] = new TreeNode(tree[i]);
        }

        for (int i = 0; i < tree.length; i++) {
            System.out.println(treeNodes[i].toString());
        }


        for (int i = 0; i < tree.length / 2; i++) {
            create(treeNodes[i], treeNodes[i * 2 + 1], treeNodes[i * 2 + 2]);
        }

        System.out.println(TreeDepth(treeNodes[0]));
    }
}
