package com.example.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/11 4:25 下午
 */

//ABA问题原理
public class CASDemo1 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);

        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2020, 666));
        System.out.println(atomicInteger.get());
    }
}


