package com.example.bishimianshi.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/30 6:38 下午
 */
public class t2 {

    /**
     * p>=50 去前面最大的那些
     * p<0  ???
     * p<50 ???
     *
     * @param args
     */

    public static String hhh(int n, int p, int[] a) {


        long sum = 0;
        if (p >= 50) {
            for (int i = 0; i < n; i++) {
                sum += (100 - p) * a[i];
            }
            for (int i = n; i < 2 * n; i++) {
                sum += p * a[i];
            }

        } else {
//            ???怎么处理？？？凑更多的相等？？？


        }

        if (n == 1) {
            sum = 0;
            if (p >= 50) {
                sum = Math.max(a[0] * p + a[1] * (100 - p), a[1] * p + a[0] * (100 - p));
            } else {
                sum = p * Math.max(a[0], a[1]) + (100 - p) * Math.min(a[0], a[1]);
            }
            if (sum % 100 == 0) {
                return String.valueOf(sum / 100);
            } else {
                return String.valueOf(sum) + "%";
            }
        } else {

            if (sum % 100 == 0) {
                return String.valueOf(sum / 100);
            } else {
                return String.valueOf(sum) + "%";
            }
        }

    }

    //    注意输出格式
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int p = in.nextInt();
        int[] a = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            a[i] = in.nextInt();
        }

        Arrays.sort(a);


        System.out.println(hhh(n, p, a));
//        System.out.println();

    }

}
