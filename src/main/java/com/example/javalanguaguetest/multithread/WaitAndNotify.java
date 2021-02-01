package com.example.javalanguaguetest.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/2 2:09 上午
 */
public class WaitAndNotify {

    final static CountDownLatch a = new CountDownLatch(1);

    public static void main(String[] args) {

        /**
         Thread thread0 = new Thread(() -> {
         for (int i = 0; i < 100; i += 2) {
         //                synchronized (a) {
         System.out.println(Thread.currentThread().getName() + ":" + i);
         //                    try {
         //                        a.wait();
         //                    } catch (InterruptedException e) {
         //                        e.printStackTrace();
         //                    }
         //                }
         }
         });
         **/

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i += 2) {
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    try {
                        a.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i < 100; i += 2) {
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    a.notify();
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

//        thread0.start();
        thread1.start();
        thread2.start();
    }
}
