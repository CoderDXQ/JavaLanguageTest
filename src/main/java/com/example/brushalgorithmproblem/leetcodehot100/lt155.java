package com.example.brushalgorithmproblem.leetcodehot100;


import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/26 9:27 下午
 */

//最小栈
public class lt155 {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    //  构造函数  辅助栈
    public lt155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.empty()) {
            minStack.push(Math.min(x, minStack.peek()));
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }


    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

        lt155 minStack = new lt155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
//        -3
        System.out.println(minStack.getMin());
        minStack.pop();
//        0
        System.out.println(minStack.top());
//        -2
        System.out.println(minStack.getMin());
    }
}
