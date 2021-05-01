package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/1 9:20 下午
 */
//最长有效括号
public class lt32 {

    //    栈
    public static int longestValidParentheses(String s) {

        int maxans = 0;
        Stack<Integer> stack = new Stack<>();

//        垫底
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
//                巧妙
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }

        return maxans;
    }

    //    动态规划
    public static int longestValidParentheses1(String s) {

        int maxans = 0;

        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {

                if (s.charAt(i - 1) == '(') {
//                累加
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
//                     不是在开头             本次又能配对
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//                dp[i-1]记录前一个字符的最大配对长度  看看能不能合并之前更长的
                    dp[i] = dp[i - 1] + ((i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0)) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }

        return maxans;
    }

    //    模拟
    public static int longestValidParentheses2(String s) {

        int left = 0, right = 0, maxlength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }

//        为了避免"(()"的情况 需要反向再来一遍
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
//                这里的判断条件与上面是相反的
            } else if (left > right) {
                left = right = 0;
            }
        }

        return maxlength;
    }


    public static void main(String[] args) {

//        String s = ")()())";
        String s = "()(())";

        System.out.println(longestValidParentheses(s));
        System.out.println();
        System.out.println(longestValidParentheses1(s));
        System.out.println();
        System.out.println(longestValidParentheses2(s));

    }

}
