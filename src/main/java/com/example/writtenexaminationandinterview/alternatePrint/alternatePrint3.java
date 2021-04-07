package com.example.writtenexaminationandinterview.alternatePrint;

import java.util.concurrent.SynchronousQueue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/6 11:23 下午
 */
//多线程交替打印 使用SynchronousQueue 这个队列是不缓存的 生产者放入一个任务必须等待消费者取出
public class alternatePrint3 {

    static final char[] nums = "1234567".toCharArray();
    static final char[] alps = "ABCDEFG".toCharArray();
    static SynchronousQueue<Character> num = new SynchronousQueue<>();
    static SynchronousQueue<Character> alp = new SynchronousQueue<>();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < nums.length; i++) {
                    try {
//                        alp队列里没有东西时就阻塞在这里
                        System.out.println(alp.take());
                        num.put(nums[i]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < alps.length; i++) {
                    try {
//                        先放的先执行 放入之后等待消费者取出
                        alp.put(alps[i]);
                        System.out.println(num.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        t1.start();
        t2.start();

        Thread.sleep(10000);

    }

}
