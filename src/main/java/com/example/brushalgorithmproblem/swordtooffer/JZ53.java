package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/12 8:59 下午
 */
//表示数值的字符串
public class JZ53 {

    /**
     * 判断条件：
     * 1. 不能有多个"."或者"e"
     * 2. e,E都可以
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        char[] str1 = str.toCharArray();
        boolean sign = false, decimal = false, hasE = false;
//        判非
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == 'e' || str1[i] == 'E') {
                if (i == str1.length - 1) {
                    return false;
                }
                if (hasE) {
                    return false;
                }
                hasE = true;
            } else if (str1[i] == '+' || str1[i] == '-') {
//                第二个正负号只能出现在e/E后面
                if (sign && str1[i - 1] != 'e' && str1[i - 1] != 'E') {
                    return false;
                }
//                第一个正负号如果不在首位那么就只能出现在e/E后面
                if (!sign && i > 0 && str1[i - 1] != 'e' && str1[i - 1] != 'E') {
                    return false;
                }
//                第一个正负号使sign变为true
                sign = true;
            } else if (str1[i] == '.') {
//                e/E和小数点后面不能再出现小数点 e/E后面只能是整数 第一个小数点后面也只能是整数
                if (hasE || decimal) return false;
                decimal = true;
            } else if (str1[i] < '0' || str1[i] > '9') {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

//        true
        System.out.println(isNumeric("123.45e+6"));

//        false
        System.out.println(isNumeric("1.2.3"));

    }
}
