package com.example.writtenexaminationandinterview.producer_consumer;

import com.example.jdk8.lambda.MyFunction2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock和Condition来实现
 * Condition可以用来指定唤醒哪个线程
 * 实际上自己实现了一个阻塞队列
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/8 7:10 下午
 */
public class MyContainer2<T> {

    final private LinkedList<T> list = new LinkedList<>();

    private int MAX;
    private int count;

    public MyContainer2(int MAX) {
        this.MAX = MAX;
        this.count = 0;
    }

    //    使用可重入锁 因为要允许一个生产者线程多次生产
    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t) {
        lock.lock();

        try {
//            存满了就阻塞生产者
            while (list.size() == MAX) {
                producer.await();
            }
            list.add(t);
            count++;
//        唤醒消费者
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//        解锁
            lock.unlock();
        }
    }

    public T get() {

        lock.lock();

        try {
//            没有东西可供消费就等待生产者生产
            while (list.size() == 0) {
                consumer.await();
            }
            count--;
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return list.removeFirst();
    }

    public static void main(String[] args) throws InterruptedException {

        MyContainer2 c2 = new MyContainer2(3);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    c2.put(i);
                    System.out.println("Produce " + i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Consumer " + c2.get());
                }

            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();

    }
}
