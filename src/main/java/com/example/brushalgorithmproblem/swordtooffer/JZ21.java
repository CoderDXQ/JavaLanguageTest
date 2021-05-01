package com.example.brushalgorithmproblem.swordtooffer;

import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/2 7:11 下午
 */
//栈的压入、弹出序列
public class JZ21 {

    //    模拟 以弹出队列为基础顺序
    public static boolean IsPopOrder1(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();

//        用k来指示pushA中应该操作哪个元素
        int k = 1;
        stack.push(pushA[0]);
        for (int i = 0; i < popA.length; i++) {
            if (k >= pushA.length && popA[i] != stack.peek()) {
                return false;
            }
            if (stack.isEmpty() && k < pushA.length) {
                stack.push(pushA[k++]);
            }

            if (popA[i] == stack.peek()) {
                stack.pop();
                continue;
            } else {
                while (k < pushA.length && pushA[k] != popA[i]) {
                    stack.push(pushA[k++]);
                }
                if (k >= pushA.length && popA[i] != stack.peek()) {
                    return false;
                }
                if (pushA[k] == popA[i]) {
                    k++;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //    思路优化
    //    以入栈序列为基础顺序
    public static boolean IsPopOrder2(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();

        int k = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);

//            判空要放在前面 这跟逻辑运算的执行顺序有关
            while (!stack.empty() && stack.peek() == popA[k]) {
                stack.pop();
                k++;
            }
        }
//        如果stack中有元素，说明出栈顺序是错误的
        return stack.empty();
    }


    public static void main(String[] args) {
        int[] pushA = new int[]{1, 2, 3, 4, 5};
//        int[] popA = new int[]{4, 3, 5, 1, 2};
        int[] popA = new int[]{1, 2, 3, 4, 5};
//        int[] popA = new int[]{4, 5, 3, 2, 1};

        System.out.println(IsPopOrder1(pushA, popA));
        System.out.println(IsPopOrder2(pushA, popA));
    }
}
