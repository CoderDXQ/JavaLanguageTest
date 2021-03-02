package com.example.brushalgorithmproblem.swordtooffer;

import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/2 5:07 下午
 */
public class JZ20 {

    //    伴随栈方法
    private static Stack<Integer> stack = new Stack<Integer>();
    private static Stack<Integer> minStack = new Stack<Integer>();

    private void push(int node) {
        if (stack.isEmpty()) {
            stack.push(node);
            minStack.push(node);
        } else {
            if (node < minStack.peek()) {
                minStack.push(node);
            } else {
                minStack.push(minStack.peek());
            }
            stack.push(node);
        }
    }

    private void pop() {
        stack.pop();
        minStack.pop();
    }

    private int top() {
//        peek不会弹出元素
        return stack.peek();
    }

    private int min() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        JZ20 test = new JZ20();
        test.push(4);
        test.push(3);
        test.push(2);
        test.push(1);
        test.push(5);
        test.push(6);

//        1
        System.out.println(test.min());
        test.pop();
//        1
        System.out.println(test.min());
        test.pop();
        test.pop();
//        2
        System.out.println(test.min());
    }

}
