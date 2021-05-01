package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 9:55 下午
 */
//左旋转字符串
public class JZ43 {

    public static String LeftRotateString(String str, int n) {
        if (str.length() == 0) {
            return str;
        }
        int num = n % str.length();
        String result = "";
        String r1 = str.substring(0, n);
        System.out.println(r1);
        String r2 = str.substring(n, str.length());
        System.out.println(r2);

        result = r2 + r1;
        return result;
    }

    public static void main(String[] args) {

        String str = "abcXYZdef";
        int n = 3;

        System.out.println(LeftRotateString(str, n));

    }
}
