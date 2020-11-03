package com.example.javalanguaguetest.synchronizedtest;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/3 8:56 下午
 */
public class WaitNotify {
    static Object lock = new Object();
    static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new Wait(), "wait thread");
        A.start();
        TimeUnit.SECONDS.sleep(2);
        Thread B = new Thread(new Notify(), "notify thread");
        B.start();
    }

    //使用wait() notify() notifyAll()时需要先对调用对象加锁 调用wait()方法会释放锁
    static class Wait implements Runnable {
        public void run() {
            synchronized (lock) {//加锁
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true");
                        //调用wait()方法会释放锁，进入等待状态  锁被释放后其他地方才能加锁
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //lock.wait()再次获得锁 本同步代码块得以继续执行
                System.out.println(Thread.currentThread() + " flag is false");
            }
        }
    }

    static class Notify implements Runnable {
        public void run() {
            synchronized (lock) {//加锁
                flag = false;
                lock.notifyAll();//通知其他线程继续执行 将其他所有线程移动到同步队列中 别移动的线程的状态从WAITING变为BLOCKED  同步代码块执行完毕后悔释放锁
                try {
                    System.out.println("notify");
                    TimeUnit.SECONDS.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
