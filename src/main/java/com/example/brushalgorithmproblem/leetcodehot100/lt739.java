package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/28 11:46 上午
 */
//每日温度
public class lt739 {


    //    单调栈 栈里存放下标
    public static int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new LinkedList<Integer>();

        for (int i = 0; i < len; i++) {
            int temp = T[i];

//            遇到大于的情况就一次开始计算前面的
            while (!stack.isEmpty() && temp > T[stack.peek()]) {
                int pre = stack.poll();
                ans[pre] = i - pre;
            }
            stack.push(i);
        }
        return ans;
    }

    public static int[] dailyTemperatures1(int[] T) {
        int len = T.length;
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int out = stack.pop();
                ans[out] = i - out;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        for (int i : dailyTemperatures(T)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : dailyTemperatures1(T)) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
