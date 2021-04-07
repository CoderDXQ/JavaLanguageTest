package com.example.writtenexaminationandinterview.inout;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 10:17 上午
 */

//注意使用long或者double
public class t11 {

    //    https://ac.nowcoder.com/acm/contest/5652/K
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            String[] st = in.nextLine().split(" ");
//            long sum = 0;
//            for (String s : st) {
////                注意数字超级大的情况
//                sum += Long.valueOf(s);
//            }
//            System.out.println(sum);
//        }
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(in.nextLong() + in.nextLong());
        }
    }

}
