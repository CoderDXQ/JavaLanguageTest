package com.example.brushalgorithmproblem.swordtooffer;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/25 10:00 下午
 */
//矩形覆盖
public class JZ10 {

    //    多算几个情况发现就是个斐波那契数列  动态规划+滚动数组优化
    public static int rectCover(int target) {
        int n = target;
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
        System.out.println(rectCover(in.nextInt()));
    }
}
