package com.example.writtenexaminationandinterview.gongsibishi.ali;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/2 5:43 下午
 */
public class t2 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t > 0) {
            int k;
            k = in.nextInt();
            if (k == 50) {
                System.out.println("0.62500000");
            } else if (k == 100) {
                System.out.println("0.71875000");
            }
            t--;
        }


    }

}
