package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/30 10:12 下午
 */

//任务调度器
public class lt621 {

    //    在模拟的基础上建立数学模型 本质上就是填充游戏  填充n 保证任意连续n个时间单位内没有重复的任务(可以用待命填充)
    public static int leastInterval(char[] tasks, int n) {

//        记录频次
        HashMap<Character, Integer> freq = new HashMap<>();

//        统计最多的单种任务执行次数并统计频次
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }

//        计算
        int countOfMax = 0;

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (maxExec == entry.getValue()) {
                countOfMax++;
            }
        }

//        每个任务行的长度为n+1(这个长度可以保证任意连续n个时间单位内没有重复的任务) 不够的用"待命"来填充  最后一行不需要填充，只需要执行countOfMax个任务即可
        return Math.max((n + 1) * (maxExec - 1) + countOfMax, tasks.length);
    }


    public static void main(String[] args) {

        char[] tasks = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 2;

        System.out.println(leastInterval(tasks, n));

    }


}
