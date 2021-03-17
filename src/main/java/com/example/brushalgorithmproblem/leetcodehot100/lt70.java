package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/15 5:30 下午
 */

//爬楼梯
public class lt70 {


    //    动态规划
    public static int climbStairs(int n) {
        int result = 0, pre1 = 1, pre2 = 0;
        for (int i = 1; i <= n; i++) {
//            pre1是i-1时的结果 pre2是i-2时的结果
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }


    /**
     * 另外可以发现，这个数列是一个斐波那契数列
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 10;
        System.out.println(climbStairs(n));
    }
}
