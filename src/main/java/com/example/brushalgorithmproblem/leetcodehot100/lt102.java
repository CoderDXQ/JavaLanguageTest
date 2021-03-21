package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/21 3:25 下午
 */
//二叉树的层序遍历
public class lt102 {

    //    直接盲写一个
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> ans = new LinkedList<>();
//            k是当前这一层的元素个数
            int k = queue.size();
//            一次处理一层
            while (k > 0) {
                TreeNode node = queue.poll();
                ans.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                k--;
            }
            result.add(ans);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
