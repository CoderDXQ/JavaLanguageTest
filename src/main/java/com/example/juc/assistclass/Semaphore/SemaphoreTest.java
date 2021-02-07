package com.example.juc.assistclass.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/7 10:31 下午
 */

//信号量  使用信号量的数量来控制并发的线程数
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        System.out.println("---------测试Semaphore的一些方法——————————");
//        可以用的信号量数量
        System.out.println(semaphore.availablePermits());
        System.out.println(semaphore.getQueueLength());

//        排空许可，执行后没有可用的信号量了
//        System.out.println(semaphore.drainPermits());
//        System.out.println(semaphore.availablePermits());

        System.out.println(semaphore.hasQueuedThreads());
        System.out.println("----------------------------------------");

        for (int i = 0; i < 6; i++) {

            new Thread(() -> {

                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "可用的线程数（信号量剩余）： " + semaphore.availablePermits());
                    System.out.println(Thread.currentThread().getName() + "抢到车票");
                    System.out.println(Thread.currentThread().getName() + "此时等待许可的线程数： " + semaphore.getQueueLength());
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "此时等待许可的线程数 " + semaphore.getQueueLength());
                    System.out.println(Thread.currentThread().getName() + "可用的线程数（信号量剩余）： " + semaphore.availablePermits());
                }

            }, "线程" + String.valueOf(i)).start();
        }
    }
}
