package com.example.writtenexaminationandinterview.blockingqueue;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 手写阻塞队列  使用可重入锁ReentrantLock和Condition实现
 *
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/12 5:19 下午
 */
public class MyBlockingQueue<T> {

    //    可重入锁
    ReentrantLock lock = new ReentrantLock();

    //    控制生产者和消费者
    Condition consumer = lock.newCondition();
    Condition producer = lock.newCondition();

    //    容器
    LinkedList<T> queue = new LinkedList<T>();

    //    容量
    Integer capacity;
    Integer size;

    public MyBlockingQueue(Integer capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public void add(T t) {

//        加锁
        lock.lock();

        try {
            while (size >= capacity) {
                System.out.println(Thread.currentThread() + "add " + size);
//                阻塞生产者
                producer.await();
            }

            queue.add(t);
            size++;
//            唤醒消费者
            consumer.signalAll();
        } catch (InterruptedException e) {
//            唤醒生产者 避免阻塞
            producer.signalAll();
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {

        lock.lock();

        try {
            while (size == 0) {
                System.out.println(Thread.currentThread() + "get " + size);
                consumer.await();
            }
            System.out.println(Thread.currentThread() + "get " + size);
            size--;

//            producer.signal();
            producer.signalAll();
        } catch (InterruptedException e) {
//            唤醒消费者
            consumer.signalAll();
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return queue.removeFirst();

    }

    public static void main(String[] args) throws InterruptedException {

        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(3);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    queue.add(i);
                    System.out.println("生产：" + i);
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 10; i < 20; i++) {
                    queue.add(i);
                    System.out.println("生产：" + i);
                }
            }
        });

        t1.start();
        t3.start();

        Thread.sleep(500);

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("消费：" + queue.get());
                }
            }
        });

        t2.start();

    }

}
