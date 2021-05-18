package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/19 12:19 上午
 */
//字符串解码
public class lt394 {

    //    辅助栈
    public static String decodeString(String s) {


        return null;
    }

    //    递归
    public static String decodeString1(String s) {

        return null;
    }

    public static void main(String[] args) {

        String s = "3[a]2[bc]";
        String s1 = "3[a2[c]]";
        String s2 = "2[abc]3[cd]ef";
        String s3 = "abc3[cd]xyz";

//        aaabcbc
        System.out.println(decodeString(s));
//        accaccacc
        System.out.println(decodeString(s1));
//        abcabccdcdcdef
        System.out.println(decodeString(s2));
//        abccdcdcdxyz
        System.out.println(decodeString(s3));

        System.out.println();

        System.out.println(decodeString1(s));
        System.out.println(decodeString1(s1));
        System.out.println(decodeString1(s2));
        System.out.println(decodeString1(s3));

    }

}
