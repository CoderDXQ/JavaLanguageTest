package com.example.writtenexaminationandinterview.inout;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 9:41 上午
 */
public class t5 {


//    https://ac.nowcoder.com/acm/contest/5652/E
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            int k = in.nextInt();
//            while (k > 0) {
//                while (in.hasNext()) {
//                    int n = in.nextInt();
//                    int sum = 0;
//                    while (n > 0) {
//                        sum += in.nextInt();
//                        n--;
//                    }
//                    System.out.println(sum);
//                }
//                k--;
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            int n = in.nextInt();
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += in.nextInt();
            }
            System.out.println(sum);
        }
    }

}
