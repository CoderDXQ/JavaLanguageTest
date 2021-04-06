package com.example.bishimianshi.alternatePrint;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/6 11:23 下午
 */
//多线程交替打印 使用有界阻塞队列实现
public class alternatePrint2 {

    private static Thread t1, t2;

    private static final BlockingQueue<Character> num = new ArrayBlockingQueue<>(1);
    private static final BlockingQueue<Character> alp = new ArrayBlockingQueue<>(1);
    private static final char[] nums = "1234567".toCharArray();
    private static final char[] alps = "ABCDEFG".toCharArray();

    public static void main(String[] args) throws IOException {

//        本质上是一个生产者消费者模型
        alp.add(alps[0]);
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < alps.length; i++) {
                    try {
                        System.out.println(alp.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num.add(nums[i]);
                }

            }
        });
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < nums.length; i++) {
                    try {
                        System.out.println(num.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    alp.add(alps[i]);
                }

            }
        });
        t1.start();
        t2.start();

//        主线程阻塞等待子线程执行完毕  这是IO阻塞
        System.in.read();

    }

}
