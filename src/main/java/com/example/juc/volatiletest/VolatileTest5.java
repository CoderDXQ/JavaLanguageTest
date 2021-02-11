package com.example.juc.volatiletest;

import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/11 3:59 下午
 */
//保证可见性
public class VolatileTest5 {
    // 不加 volatile 程序就会死循环！
    // 加 volatile 可以保证可见性

    private volatile static int num = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            while (num == 0) {

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 1;
        System.out.println(num);
    }

}
