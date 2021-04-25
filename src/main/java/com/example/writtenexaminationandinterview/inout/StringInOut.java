package com.example.writtenexaminationandinterview.inout;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/25 10:44 下午
 */
public class StringInOut {

    //    字符串的输入输出
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String start = in.nextLine();

        while (in.hasNext()) {
            String s = in.nextLine();
            System.out.println(s);
        }

    }

}
