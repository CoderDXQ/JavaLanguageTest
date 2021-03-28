package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/28 11:46 上午
 */
//每日温度
public class lt739 {


    //    单调栈
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

    public static void main(String[] args) {

    }
}
