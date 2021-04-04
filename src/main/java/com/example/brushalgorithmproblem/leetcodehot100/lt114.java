package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/30 9:20 上午
 */
//二叉树展开为链表
public class lt114 {

    //    原地算法 寻找前驱结点
//    转换为链表后 右指针就是next指针
    public static void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }

    //    迭代算法 出迭代需要的栈之外不需要额外的存储空间
    public static void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();

        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = cur;
            }

            TreeNode left = cur.left, right = cur.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            prev = cur;
        }

    }


    public static void main(String[] args) {

        String[] tree = new String[]{"1", "2", "5", "3", "4", null, "6"};
        TreeNode node = BinaryTreeUtils.create(tree);
        flatten(node);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.right;
        }
        System.out.println();

        String[] tree1 = new String[]{"1", "2", "5", "3", "4", null, "6"};
        TreeNode node1 = BinaryTreeUtils.create(tree1);
        flatten1(node1);
        while (node1 != null) {
            System.out.print(node1.val + " ");
            node1 = node1.right;
        }
        System.out.println();

    }

}
