package com.example.javalanguaguetest.linkedlist;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/28 4:57 下午
 */

//链表多线程

public class MultithreadLinkedList {
    public static void main(String[] args) throws InterruptedException {
        List q = Collections.synchronizedList(new LinkedList<String>());
        Thread p1 = new Thread(new Product(q));
        Thread c1 = new Thread(new Consumer(q));

        p1.start();
        c1.start();

//        这个方法会抛出中断异常，所以必须在方法的声明上抛异常 Exception是所有异常类的父类，可以用这个接
        p1.join();
        c1.join();
    }

}

//生产者
class Product implements Runnable {
    private final List<String> queue;

    Product(List<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        queue.add("1");
        queue.add("done");
    }
}

//消费者
class Consumer implements Runnable {
    private final List<String> queue;

    Consumer(List<String> queue) {
        this.queue = queue;
    }


//    这种写法会抛出数组超界异常
   /* @Override
    public void run() {
        String value = queue.remove(0);
        while (!value.equals("*")) {
            System.out.println(value);
            value = queue.remove(0);
        }
    }*/

    //    这种写法不抛异常
    @Override
    public void run() {
        String value;
        while (!queue.isEmpty()) {
            value = queue.remove(0);
            System.out.println(value);
        }
    }

}
