package com.example.juc.insecurityofcollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/6 11:21 下午
 */

//多线程下List写入的几种解决方案
public class ListTest {
    public static void main(String[] args) {


//        List<String> list = new ArrayList<>();

//        解决报错java.util.ConcurrentModificationException写方案
//        方案一：写入时加锁
//        方案二：如下 其实就是加了锁
//        List<String> list1 = Collections.synchronizedList(new ArrayList<>());
//        方案三  写入时复制 是一种计算机设计领域常用的优化策略 读写分离 效率高
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);

            }, String.valueOf(i)).start();
        }

    }
}
