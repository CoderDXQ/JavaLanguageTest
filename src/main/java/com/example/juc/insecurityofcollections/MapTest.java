package com.example.juc.insecurityofcollections;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/6 11:37 下午
 */
//多线程下写入Map
public class MapTest {

    public static void main(String[] args) {

//        Map<String, String> map = new HashMap<>();

        /**
         避免写入问题的方法有： 报错：java.util.ConcurrentModificationException
         1.加锁
         2.使用ConcurrentHashMap
         */

//        ConcurrentHashMap是面试的常问问题 在jdk1.7中使用分段锁Segment来实现  在jdk1.8中使用CAS Synchronized实现
//        https://blog.csdn.net/jjc120074203/article/details/78625433
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
