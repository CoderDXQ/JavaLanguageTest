package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/28 12:05 下午
 */
//子集
public class lt78 {

    public static List<List<Integer>> result;

    //    回溯
    public static List<List<Integer>> subsets(int[] nums) {

        result = new ArrayList();

        List<Integer> list = new ArrayList<>();

        result.add(list);

        dfs(nums, 0, list);

        return result;
    }


    //    不需要回溯操作的回溯
    public static void dfs(int[] nums, int k, List<Integer> list) {
        if (k == nums.length) {
            return;
        }
        for (int i = k; i < nums.length; i++) {
            List<Integer> newlist = new ArrayList<>(list);
            newlist.add(nums[i]);
            result.add(newlist);
            dfs(nums, i + 1, newlist);
        }
    }


    //    二进制位  使用二进制位进行构造
//    一共有2的n次方种情况 可以用0~2^n的数来表示
    public static List<List<Integer>> subsets1(int[] nums) {
        result = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> list = new ArrayList<>();
            int k = i;
            for (int j = 0; j < nums.length; j++) {
                if ((k & 1) == 1) {
                    list.add(nums[j]);
                }
                k >>= 1;
            }
            result.add(list);
        }
        return result;
    }

    //    决策树遍历 在这个选择决策树上，不选是左节点，选是右节点
    public static List<List<Integer>> subsets2(int[] nums) {
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        dfs2(nums, 0, new ArrayList<>());
//        System.out.println(result.size());
        return result;
    }

    //    改写先序遍历
    public static void dfs2(int[] nums, int k, List<Integer> list) {
        if (k == nums.length) {
            return;
        }

        List<Integer> list1 = new ArrayList<>(list);
        result.add(list1);

        dfs2(nums, k + 1, list1);
        list1.add(nums[k]);
        dfs2(nums, k + 1, list1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        subsets(nums).forEach(a -> {
            a.forEach(b -> {
                System.out.print(b + " ");
            });
            System.out.println();
        });
        System.out.println();
        System.out.println();
        System.out.println("22222222222");

        subsets1(nums).forEach(a -> {
            a.forEach(b -> {
                System.out.print(b + " ");
            });
            System.out.println();
        });
        System.out.println();
        System.out.println();

        System.out.println("33333333");
        subsets2(nums).forEach(a -> {
            a.forEach(b -> {
                System.out.print(b + " ");
            });
            System.out.println();
        });
        System.out.println();
        System.out.println();

    }
}
