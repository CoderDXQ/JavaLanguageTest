package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/17 3:02 下午
 */

//乘积最大子数组
public class lt152 {

    //    动态规划
    public static int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;


        return result;
    }

    //    暴力 时间不够了就这样写
    public static int maxProduct1(int[] nums) {
        int result = Integer.MIN_VALUE;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product = nums[i];
            result = Math.max(result, product);
            for (int j = i + 1; j < nums.length; j++) {
                product *= nums[j];
                result = Math.max(result, product);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }
}
