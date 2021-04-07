package com.example.writtenexaminationandinterview.inout;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 9:37 上午
 */
public class t4 {

    //    https://ac.nowcoder.com/acm/contest/5652/D
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            int sum = 0;
            while (n > 0) {
                sum += in.nextInt();
                n--;
            }
            System.out.println(sum);
        }

    }

}
