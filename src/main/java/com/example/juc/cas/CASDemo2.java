package com.example.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/11 4:29 下午
 */

//使用原子引用解决ABA问题，原理：乐观锁
public class CASDemo2 {

    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1, 1);

    public static void main(String[] args) {

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();//获得版本号
            System.out.println("a1Stamp=>" + stamp);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicStampedReference.compareAndSet(1, 2, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("Reference:" + atomicStampedReference.getReference());
            System.out.println("a2Stamp=>" + atomicStampedReference.getStamp());

            System.out.println(atomicStampedReference.compareAndSet(2, 1, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("Reference:" + atomicStampedReference.getReference());
            System.out.println("a3Stamp=>" + atomicStampedReference.getStamp());

            System.out.println("更新两次全部成功");

        }, "a").start();


        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();

//        乐观锁
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("bStamp=>" + stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicStampedReference.compareAndSet(1, 6, stamp, stamp + 1));
            System.out.println("Reference:" + atomicStampedReference.getReference());
            System.out.println("b2Stamp=>" + atomicStampedReference.getStamp());
        }, "b").start();

    }
}
