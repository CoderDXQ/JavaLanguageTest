package com.example.bishimianshi.lock;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * 锁升级过程中synchronized对象头标志位的变化
 *
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 10:33 上午
 */
public class synchroUpdate {


    private static Object lock = new Object();

    private void printObjectHead(Object o) {
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }


    @Test
    public void test1() {
        /**
         * 无锁 0 01   这些数字是第一行的 object header 最左边八位的最右边三位
         */
        Object o = new Object();
        printObjectHead(0);

    }

    @Test
    public void test2() throws InterruptedException {
        /**
         * JVM默认延时加偏向锁   默认是4s
         * 当前偏向锁没有偏向任何线程 偏向状态是可偏向状态 可以认为此时是一个特殊的无锁状态
         *
         * 为什么会有延迟？
         * jvm在启动的时候需要加载资源 这时候给对象加锁没有任何意义   延迟操作会减少大量偏向锁撤销的成本
         *
         */
        Thread.sleep(6000);
//        偏向锁 1 01 只不过是可偏向状态 线程通过CAS改对象头的Mark Word
        Object o = new Object();
        printObjectHead(o);

    }

    @Test
    public void test3() throws InterruptedException {

//        偏向锁 1 01
        Thread.sleep(5000);
        Object o = new Object();
//        初次加锁会设置偏向
        synchronized (o) {
            printObjectHead(o);
        }

    }

    @Test
    public void test4() throws InterruptedException {
        /**
         * 轻量级锁 0 00
         */

//        两个线程竞争会升级为轻量级锁 CAS 没拿到锁的线程自旋等待
        Thread thread1 = new Thread(task);
        thread1.start();

        Thread.sleep(2000);

        Thread thread2 = new Thread(task);
        thread2.start();
        printObjectHead(lock);
        thread1.join();
        thread2.join();

    }

    @Test
    public void test5() throws InterruptedException {

        /**
         * 重量级锁 0 10
         */

//        多个线程竞争轻量级锁 为了避免自旋过多影响cpu性能 升级成重量级锁  没有锁的线程全部阻塞
        Thread thread1 = new Thread(task);
        thread1.start();

        Thread thread2 = new Thread(task);
        thread2.start();

        printObjectHead(lock);
        thread1.join();
        thread2.join();

    }


    Runnable task = () -> {
        synchronized (lock) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    };

}
