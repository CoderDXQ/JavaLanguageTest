package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/23 11:47 下午
 */
//最长回文子串
public class lt5 {

    //    动态规划
    public static String longestPalindrome(String s) {
        if (s == "" || s.length() == 1) {
            return s;
        }
        int n = s.length();
//        转化成字符串可以减少代码量
        char[] chs = s.toCharArray();
        String ans = "";
//        状态数组
        boolean[][] flag = new boolean[n][n];

//        遍历子串长度-1(最左最右字符的间隔)
        for (int l = 0; l < n; l++) {
//            遍历起始点
            for (int left = 0; left + l < n; left++) {
//                子串只有一个元素
                if (l == 0) {
                    flag[left][left] = true;
                }
//                子串只有两个元素
                if (l == 1) {
                    flag[left][left + l] = chs[left] == chs[left + l];
                }
                if (l > 1) {
                    flag[left][left + l] = flag[left + 1][left + l - 1] && chs[left] == chs[left + l];
                }
//                l+1才是子串的长度
                if (l + 1 > ans.length() && flag[left][left + l]) {
                    ans = s.substring(left, left + l + 1);
                }
            }
        }
        return ans;
    }

    //    中心扩展算法
    public static String longestPalindrome1(String s) {
        if (s == "" || s.length() == 1) {
            return s;
        }
        String ans = "";
        int max = Integer.MIN_VALUE;
        int result1 = 0, result2 = 0;
        for (int i = 1; i < s.length(); i++) {
//            回文串分两种情况  偶数个元素和奇数个元素
            if (i - 1 >= 0 && s.charAt(i) == s.charAt(i - 1)) {
                result1 = check(i - 2, i + 1, 2, s);
            }
            if (i - 1 >= 0 && (i + 1 <= s.length() - 1) && s.charAt(i - 1) == s.charAt(i + 1)) {
                result2 = check(i - 1, i + 1, 1, s);
            }
            if (max < result1) {
                max = result1;
                ans = s.substring(i - result1 / 2, i + result1 / 2);
            }
            if (max < result2) {
                max = result2;
                ans = s.substring(i - result2 / 2, i + result2 / 2 + 1);
            }
        }
        if (ans.length() > 1) {
            return ans;
        }
        return s.substring(0, 1);
    }

    public static int check(int left, int right, int result, String s) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            result += 2;
            left--;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {

        String s = "babbad";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome1(s));

    }
}
