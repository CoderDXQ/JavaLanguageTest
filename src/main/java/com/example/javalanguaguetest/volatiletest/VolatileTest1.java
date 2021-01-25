package com.example.javalanguaguetest.volatiletest;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/26 1:07 上午
 */

//volatile不能保证原子性
public class VolatileTest1 extends Thread {

    public static volatile int n = 0;

    //    synchronized 这个关键字可以保证原子性
    public static synchronized void inc() {
        n++;
    }

    //能保证原子性的写法

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                inc();
                sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


//    不能保证原子性的写法
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            try {
//                n = n + 1;
//                sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    public static void main(String[] args) throws InterruptedException {
        Thread threads[] = new Thread[100];

//        批量创建线程
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new VolatileTest1();
        }
//        批量启动线程
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
//        等待每一个线程执行完毕
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

//        如果输出的结果是小于1000的 因为n的值与以前的n的值相关，如果以前的n的值没有及时写回去就会产生错误
        System.out.println("n= " + VolatileTest1.n);
    }
}
