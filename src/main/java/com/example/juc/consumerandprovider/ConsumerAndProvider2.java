package com.example.juc.consumerandprovider;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/4 10:19 下午
 */
//控制四个线程依次执行
public class ConsumerAndProvider2 {
    public static void main(String[] args) {

        Work2 work2 = new Work2();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    work2.methodA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    work2.methodB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    work2.methodC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    work2.methodD();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();

    }

}

class Work2 {
    /**
     * 线程工作流程：A->B->C->D->A
     */
    private int number = 1;

    Lock lock = new ReentrantLock();
    //    同步监视器
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    Condition condition4 = lock.newCondition();

    public void methodA() throws InterruptedException {

        lock.lock();
        try {
//            如果number是1就略过await()方法
            while (number != 1) {
//                使用同步监视器来让线程等待
                condition1.await();
            }

            number++;
            System.out.println(Thread.currentThread().getName() + "->" + number);
//            使用同步监视器唤醒其他线程
            condition2.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() throws InterruptedException {

        lock.lock();
        try {
//            如果number是2就略过await()方法
            while (number != 2) {
                condition2.await();
            }

            number++;
            System.out.println(Thread.currentThread().getName() + "->" + number);
//            使用同步监视器唤醒其他线程
            condition3.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodC() throws InterruptedException {

        lock.lock();
        try {
//            如果number是3就略过await()方法
            while (number != 3) {
                condition3.await();
            }

            number++;
            System.out.println(Thread.currentThread().getName() + "->" + number);
//            使用同步监视器唤醒其他线程
            condition4.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodD() throws InterruptedException {

        lock.lock();
        try {
//            如果number是4就略过await()方法
            while (number != 4) {
                condition4.await();
            }

            number = 1;
            System.out.println(Thread.currentThread().getName() + "->" + number);
//            使用同步监视器唤醒其他线程
            condition1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
