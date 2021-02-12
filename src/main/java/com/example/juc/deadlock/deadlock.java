package com.example.juc.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/12 12:16 下午
 */

/**
 * 死锁问题排查：
 * jps -l 定位进程号
 * jstack 进程号 找到死锁问题
 * <p>
 * 另外还可通过日志和堆栈进行问题排查
 */

public class deadlock {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new MyThread(lockA, lockB), "T1").start();
        new Thread(new MyThread(lockB, lockA), "T2").start();
    }
}

class MyThread implements Runnable {

    private String lockA;
    private String lockB;

    public MyThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {

        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + " lock:" + lockA + "=>get " + lockB);
            try {
                System.out.println(lockA + "被锁定5秒");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        在锁定期间一直尝试获取锁，这就是死锁现象 两个线程互相需要的资源在对方手中并且不可抢占不可释放
        synchronized (lockB) {
            System.out.println(Thread.currentThread().getName() + " lock:" + lockB + "=>get " + lockA);
        }

    }
}
