package com.example.brushalgorithmproblem.swordtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/31 4:48 下午
 */
//把二叉树打印成多行
public class JZ60 {


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void create(TreeNode a1, TreeNode a2, TreeNode a3) {
        a1.left = a2;
        a1.right = a3;
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) return list;
//        Queue的实现  LinkedList或者ArrayList
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> l = new ArrayList<Integer>();
            int num = queue.size();
            while (num > 0) {
                TreeNode s = (TreeNode) queue.poll();
                l.add(s.val);
                if (s.left != null) {
                    queue.add(s.left);
                }
                if (s.right != null) {
                    queue.add(s.right);
                }

                num--;
            }
            list.add(l);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);

        create(t1, t2, t3);
        create(t2, t4, t5);
        create(t3, t6, t7);

        System.out.println(Print(t1));
    }
}
