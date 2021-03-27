package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/28 12:44 上午
 */
//零钱兑换
public class lt322 {

    //    贪心 找到的并不一定是最优的 如：【1，10，7】 14
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int result = 0;
//        降序排序
        Integer[] newcoins = new Integer[coins.length];
        for (int i = 0; i < coins.length; i++) {
            newcoins[i] = coins[i];
        }
        Arrays.sort(newcoins, Collections.reverseOrder());
        for (int n : newcoins) {
            int div = amount / n;
            result += div;
            amount -= div * n;
        }

        return result != 0 && amount == 0 ? result : -1;
    }

    //    动态规划
    public static int coinChange1(int[] coins, int amount) {
        long[] dp = new long[amount + 1];
//        初始化
        Arrays.fill(dp, Integer.MAX_VALUE);
//        很重要的初始化
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
//            状态转移方程
            for (int c : coins) {
//                剪枝 判断
                if (c <= i) {
                    dp[i] = Math.min(dp[i - c] + 1, dp[i]);
                }
            }

        }
        return dp[amount] > amount ? -1 : (int) dp[amount];
    }

    //    DFS+贪心
    public static int ans;
    //    记忆化搜索用到的记忆数组
    public static int[][] rem;

    public static int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Integer[] newcoins = new Integer[coins.length];
        for (int i = 0; i < coins.length; i++) {
            newcoins[i] = coins[i];
        }
        Arrays.sort(newcoins, Collections.reverseOrder());

//        初始化
        ans = Integer.MAX_VALUE;
        rem = new int[amount + 1][coins.length + 1];
        for (int i = 0; i < rem.length; i++) {
            for (int j = 0; j < rem[0].length; j++) {
                rem[i][j] = Integer.MAX_VALUE;
            }
        }

        finds(newcoins, amount, 0, 0);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    //    超时 需要剪枝 使用记忆化搜索 记忆化也是一种剪枝
    private static void finds(Integer[] coins, int amount, int count, int index) {
        if (amount == 0) {
            ans = Math.min(ans, count);
            return;
        }

        if (index == coins.length) {
            return;
        }
        if (rem[amount][index] <= count) {
            return;
        }
//        从最贪婪的情况开始  然后逐渐释放最大面值的一枚硬币 这里面也有剪枝
        for (int k = amount / coins[index]; k >= 0 && k + count < ans; k--) {
            finds(coins, amount - k * coins[index], count + k, index + 1);
        }
        if (rem[amount][index] == 0) {
            rem[amount][index] = count;
        } else {
            rem[amount][index] = Math.min(rem[amount][index], count);
        }

    }


    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange1(coins, amount));
        System.out.println(coinChange2(coins, amount));

    }

}
