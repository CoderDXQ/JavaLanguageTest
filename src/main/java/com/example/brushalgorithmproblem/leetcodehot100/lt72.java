package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.Arrays;

/**
 * @author duanxiangqing
 * @date 2021/5/19
 */
//编辑距离  编辑距离是一类问题
public class lt72 {

    //    记忆化搜索 从上到下进行搜索
    public static int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

//        特判
        if (m == 0 || n == 0) {//m*n==0
            return n + m;
        }

//        记忆数组
        int[][] mem = new int[n + 1][m + 1];

//        使用Arrays.fill()进行初始化  这个方法只能对一维数组进行操作
        for (int i = 0; i <= n; i++) {
            Arrays.fill(mem[i], -1);
        }

        return dfs(word1, 0, word2, 0, mem);
    }

    public static int dfs(String word1, int i, String word2, int j, int[][] mem) {

//        加速 对于已经存在的结果直接返回 避免重复计算
        if (mem[i][j] != -1) {
            return mem[i][j];
        }

        if (i == word1.length()) {
            return mem[i][j] = word2.length() - j;
        }

        if (j == word2.length()) {
            return mem[i][j] = word1.length() - i;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return mem[i][j] = dfs(word1, i + 1, word2, j + 1, mem);
        }

        return mem[i][j] = Math.min(dfs(word1, i + 1, word2, j + 1, mem), Math.min(dfs(word1, i + 1, word2, j, mem), dfs(word1, i, word2, j + 1, mem))) + 1;

    }

    //    动态规划
    public static int minDistance1(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

//        特判
        if (m == 0 || n == 0) {//m*n==0
            return n + m;
        }

        int[][] dp = new int[n + 1][m + 1];

//        初始化
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }

//        计算 dp(i, j)代表word1和word2的前缀子串(0->i-1)和(0->j-1) 字符串的下标是从0开始的
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
//                添加插入
//                从(i-1,j)的状态变为(i,j) word1添加字符
                int left = dp[i - 1][j] + 1;
//                从(i,j-1)的状态变为(i,j) word2添加字符
                int down = dp[i][j - 1] + 1;
//                替换
                int left_down = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
//                选取一种最优方案
                dp[i][j] = Math.min(Math.min(left_down, left), down);
            }
        }

        return dp[n][m];
    }

    //    动态规划 状态压缩优化
    public static int minDistance2(String word1, String word2) {


        return 0;
    }


    public static void main(String[] args) {

        String word1 = "horse";
        String word2 = "ros";

        String word11 = "intention";
        String word22 = "execution";

        System.out.println(minDistance(word1, word2));
        System.out.println(minDistance(word11, word22));

        System.out.println();

        System.out.println(minDistance1(word1, word2));
        System.out.println(minDistance1(word11, word22));

        System.out.println();

        System.out.println(minDistance2(word1, word2));
        System.out.println(minDistance2(word11, word22));

    }

}
