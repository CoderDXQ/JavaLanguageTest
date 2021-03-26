package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/26 11:51 上午
 */
// 除自身以外数组的乘积
public class lt238 {

    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] out = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left[i] = nums[i];
                right[i] = nums[nums.length - 1];
            } else {
                left[i] = left[i - 1] * nums[i];
                right[i] = right[i - 1] * nums[nums.length - 1 - i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                out[i] = right[nums.length - 2 - i];
            } else if (i == nums.length - 1) {
                out[i] = left[nums.length - 2];
            } else {
                out[i] = left[i - 1] * right[nums.length - i - 2];
            }
        }
        return out;
    }

    //    优化思路 优化空间复杂度为O(1) 输出数组不算入空间复杂度
    public static int[] productExceptSelf1(int[] nums) {

        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int r = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * r;
            r = r * nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 1, 2};

        for (int i : productExceptSelf(nums)) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i : productExceptSelf1(nums)) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
