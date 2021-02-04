package com.example.juc.consumerandprovider;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/4 3:13 下午
 */
//使用Condition，精准的通知和唤醒线程
//    存在一个问题：四个线程的执行顺序是随机的
public class ConsumerAndProvider1 {
    public static void main(String[] args) {

        Work1 work1 = new Work1();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    work1.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    work1.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    work1.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    work1.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();


    }

}

class Work1 {
    private int number = 0;

    Lock lock = new ReentrantLock();
    //    同步监视器
    Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {

        lock.lock();
        try {
//            如果number是0就略过await()方法
            while (number != 0) {
                condition.await();
            }

            number++;
            System.out.println(Thread.currentThread().getName() + "->" + number);
//            使用同步监视器唤醒其他线程
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {

        lock.lock();
        try {
//            如果number是1就略过await()方法
            while (number == 0) {
                condition.await();
            }

            number--;
            System.out.println(Thread.currentThread().getName() + "->" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
