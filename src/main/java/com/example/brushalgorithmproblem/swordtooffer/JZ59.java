package com.example.brushalgorithmproblem.swordtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 8:43 下午
 */
//按之字形顺序打印二叉树
public class JZ59 {

    //    改写层序遍历
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (pRoot == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;
        queue.offer(pRoot);

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (flag == true) {
                    list.add(node.val);
                } else {
                    stack.add(node.val);
                }
                size--;
            }

            while (!stack.empty()) {
                list.add(stack.pop());
            }

            flag = !flag;
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] trees = new int[]{8, 6, 10, 5, 7, 9, 11};

        TreeNode root = BinaryTreeUtils.create1(trees);

        ArrayList<ArrayList<Integer>> result = Print(root);

//        双重forEach嵌套
        result.forEach(re -> {
            re.forEach(r -> {
                System.out.print(r + " ");
            });
            System.out.println();
        });


    }
}
