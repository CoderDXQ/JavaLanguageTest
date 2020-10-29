package com.example.javalanguaguetest.loop;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/29 4:33 下午
 */
public class LoopTest {
    public static void main(String[] args) {
        String array[] = {"sdfsd", "dgdfgd", "dfgdfg"};
        //数组的两种遍历方式 for-each循环
        for (String x : array) {
            System.out.println(x);
        }

        System.out.println("\n");

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("\n");

        //do while循环
        int x = 21;
        do {
            // The line will be printed even
            // if the condition is false
            System.out.println("Value of x:" + x);
            x++;
        }
        while (x < 20);

        System.out.println("\n");


    }
}
