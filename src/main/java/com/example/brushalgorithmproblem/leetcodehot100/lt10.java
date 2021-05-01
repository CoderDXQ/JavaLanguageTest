package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/1 2:38 下午
 */
//正则表达式匹配
public class lt10 {

    //    动态规划 另一种解法是用搜索来做 具体看剑指offer
    public static boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

//                看看是否需要延伸匹配
                if (p.charAt(j - 1) == '*') {
//                    不匹配*
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
//                        f[i - 1][j]代表匹配星号
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
//                    本次是匹配的 具体结果继承匹配串之前字符的结果
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }

        return f[m][n];
    }

    //    判断是否匹配
    public static boolean matches(String s, String p, int i, int j) {

        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {

        String s = "aab";
        String p = "c*a*b";
        System.out.println(isMatch(s, p));

    }

}
