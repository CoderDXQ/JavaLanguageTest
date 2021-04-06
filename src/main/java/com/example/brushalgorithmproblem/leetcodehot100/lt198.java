package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/30 9:36 上午
 */
//打家劫舍
public class lt198 {

    //    动态规划
    public static int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    //    动态规划 路径压缩
    public static int rob1(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

//        注意顺序
        int before2 = nums[0];
        int before1 = Math.max(nums[0], nums[1]);
        int cur = Math.max(before1, before2);
        for (int i = 2; i < nums.length; i++) {
            cur = Math.max(before1, before2 + nums[i]);
            before2 = before1;
            before1 = cur;
        }

        return cur;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));

        System.out.println(rob1(nums));

    }

}
