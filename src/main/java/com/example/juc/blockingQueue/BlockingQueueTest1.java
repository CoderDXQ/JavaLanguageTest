package com.example.juc.blockingQueue;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/8 11:30 下午
 */

public class BlockingQueueTest1 {

    public static void test1() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("a"));

//        报错：Queue full
//        System.out.println(arrayBlockingQueue.add("a"));

        System.out.println("------------------");
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());

//        报错：NoSuchElementException
//        System.out.println(arrayBlockingQueue.remove());

    }

    public static void test2() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));
//        返回false，队列已满添加失败
        System.out.println(arrayBlockingQueue.offer("d"));

        System.out.println("------------------");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
//        返回null，队列为空
        System.out.println(arrayBlockingQueue.poll());

    }

    public static void test3() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

//        put方法没有返回值
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");
//        因为队列已满，线程会一直阻塞 所以不会被放入队列  不建议使用这个方法，建议使用offer方法，可以设置超时时间
//        arrayBlockingQueue.put("d",2, SECONDS);

        System.out.println("------------------");

        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
//        因为队列为空，所以线程会阻塞 不建议使用take方法，建议使用poll方法，可以设置超时时间
//        System.out.println(arrayBlockingQueue.take());
    }

    public static void test4() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        arrayBlockingQueue.offer("a");
        arrayBlockingQueue.offer("b");
        arrayBlockingQueue.offer("c");
        //        等待超过2秒就退出
        arrayBlockingQueue.offer("d", 2, SECONDS);
        System.out.println("------------------");

        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());

//        等待超过2秒就退出
        arrayBlockingQueue.poll(2, SECONDS);
    }


    public static void main(String[] args) throws InterruptedException {

        test1();
        System.out.println("***********************************************");
        test2();
        System.out.println("***********************************************");
        test3();
        System.out.println("***********************************************");
        test4();

    }
}
