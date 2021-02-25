package com.example.brushalgorithmproblem.swordtooffer;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/25 7:01 下午
 */
public class JZ8 {

    //    递归
    private static Integer method1(Integer n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return method1(n - 1) + method1(n - 2);
    }

    //    递推或者动态规划
    private static Integer method3(Integer n) {
        Integer[] c = new Integer[n + 1];
        c[0] = 1;
        c[1] = 1;
        for (int i = 2; i <= n; i++) {
            c[i] = c[i - 1] + c[i - 2];
        }
        return c[n];
    }

    //    动态规划+滚动数组优化
    private static Integer method4(Integer n) {
        int a = 1, b = 1, c = 0;
        if (n == 1) {
            return 1;
        }

        for (int i = 2; i <= n; i++) {
//            方式一：
//            b = a + b;
//            c = b;
//            a = c - a;//或a=b-a;
//            方式二：
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();

        System.out.println(method1(n));
        System.out.println(method2(n));
        System.out.println(method3(n));
        System.out.println(method4(n));

    }


}
