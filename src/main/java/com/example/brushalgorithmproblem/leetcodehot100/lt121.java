package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/15 4:04 下午
 */

//买卖股票的最佳时机
public class lt121 {

    //    单调栈方法的核心也是在遍历到每一天的价格时能够获取历史最低价格  实际上只需要维护一个minPrice就可以 不必使用单调栈
    public static int maxProfit(int[] prices) {
        int profit = 0, minPrice = Integer.MAX_VALUE;

        for (int p : prices) {
            if (minPrice > p) {
                minPrice = p;
            }
            if (profit < p - minPrice) {
                profit = p - minPrice;
            }
        }
        return profit;
    }

    //    动态规划 转换为最大区间和问题
    public static int maxProfit1(int[] prices) {
        int profit = 0, pre = 0;

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
//            累计之前的利润  或者重新计算
            pre = Math.max(pre + diff, 0);
            profit = Math.max(pre, profit);
        }
        return profit;
    }


    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));

        System.out.println(maxProfit1(prices));

    }
}
