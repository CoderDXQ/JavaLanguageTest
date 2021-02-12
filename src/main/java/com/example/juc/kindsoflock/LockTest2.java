package com.example.juc.kindsoflock;

import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/12 10:48 上午
 */
public class LockTest2 {


    public static void main(String[] args) {

        Phone phone = new Phone();

        for (int i = 0; i < 10; i++) {
//            每个线程互相竞争锁
            new Thread(() -> {
                phone.sms();
            }, String.valueOf(i)).start();
        }

//        new Thread(() -> {
//            phone.sms();
//        }, "B").start();

    }
}

class Phone {

    public synchronized void sms() {
        System.out.println(Thread.currentThread().getName() + " sms");
//        如果能进去 就说明是可重入锁
        call();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + " call()");
    }

}

