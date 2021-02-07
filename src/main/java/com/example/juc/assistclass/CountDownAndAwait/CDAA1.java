package com.example.juc.assistclass.CountDownAndAwait;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/2 4:14 下午
 */
public class CDAA1 {

    public static void countdown(int n) throws Exception {
        System.out.println("使用countDown():");
        CountDownLatch latch = new CountDownLatch(n);
        System.out.println(latch.getCount());

        new Thread(() -> {
            System.out.println("***********1");
            latch.countDown();
            System.out.println("1执行了countDown()");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("不会被输出！！！");
        }).start();
        new Thread(() -> {
            System.out.println("***********2");

//            这个sleep()方法执行完之后直接退出，不会再执行countDown()方法
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println("2执行了countDown()");

        }).start();
        new Thread(() -> {
            System.out.println("***********3");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println("3执行了countDown()");
        }).start();
        new Thread(() -> {
            System.out.println("***********4");
            latch.countDown();
            System.out.println("4执行了countDown()");
        }).start();
        new Thread(() -> {
            System.out.println("***********5");
            latch.countDown();
            System.out.println("5执行了countDown()");
        }).start();

        System.out.println(latch.getCount());
        latch.await();
        System.out.println("此时的计数为：" + latch.getCount());
        System.out.println("-------------------------------");
    }

    public static void usejoin(int n) throws InterruptedException {
        Thread[] ts = new Thread[n];
        for (int i = 0; i < n; i++) {
            ts[i] = new Thread(() -> {
                System.out.println("***********");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (int i = 0; i < n; i++) {
            ts[i].start();
        }

        for (int i = 0; i < n; i++) {
            ts[i].join();
        }

        System.out.println("----------------------------------------");
    }


    public static void main(String[] args) throws Exception {

//        输入的数字不要超过3
        countdown(3);
        System.out.println();
        System.out.println();


        Thread.sleep(2000);
        System.out.println("--------------------------------------------------------------------------------");
        usejoin(3);

    }
}
