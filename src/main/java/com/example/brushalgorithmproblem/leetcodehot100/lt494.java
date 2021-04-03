package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/26 9:37 下午
 */

//目标和
public class lt494 {

    public static int result = 0;

    //    枚举搜索
    public static int findTargetSumWays1(int[] nums, int S) {
        result = 0;
        dfs(nums, S, 0, 0);
        return result;
    }

    public static void dfs(int[] nums, int S, int sum, int index) {
        if (sum == S && index == nums.length) {
            result++;
            return;
        }

        if (index == nums.length) {
            return;
        }

        dfs(nums, S, sum + nums[index], index + 1);
        dfs(nums, S, sum - nums[index], index + 1);
    }

    //    动态规划 背包问题
    public static int findTargetSumWays2(int[] nums, int S) {
//        横坐标是商品  纵坐标是总和
        int[][] dp = new int[nums.length][2001];
//        初始化 防止刚开始好多零的情况
        dp[0][nums[0] + 1000] += 1;
        dp[0][-nums[0] + 1000] += 1;


        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
//            剪枝
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }

        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

    //    动态规划
    public static int findTargetSumWays(int[] nums, int S) {

        int[][] dp = new int[nums.length][2001];

        dp[0][nums[0] + 1000] += 1;
        dp[0][-nums[0] + 1000] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {

//                巧妙的数组下标越界处理
                int p = sum - nums[i] + 1000 < 0 ? 0 : dp[i - 1][sum - nums[i] + 1000];
                int q = sum + nums[i] + 1000 > 2000 ? 0 : dp[i - 1][sum + nums[i] + 1000];

                dp[i][sum + 1000] = p + q;

            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

    //    动态规划 空间优化
    public static int findTargetSumWays3(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] += 1;
        dp[-nums[0] + 1000] += 1;

        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }

            }
            dp = next;
        }

        return S > 1000 ? 0 : dp[S + 1000];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 999};
        int s = 998;
        System.out.println(findTargetSumWays(nums, s));
        System.out.println(findTargetSumWays1(nums, s));
        System.out.println(findTargetSumWays2(nums, s));
        System.out.println(findTargetSumWays3(nums, s));
    }
}
