package com.example.javalanguaguetest.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/2 2:09 上午
 */
public class WaitAndNotify {

    //    定义一把锁
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
//                设置同步代码块
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    try {
//                        使线程进入等待状态 释放相应的资源 释放锁
                        a.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i < 100; i += 2) {
//                设置同步代码块
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
//                    随机唤醒一个线程
                    a.notify();
                }

//                睡眠200毫秒的目的是为了等待thread1执行完毕并进入等待状态，此时再去获得锁
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
