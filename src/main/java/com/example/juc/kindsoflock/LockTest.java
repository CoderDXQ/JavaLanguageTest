package com.example.juc.kindsoflock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/2 2:34 上午
 */
public class LockTest {

    //    可重入锁
    private Lock lock = new ReentrantLock();

    private void method(Thread thread) {
        lock.lock();

        try {
            System.out.println("线程名" + thread.getName() + "获得了锁");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("线程名" + thread.getName() + "释放了锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.method(Thread.currentThread());
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.method(Thread.currentThread());
            }
        }, "t2");

        t1.start();
        t2.start();

    }
}
