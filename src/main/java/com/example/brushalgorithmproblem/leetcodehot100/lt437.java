package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/28 12:02 下午
 */

//路径总和 III
public class lt437 {

    public static int result;

    //    递归方法 注意路径重复的情况
    public static int pathSum(TreeNode root, int sum) {

        result = 0;

        if (root != null) {
            dfsfind(root, sum);
        }

        return result;

    }

    public static void dfsfind(TreeNode root, int sum) {

        if (root == null) {
            return;
        }

        dfs(root, sum, root.val);

        dfsfind(root.left, sum);
        dfsfind(root.right, sum);

    }

    public static void dfs(TreeNode root, int sum, int curSum) {

        if (curSum == sum) {
            result++;
        }

        if (root.left != null) {
            dfs(root.left, sum, curSum + root.left.val);
        }

        if (root.right != null) {
            dfs(root.right, sum, curSum + root.right.val);
        }
    }


    //    前缀和
    public static int pathSum1(TreeNode root, int sum) {

        Map<Integer, Integer> prefixSumCount = new HashMap<>();

        prefixSumCount.put(0, 1);

        return recursionPathSum(root, prefixSumCount, sum, 0);

    }

    public static int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int curSum) {
        if (node == null) {
            return 0;
        }

        int res = 0;

        curSum += node.val;

//        看一下是否有前缀和为curSum-target的路径，此时的前缀和之差为target，说明找到了一条路
        res += prefixSumCount.getOrDefault(curSum - target, 0);

        prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) + 1);

//        继续向左右子树搜索
        res += recursionPathSum(node.left, prefixSumCount, target, curSum);
        res += recursionPathSum(node.right, prefixSumCount, target, curSum);

//        回溯 去除当前节点的前缀和数量 否则会影响下面的结点的dfs
        prefixSumCount.put(curSum, prefixSumCount.get(curSum) - 1);

        return res;
    }

    public static void main(String[] args) {

//        String[] tree = new String[]{"10", "5", "-3", "3", "2", null, "11", "3", "-2", null, "1"};
        String[] tree = new String[]{"1", null, "2", null, "3", null, "4", null, "5"};
        int sum = 3;
        System.out.println(pathSum(BinaryTreeUtils.create(tree), sum));
        System.out.println(pathSum1(BinaryTreeUtils.create(tree), sum));

    }

}
