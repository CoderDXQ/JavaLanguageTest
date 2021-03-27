package com.example.bishimianshi.inout;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 9:34 上午
 */
public class t3 {

    //    https://ac.nowcoder.com/acm/contest/5652/C
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(a + b);
        }
    }

}
