package com.example.writtenexaminationandinterview.producer_consumer;

import java.util.LinkedList;

/**
 * 使用wait和notifyAll来实现生产者消费者模型
 *
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/8 7:10 下午
 */
public class MyContainer1<T> {

    final private LinkedList<T> list = new LinkedList<>();

    private int MAX;
    private int count;

    public MyContainer1(int MAX) {
        this.MAX = MAX;
        this.count = 0;
    }

    public synchronized void put(T t) {

//        容器满了就阻塞等待消费者消费
        while (list.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        生产
        list.add(t);
        System.out.println("Produce " + t);
        count++;
//        唤醒消费者
        this.notifyAll();

    }

    public synchronized T get() {
        T t = null;

        while (list.size() == 0) {
            try {
//                链表里没有东西就阻塞等待生产者生产
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
//        消费完之后唤醒生产者
        this.notifyAll();
        return t;
    }


    public static void main(String[] args) throws InterruptedException {

//        设置容器容量为3
        MyContainer1 c1 = new MyContainer1(3);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    c1.put(i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Consume " + c1.get());
                }
            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();

    }


}
