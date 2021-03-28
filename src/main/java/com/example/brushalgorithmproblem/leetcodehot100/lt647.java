package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/26 9:40 下午
 */

//回文子串
public class lt647 {


    //    分子串  然后检查子串是否是回文串即可 但是这种方法比较麻烦 这里先不写了

    //    中心扩展算法 需要分别考虑奇数串和偶数串的情况
    public static int countSubstrings(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            ans++;
//            奇数
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                ans++;
            }
//            偶数
            left = i - 1;
            right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                ans++;
            }
        }
        return ans;
    }

    //    动态规划 动态规划数组用于记录某个区间是否是回文子串  如果是ans++
    public static int countSubstrings1(String s) {

        int ans = 0;
//        便于计算
        char[] chs = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + len - 1;
                if (i < 0 || j < 0 || i >= s.length() || j >= s.length()) {
                    continue;
                }
                if (len == 1) {
                    dp[i][j] = true;
                } else if (len == 2) {
                    dp[i][j] = chs[i] == chs[j];
                } else {
                    dp[i][j] = chs[i] == chs[j] && dp[i + 1][j - 1];
                }

                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        String s = "abc";
        String ss = "aaa";

        System.out.println(countSubstrings(s));
        System.out.println(countSubstrings(ss));

        System.out.println();

        System.out.println(countSubstrings1(s));
        System.out.println(countSubstrings1(ss));

    }
}
