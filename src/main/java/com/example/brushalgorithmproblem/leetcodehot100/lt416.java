package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/28 12:04 下午
 */
//分割等和子集
public class lt416 {

    //    动态规划 0-1背包问题
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int i : nums) {
            sum += i;
            maxNum = Math.max(maxNum, i);
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum >> 1;
        if (maxNum > target) {
            return false;
        }

//        第一个坐标是物品编号  第二个坐标是背包容量
        boolean[][] dp = new boolean[n][target + 1];
//        初始化
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

//        初始化
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
//                         不放这个物品且容量刚好   放这个物品且容量刚好
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][target];
    }

    //    思路优化
    public static boolean canPartition1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int i : nums) {
            sum += i;
            maxNum = Math.max(maxNum, i);
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum >> 1;
        if (maxNum > target) {
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
//            只能是从大到小遍历  因为如果从小到大遍历的话某个dp[j - nums[i]]的值可能已经添加过第i个物品了
            for (int j = target; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition1(nums));
    }
}
