package com.example.brushalgorithmproblem.swordtooffer;

import java.util.ArrayList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/2 9:32 下午
 */
public class JZ24 {

    private static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Integer> list = new ArrayList<>();


    //    这个方法的路径定义：从根节点到任意节点
    public static ArrayList<ArrayList<Integer>> FindPath1(TreeNode root, int target) {
        if (root == null) {
            return result;
        }

        list.add(root.val);
        target -= root.val;
        if (target == 0) {
//            这个地方必须这么写  因为如果括号里用的是list，那么添加到result里面的实际是list的地址而不是数值 所以这里需要添加的是一个新的副本
            result.add(new ArrayList<>(list));
        }
        if (root.left != null) {
            FindPath(root.left, target);
        }
        if (root.right != null) {
            FindPath(root.right, target);
        }
//            回溯
        list.remove(list.size() - 1);
        target += root.val;

        return result;
    }

    //    这个方法的路径定义：从根节点到叶子节点
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }

        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.right == null && root.left == null) {
//            这个地方必须这么写  因为如果括号里用的是list，那么添加到result里面的实际是list的地址而不是数值 所以这里需要添加的是一个新的副本
            result.add(new ArrayList<>(list));
        }
        if (root.left != null) {
            FindPath(root.left, target);
        }
        if (root.right != null) {
            FindPath(root.right, target);
        }
//            回溯
        list.remove(list.size() - 1);
        target += root.val;

        return result;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{10, 5, 12, 4, 7};
        int target = 15;
        TreeNode root = BinaryTreeUtils.create1(arr);

        ArrayList<ArrayList<Integer>> out = FindPath(root, target);
        for (int i = 0; i < out.size(); i++) {
            ArrayList<Integer> s = out.get(i);
            for (int j = 0; j < s.size(); j++) {
                System.out.print(s.get(j) + " ");
            }
            System.out.println();
        }

//        BinaryTreeUtils.layerOrder(root);

    }
}
