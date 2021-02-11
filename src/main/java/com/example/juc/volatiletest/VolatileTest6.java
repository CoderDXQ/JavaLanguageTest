package com.example.juc.volatiletest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/11 4:10 下午
 */

//解决volatile不保证原子性的问题的方法
public class VolatileTest6 {
    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add() {
//        底层原理是CAS
        num.getAndIncrement();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            System.out.println("存活的线程数：" + Thread.activeCount());
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + " " + num);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("存活的线程数：" + Thread.activeCount());
    }
}
