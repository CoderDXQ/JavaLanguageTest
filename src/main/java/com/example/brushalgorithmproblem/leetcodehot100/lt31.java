package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/2 12:15 下午
 */

//下一个排列
public class lt31 {

    /**
     * 算法核心：将左边的较小数（位置i）与右边的较大数（位置j）交换，较小数尽量靠右，较大数尽可能小
     * 然后交换较大数和较小数 交换之后i后面是一个降序序列，需要再转换成升序序列
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {

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

        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();

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
        int[] nums = new int[]{3, 2, 1};
        nextPermutation(nums);
    }

}
