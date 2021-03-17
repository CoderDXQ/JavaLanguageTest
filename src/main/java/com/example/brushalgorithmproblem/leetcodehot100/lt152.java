package com.example.brushalgorithmproblem.leetcodehot100;

import com.example.datastructure.sort.QuickSort;

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
//        进行乘法运算就要赋值为1
        int min = 1;
        int max = 1;
//        因为存在正负值的情况 所以要维护最大和最小两个值(维护绝对值最大的情况)
        for (int n : nums) {
//            这一步可能造成后来的max小于之前的max 所以需要result
            if (n < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(n, n * min);
            max = Math.max(n, n * max);
            result = Math.max(result, max);
        }
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
        System.out.println(maxProduct1(nums));
    }
}
