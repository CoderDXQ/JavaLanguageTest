package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/2 3:12 下午
 */

//最佳买卖股票时机含冷冻期
public class lt309 {

    //    状态DP
    public static int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;

//        f是手里的现金数
        int[][] f = new int[n][3];

//        初始化 刚开始就持有股票
        f[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
//            手上持有股票的最大收益
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);//昨天持有今天继续持有 或者昨天不在冷冻期，今天买入
//            手上不持有股票且在冷冻期的最大收益 即今天刚卖
            f[i][1] = f[i - 1][0] + prices[i];//今天刚卖
//            手上不持有股票求不在冷冻期的最大收益
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);//昨天处于冷冻期或者昨天不处于冷冻期
        }

//        最大收益的时候一定是全部卖出的时候
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

    //    空间优化
    public static int maxProfit1(int[] prices) {

        int n = prices.length;
        if (n == 0) {
            return 0;
        }

//        初始化
        int f0 = -prices[0], f1 = 0, f2 = 0;

        for (int i = 1; i < n; i++) {
//            手上持有股票
            int newf0 = Math.max(f0, f2 - prices[i]);
//            手上不持有股票且在冷冻期
            int newf1 = f0 + prices[i];
//            手上不持有股票且不在冷冻期
            int newf2 = Math.max(f1, f2);

            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }

//        要求最大收益 那手上一定不持有股票
        return Math.max(f1, f2);
    }


    public static void main(String[] args) {

        int[] prices = new int[]{1, 2, 3, 0, 2};

        System.out.println(maxProfit(prices));

        System.out.println(maxProfit1(prices));

    }

}
