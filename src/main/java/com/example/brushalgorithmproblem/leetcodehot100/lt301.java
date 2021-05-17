package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.List;

/**
 * @author duanxiangqing
 * @date 2021/5/17
 */
//删除无效的括号
public class lt301 {

    //    回溯搜索DFS
    public static List<String> removeInvalidParentheses(String s) {

        return null;
    }

    //    BFS
    public static List<String> removeInvalidParentheses1(String s) {

        return null;
    }


    public static void main(String[] args) {

        String s1 = "()())()";
        String s2 = "(a)())()";
        String s3 = ")(";
        String s4 = "()())()";
        String s5 = "(a)())()";
        String s6 = ")(";

//        "()()()", "(())()"
        System.out.println(removeInvalidParentheses(s1));
//        "(a)()()", "(a())()"
        System.out.println(removeInvalidParentheses(s2));
//        ""
        System.out.println(removeInvalidParentheses(s3));
//        "(())()","()()()"
        System.out.println(removeInvalidParentheses(s4));
//        "(a())()","(a)()()"
        System.out.println(removeInvalidParentheses(s5));
//        ""
        System.out.println(removeInvalidParentheses(s6));

        System.out.println();

        //        "()()()", "(())()"
        System.out.println(removeInvalidParentheses1(s1));
//        "(a)()()", "(a())()"
        System.out.println(removeInvalidParentheses1(s2));
//        ""
        System.out.println(removeInvalidParentheses1(s3));
//        "(())()","()()()"
        System.out.println(removeInvalidParentheses1(s4));
//        "(a())()","(a)()()"
        System.out.println(removeInvalidParentheses1(s5));
//        ""
        System.out.println(removeInvalidParentheses1(s6));

    }

}
