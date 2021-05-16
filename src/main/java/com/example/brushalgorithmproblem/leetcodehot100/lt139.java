package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/30 9:30 上午
 */
//单词拆分
public class lt139 {

    public static boolean[] mem;

    //    动态规划
    public static boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();
        boolean[] dp = new boolean[len + 1];

//        初始化
        dp[0] = true;

        for (int i = 0; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
//                剪枝
                if (dp[i] == true) {
                    break;
                }
//                避免重复计算
                if (dp[j] == false) {
                    continue;
                }
                String suffix = s.substring(j, i);
                if (wordDict.contains(suffix) && dp[j]) {
                    dp[i] = true;
//                    剪枝
                    break;
                }
            }
        }

        return dp[len];
    }

    //    记忆化搜索 DFS
    public static boolean wordBreak1(String s, List<String> wordDict) {

        int len = s.length();
        mem = new boolean[10000];

        return dfs(s, wordDict, 0, len);

    }

    public static boolean dfs(String s, List<String> wordDict, int start, int len) {

        if (start == len) {
            return true;
        }

//        记忆化
        if (mem[start]) {
            return mem[start];
        }

//        检查所有可能的结果 如果有任何可能的情况就返回true
        for (int i = start + 1; i <= len; i++) {
            String prefix = s.substring(start, i);
            if (wordDict.contains(prefix) && dfs(s, wordDict, i, len)) {
                mem[start] = true;
                return true;
            }
        }

        mem[start] = false;
        return false;

    }

    //    记忆化搜索 BFS
    public static boolean wordBreak2(String s, List<String> wordDict) {

        Queue<Integer> queue = new LinkedList<>();
        int len = s.length();
        mem = new boolean[10000];

        queue.offer(0);

        while (!queue.isEmpty()) {
            Integer start = queue.poll();
//            标记优化
            if (mem[start]) {
                continue;
            }

            mem[start] = true;

            for (int i = start + 1; i <= len; i++) {
                String prefix = s.substring(start, i);
                if (wordDict.contains(prefix)) {
                    if (i < len) {
                        queue.offer(i);
                    } else {
                        return true;
                    }
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String[] a = new String[]{"leet", "code"};
        List<String> wordDict1 = new ArrayList<String>();
        for (String ss : a) {
            wordDict1.add(ss);
        }

        System.out.println(wordBreak(s, wordDict1));
        System.out.println(wordBreak1(s, wordDict1));
        System.out.println(wordBreak2(s, wordDict1));

    }

}
