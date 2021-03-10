package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 9:38 下午
 */
public class JZ44 {

    public static String ReverseSentence(String str) {

        String result = "";
        String[] split = str.split(" ");

        if (split.length == 0) {
            return str;
        }

        for (String st : split) {
            result = st + " " + result;
        }

//        去掉末尾的空格
        return result.trim();
    }

    public static void main(String[] args) {

        System.out.println(ReverseSentence("nowcoder. a am I"));

    }
}
