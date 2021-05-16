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


        return true;
    }

    //    记忆化回溯 DFS
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

    //    记忆化回溯 BFS
    public static boolean wordBreak2(String s, List<String> wordDict) {

        Queue<Integer> queue = new LinkedList<>();
        int len = s.length();
        mem = new boolean[10000];

        queue.offer(0);

        while (!queue.isEmpty()) {
            Integer start = queue.poll();

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
