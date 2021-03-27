package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/26 8:07 下午
 */

//不同路径
public class lt62 {

    //    动态规划
    public static int uniquePaths(int m, int n) {
        int[][] flag = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    flag[i][j] = 1;
                } else if (i == 0) {
                    flag[i][j] = flag[i][j - 1];
                } else if (j == 0) {
                    flag[i][j] = flag[i - 1][j];
                } else {
                    flag[i][j] = flag[i - 1][j] + flag[i][j - 1];
                }
            }
        }
        return flag[m - 1][n - 1];
    }


    //    组合数学
    public static int uniquePaths1(int m, int n) {
        m--;
        n--;
//        int类型长度不够
        long result = 1;
        long he = m + n;
        long min = Math.min(m, n);
        long max = Math.max(m, n) + min;
        for (int k = 0; k < min; k++, max--) {
            result *= max;
        }
        for (; min > 0; min--) {
            result /= min;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        int m = 10, n = 10;
        System.out.println(uniquePaths(m, n));
        System.out.println(uniquePaths1(m, n));
    }
}
