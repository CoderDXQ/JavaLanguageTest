package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/15 12:22 上午
 */
public class lt20 {

    //    栈
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chs = s.toCharArray();

        for (char c : chs) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (c == '}') {
                if (stack.empty() || stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (c == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }

    //    替换迭代思想
    public static boolean isValid1(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
//        不能用 s=="" 因为这是两个字符串  存放地址是不同的
        return s.equals("");
    }


    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
        System.out.println(isValid1(s));
    }
}
