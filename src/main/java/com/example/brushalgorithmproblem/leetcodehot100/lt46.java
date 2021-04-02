package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/2 12:52 下午
 */
//全排列
public class lt46 {

    public static List<List<Integer>> result;

    //    回溯
    public static List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), flag);
        return result;
    }

    public static void dfs(int[] nums, List<Integer> list, boolean[] flag) {
        if (list.size() == nums.length) {
//            链表数组是地址引用 因此这个地方要new一个新的链表出来 否则回溯之后会丢失结果
            List<Integer> list1 = new ArrayList<>(list);
            result.add(list1);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == false) {
                list.add(nums[i]);
//                标记
                flag[i] = true;
                dfs(nums, list, flag);
//                回溯 回溯是两个步骤
                flag[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }


    //    调用next_permulation
    public static List<List<Integer>> permute3(int[] nums) {

        result = new ArrayList<>();

        int k = 1;
        int n = nums.length;
        while (n > 0) {
            k *= n--;
        }

        for (int i = 0; i < k; i++) {
            ArrayList list1 = new ArrayList<>();
            for (int node : nums) {
                list1.add(node);
            }
            result.add(list1);
            nextPermutation(nums);
        }
        return result;
    }

    //    有返回值的next_permulation
    public static int[] nextPermutation(int[] nums) {

        int k = nums.length - 2;
//        寻找最后边的第一个升序对 此时就找到了较小数
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }

//        找到右边的较大数
        if (k > -1) {
//        k的右边是一个降序序列
            int j = nums.length - 1;
            while (j > 0 && nums[j] <= nums[k]) {
                j--;
            }
            swap(nums, k, j);
        }

        reverse(nums, k + 1);

        return nums;
//        for (int i : nums) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int i) {
        int left = i, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};

        permute(nums).forEach(a -> {
            a.forEach(b -> {
                System.out.print(b + " ");
            });
            System.out.println();
        });
        System.out.println();

        permute3(nums).forEach(a -> {
            a.forEach(b -> {
                System.out.print(b + " ");
            });
            System.out.println();
        });
        System.out.println();

    }

}
