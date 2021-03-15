package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/15 5:39 下午
 */
public class lt53 {

    //    动态规划
    public static int maxSubArray(int[] nums) {
        int result = nums[0], now = 0;
        for (int n : nums) {
//            考虑重开的情况 重开后的值是当前节点的值（不允许序列中没有元素）
            now = Math.max(now + n, n);
//            比较当前的和和历史最大和
            result = Math.max(result, now);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
