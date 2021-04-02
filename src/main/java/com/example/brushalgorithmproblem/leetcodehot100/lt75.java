package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/30 6:32 下午
 */
//颜色分类
public class lt75 {

    //    两次遍历
    public static void sortColors(int[] nums) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, k, i);
                k++;
            }
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, k, i);
                k++;
            }
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //    一次遍历 覆盖
    public static void sortColors1(int[] nums) {

        int n1 = 0, n0 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nums[i] = 2;
            if (num < 2) {
                nums[n1++] = 1;
            }
            if (num < 1) {
                nums[n0++] = 0;
            }
        }

        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        sortColors1(nums);
    }

}
