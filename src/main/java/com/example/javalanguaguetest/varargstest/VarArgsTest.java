package com.example.javalanguaguetest.varargstest;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/29 12:49 上午
 */


public class VarArgsTest {

    public static void main(String args[]) {
        // 使用变量参数调用方法
        printMax(314, 321, 213, 212, 356.5);//整型数据会被强转
        printMax(new double[]{1, 2, 3});//这里的变量类型与方法的定义必须相同
    }

    public static void printMax(double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No argument passed");
            return;
        }

        double result = numbers[0];

        for (int i = 1; i < numbers.length; i++)
            if (numbers[i] > result)
                result = numbers[i];
        System.out.println("参数列表中的最大值是：" + result);
    }
}
