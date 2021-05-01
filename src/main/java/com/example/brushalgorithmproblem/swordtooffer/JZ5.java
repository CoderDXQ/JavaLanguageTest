package com.example.brushalgorithmproblem.swordtooffer;

import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/30 12:28 上午
 */
//用两个栈实现队列
public class JZ5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //    stack1用来push，stack2用来pop
    public void push(int node) {
        stack1.push(node);
    }

//    public int pop() {
//        if (!stack2.empty()) {
//            return stack2.pop();
//        } else {
//            if (!stack1.empty()) {
//                while (!stack1.empty()) {
//                    stack2.push(stack1.pop());
//                }
//                return stack2.pop();
//            } else {
//                return -1;
//            }
//
//        }
//    }

    //    优化逻辑
    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.empty()) {
            return -1;
        }
        return stack2.pop();
    }


    public static void main(String[] args) {

        JZ5 queue = new JZ5();

//        第一组测试 1 2 -1
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        System.out.println();

//        第二组测试 1 2 3 4 -1
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());


    }
}
