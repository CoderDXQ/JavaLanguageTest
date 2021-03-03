package com.example.brushalgorithmproblem.swordtooffer;

import sun.nio.cs.ext.MacArabic;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/3 10:27 下午
 */
public class JZ30 {

    public static int FindGreatestSumOfSubArray1(int[] array) {

        int max = array[0];
//        array[i - 1]存储之前的连续子序列和 如果这个和<0就直接放弃重开  维护max保持每个子序列的最大和
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i] + (array[i - 1] > 0 ? array[i - 1] : 0);
//            array[i]+=array[i - 1] > 0 ? array[i - 1] : 0;
            max = Math.max(array[i], max);
        }

        return max;
    }

    //    dp[]数组记录到当前下标为止的当前子序列的当前和
    //    状态转移方程：dp[i] = max{dp[i-1]+array[i],array[i]} 数组中的每个元素都在做一个选择：是否与之前的连续子序列相加
    public static int FindGreatestSumOfSubArray(int[] array) {
        int dp[] = new int[array.length];

        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            if (dp[i - 1] < 0) {
//                重开新的子序列
                dp[i] = array[i];
            } else {
                dp[i] = dp[i - 1] + array[i];
            }

            max = Math.max(max, dp[i]);
        }

        return max;

    }


    public static void main(String[] args) {
        int[] array = new int[]{1, -2, 3, 10, -4, 7, 2, -5};

        System.out.println(FindGreatestSumOfSubArray(array));
    }
}
