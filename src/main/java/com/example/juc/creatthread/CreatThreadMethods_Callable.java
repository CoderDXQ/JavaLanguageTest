package com.example.juc.creatthread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/27 11:53 下午
 */
public class CreatThreadMethods_Callable {

    //    构造方法
    public CreatThreadMethods_Callable() throws ExecutionException, InterruptedException {
//        创建线程池 可以实现多个线程的并发
        ExecutorService threadPool = Executors.newCachedThreadPool();

////        启动单个线程
//        Future<String> future = threadPool.submit(new call());
//        System.out.println(future.get());

        System.out.println();
//        启动多个线程
        ArrayList<Future<String>> futures = new ArrayList<Future<String>>();
        ArrayList<Future<String>> futures1 = new ArrayList<Future<String>>();
        for (int i = 0; i < 5; i++) {
            futures.add(threadPool.submit(new call()));
        }

        threadPool.shutdown();

        Thread.sleep(1000);
        for (Future<String> fs : futures) {
            System.out.println(Thread.currentThread().getName() + " will done and " + fs.get());
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new CreatThreadMethods_Callable();
    }

    public static class call implements Callable<String> {
        private static int ticket = 10;
        private Object lock = "";

//        @Override
//        public String call() throws Exception {
//            while (ticket > 0) {
//                Thread.sleep(500);
////                如果不加synchronized关键字 将会有多个线程同时对ticket进行自减操作
////                加上之后，正在进行自减操作的线程释放锁之后其他线程会继续进行自减操作，导致tick为负数
////                将synchronized关键字加在while语句处可以解决这个问题
//                synchronized (lock) {
//                    System.out.println(Thread.currentThread().getName() + "第" + ticket + "张");
//                    --ticket;
//                }
//            }
//            return "Done";
//        }

        @Override
        public String call() throws Exception {
            synchronized (lock) {
                while (ticket > 0) {
                    Thread.sleep(500);
//                如果不加synchronized关键字 将会有多个线程同时对ticket进行自减操作
//                加上之后，正在进行自减操作的线程释放锁之后其他线程会继续进行自减操作，导致tick为负数
//                将synchronized关键字加在while语句处可以解决这个问题
                    System.out.println(Thread.currentThread().getName() + "第" + ticket + "张");
                    --ticket;
                }
            }
            return "Done";
        }
    }
}
