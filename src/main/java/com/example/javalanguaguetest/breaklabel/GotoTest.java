package com.example.javalanguaguetest.breaklabel;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/12 11:18 上午
 */
public class GotoTest {

    int i = 0;

    public static void main(String[] args) {
        GotoTest go1 = new GotoTest();

        Scanner in = new Scanner(System.in);
        int n = 10;

        read_data:
        {
            System.out.println("hello");
            while (n >= 6) {
                for (int i = 1; i >= 0; i++) {
                    System.out.println("Enter a number >=6: ");
                    n = in.nextInt();
                    System.out.println(n);
                    if (n < 6) {
                        go1.i = i;
                        //break语句跳到read_data标签末尾
                        break read_data;
                    }
                }
            }

            System.out.println("我不输出！");
        }
        System.out.println("输入次数：" + go1.i);
    }
}
