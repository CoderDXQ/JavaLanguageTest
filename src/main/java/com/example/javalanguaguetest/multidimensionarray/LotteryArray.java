package com.example.javalanguaguetest.multidimensionarray;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/12 8:04 下午
 */

//不规则矩阵
public class LotteryArray {
    public static void main(String[] args) {
        final int NMAX = 10;
        //此时只有行的长度
        int[][] odds = new int[NMAX + 1][];
        //此时有了列的长度
        for (int n = 0; n <= NMAX; n++)
            odds[n] = new int[n + 1];

        for (int n = 0; n < odds.length; n++)
            for (int k = 0; k < odds[n].length; k++) {
                int lotteryOdds = 1;
                for (int i = 1; i <= k; i++)
                    lotteryOdds = lotteryOdds * (n - i + 1) / i;
                odds[n][k] = lotteryOdds;
            }

        for (int[] row : odds) {
            for (int odd : row)
                System.out.printf("%4d", odd);
            System.out.println();
        }

    }
}
