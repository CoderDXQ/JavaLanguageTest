package com.example.brushalgorithmproblem.swordtooffer;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/22 5:35 下午
 */
public class JZ7 {
    public static void main(String[] args) {
        JZ7 solution = new JZ7();
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        System.out.println(n);
        System.out.println(solution.Fibonacci(n));
        System.out.println(solution.Fibonacci1(n));
        System.out.println(solution.Fibonacci2(n));
        System.out.println(solution.Fibonacci3(n));
    }

    //    动态规划
    public int Fibonacci(int n) {
        int[] array = new int[50];
        array[0] = 0;
        array[1] = 1;
        if (n <= 1) {
            return array[n];
        } else {
            for (int i = 2; i <= n; i++) {
                array[i] = array[i - 1] + array[i - 2];
            }
        }

        return array[n];
    }

    //递归
    public int Fibonacci1(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return Fibonacci1(n - 1) + Fibonacci1(n - 2);
    }

    //    优化存储
    public int Fibonacci2(int n) {
        if (n == 1 || n == 0) {
            return n;
        }

        int one = 0;
        int two = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }

    //    持续优化
    public int Fibonacci3(int n) {
        if (n == 1 || n == 0) {
            return n;
        }

//        这个赋值不能变  这里面有个先后关系在里面
        //核心是线性代数
        int two = 0;
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum += two;
            two = sum - two;
        }
        return sum;
    }

}


