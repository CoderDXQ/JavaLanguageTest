package com.example.brushalgorithmproblem.swordtooffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/22 11:09 下午
 */
//从上往下打印二叉树
public class JZ22 {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = null;
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = null;
        treeNode.left.left.left = new TreeNode(2);
        treeNode.left.left.right = null;
        treeNode.left.left.left.left = new TreeNode(1);
        treeNode.left.left.left.right = null;


        //把这个方法写成静态就可以直接调用
        System.out.println(PrintFromTopToBottom(treeNode));
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        // while (queue.size() != 0) {
        while (!queue.isEmpty()) {
            //  System.out.println(queue);
            root = queue.poll();
            arrayList.add(root.val);

            if (root.left != null) {
                queue.offer(root.left);
            }

            if (root.right != null) {
                queue.offer(root.right);
            }
        }
        return arrayList;
    }

}
