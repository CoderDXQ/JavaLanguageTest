package com.example.juc.insecurityofcollections;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/6 11:28 下午
 */
//多线程下写入Set
public class SetTest {

    public static void main(String[] args) {

        /**
         避免写入问题的方法有： 报错：java.util.ConcurrentModificationException
         1.加锁
         2.使用Collections类
         Set<String> set = Collections.synchronizedSet(new HashSet<>());
         */

        //HashSet的底层就是HashMap
//        Set<String> set = new HashSet<>();
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }).start();
        }
    }
}
