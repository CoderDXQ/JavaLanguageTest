package com.example.brushalgorithmproblem.swordtooffer;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/24 2:07 上午
 */
public class JZ9 {
    //    进行数学推理
    //f(n)=f(n-1)+f(n-2)+...+f(2)+f(1+f(0)
    //f(n-1)=f(n-2)+...+f(2)+f(1+f(0)
    //f(n)=2*f(n-1)

    //    强转
    private static void method1(Integer n) {
        double p = Math.pow(2, n - 1);
        int i = (int) p;
        System.out.println(i);
    }

    private static void method2(Integer n) {
//        必须使用n+1 否则会超界
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                f[i] += f[j];
            }
        }
        System.out.println(f[n]);
    }

    //    位运算
    private static void method3(Integer target) {
        Integer i = 1;
        for (int k = 1; k <= target - 1; k++) {
            i <<= 1;
        }
        System.out.println(i);
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        method1(n);
        method2(n);
        method3(n);
    }
}
