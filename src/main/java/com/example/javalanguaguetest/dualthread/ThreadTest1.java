package com.example.javalanguaguetest.dualthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/25 10:15 上午
 */
public class ThreadTest1 {
    public static void main(String[] args) {

        //固定容量的线程池
        //线程池中固定五个线程执行任务
/**
        ExecutorService threadPool = Executors.newFixedThreadPool(5);//源码是LinkedBlockingQueue<Runnable>()
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + "办理业务");
                });
                //   Thread.sleep(400);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();//关闭线程池
        }
**/

        //固定容量的线程池
        //线程池中固定五个线程执行任务
        /**
        ExecutorService threadPool = Executors.newFixedThreadPool(5);//源码是LinkedBlockingQueue<Runnable>()
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + "办理业务");
                });
                //让执行完sout命令的线程睡眠400ms以确保下次调用的不是这个线程，以此造成线程池中的线程依次被调用
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();//关闭线程池
        }
**/

    }
}
