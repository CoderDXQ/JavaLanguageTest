package com.example.writtenexaminationandinterview.gongsibishi.duxiaoman;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/11 3:57 下午
 */
public class t1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
//        刚开始全是false
        boolean[] sign = new boolean[n + 1];
        int[] lights = new int[n + 1];
        int k = 1;

        while (m > 0) {

            int t = in.nextInt();

            for (; t <= n; t++) {
//                第一次关灯 只处理一次
                if (sign[t] == false) {
                    sign[t] = true;
                    lights[t] = k;
                }
            }
            k++;

            m--;
        }

        for (int i = 1; i <= n; i++) {
            if (i <= n - 1) {
                System.out.print(lights[i] + " ");
            } else {
                System.out.println(lights[i]);
            }

        }


    }

}
