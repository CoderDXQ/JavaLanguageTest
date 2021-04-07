package com.example.writtenexaminationandinterview.inout;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 9:32 上午
 */
public class t2 {

//    https://ac.nowcoder.com/acm/contest/5652/B
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
            n--;
        }
    }

}
