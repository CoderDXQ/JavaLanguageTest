package com.example.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/11 4:19 下午
 */
//原理解析
public class CASDemo {
    public static void main(String[] args) {
//        CAS  CompareAndSet(Swap) 比较并交换
        AtomicInteger atomicInteger = new AtomicInteger(2020);

//        2020->2021 第一个参数是期望，如果符合期望就更新成第二个数
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());
        System.out.println();

//        自增1 2021->2022
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());
    }
}
