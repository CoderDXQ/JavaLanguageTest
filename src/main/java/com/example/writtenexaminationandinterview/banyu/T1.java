package com.example.writtenexaminationandinterview.banyu;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/25 8:20 下午
 */
public class T1 {

    public static String compressString(String str) {
        // write code here

        if (str == null) {
            return null;
        }

        if (str == "") {
            return str;
        }


        Character ch = null;
        int num = 0;

        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (ch == null) {
                ch = str.charAt(i);
                num++;
            } else if (ch.equals(str.charAt(i))) {
                num++;
            } else if (!ch.equals(str.charAt(i))) {
                result += ch;
                result += String.valueOf(num);
                ch = str.charAt(i);
                num = 1;
            }

            if (i == str.length() - 1) {
                result += ch;
                result += String.valueOf(num);

            }
        }

//        等号的情况表示没有变短 所以用原来的字符串
        if (result.length() >= str.length()) {
            return str;
        } else {
            return result;
        }

    }


    public static void main(String[] args) {

//        String str = "aabcccccaaab";
        String str = "aa";
        System.out.println(compressString(str));

    }
}



