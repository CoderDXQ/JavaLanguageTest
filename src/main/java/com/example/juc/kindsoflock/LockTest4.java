package com.example.juc.kindsoflock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/12 11:25 上午
 */

//自旋锁原理
public class LockTest4 {

    public static void main(String[] args) {

        Spinlock spinlock = new Spinlock();

        new Thread(() -> {
            spinlock.myLock();

            System.out.println(Thread.currentThread().getName() + "自旋5秒");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName());
                spinlock.myUnLock();
            }

        }, "T1").start();


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(Thread.currentThread().getName() + "暂停5秒");
        System.out.println();

        new Thread(() -> {
            spinlock.myLock();

            System.out.println(Thread.currentThread().getName() + "自旋5秒");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName());
                spinlock.myUnLock();
            }
        }, "T2").start();

    }
}

//自定义的自旋锁
class Spinlock {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    //    加锁操作
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " =>myLock执行加锁操作");

//        自旋锁
//        System.out.println(atomicReference.compareAndSet(null, thread));

//        自旋是指程序困在如下的while循环里 把上面的sout语句启用后就会出现自旋现象
        while (!atomicReference.compareAndSet(null, thread)) {//条件的判断结果是false才能进来 T1线程为true进不来,然后就不在再进入while循环
            System.out.println(Thread.currentThread().getName() + "自旋锁的自旋被破解了");

//            在这里休眠是为了减少控制台的输出
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //    解锁操作
    public void myUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " =>myUnLock执行解锁操作");
//        复位
        atomicReference.compareAndSet(thread, null);
    }

}
