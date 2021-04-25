package com.example.writtenexaminationandinterview.gongsibishi.xiecheng;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/15 7:49 下午
 */

//建房问题  主要是找规律
//https://blog.csdn.net/qq_38993096/article/details/115742708
public class t2 {

//    可以考虑反着来建立映射关系

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String result = "R";
        while (n > 1) {
            String s = "";
            for (int i = 0; i < result.length(); i++) {
                if ((i & 1) == 0) {
                    s += "G";
                    s += result.charAt(i);
                    s += "R";
                } else {
                    s += result.charAt(i);
                }
            }
            result = s;
            n--;
        }

        System.out.println(result);
    }
}
