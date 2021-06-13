package com.example.writtenexaminationandinterview.tips;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/14 12:53 上午
 */
//不使用中间变量交换两个数的值
public class Swap {
    public static void main(String[] args) {

        Integer a = 1024;
        Integer b = 2048;

        System.out.println("a = " + a + " b = " + b);

//        方法1:使用加减法
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a = " + a + " b = " + b);

        System.out.println();

        System.out.println("a = " + a + " b = " + b);
//        使用异或
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a + " b = " + b);

    }
}
