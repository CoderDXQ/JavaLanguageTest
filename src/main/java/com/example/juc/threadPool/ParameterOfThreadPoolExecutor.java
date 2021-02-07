package com.example.juc.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/2 1:47 上午
 */
public class ParameterOfThreadPoolExecutor {

    //    创建一个线程池
    private static ThreadPoolExecutor fixedThreadPool = new ThreadPoolExecutor(
            1,//核心线程数量
            2,//最大线程数量
            0L,//存活时间
            TimeUnit.MILLISECONDS,//时间
            new ArrayBlockingQueue<Runnable>(1)//缓冲队列
    );

    private static void printCount() {
        System.out.println("当前活跃线程数:" + fixedThreadPool.getActiveCount());
        System.out.println("当前核心线程数:" + fixedThreadPool.getCorePoolSize());
        System.out.println("阻塞队列中的任务数:" + fixedThreadPool.getQueue().size());
        System.out.println("---------------------------------------------------------");
    }

    public static void creatATask(int timelong) {
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(timelong);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {

        System.out.println("加入第一个任务，线程池刚刚初始化，没有可以执行任务的核心线程，创建一个核心线程来执行任务");
        creatATask(500);
        printCount();

        System.out.println("加入第二个任务，没有可以执行任务的核心线程，且任务数大于corePoolSize，新加入任务被放在了阻塞队列中");
        creatATask(500);
        printCount();

        System.out.println("加入第三个任务，此时，阻塞队列已满，新建非核心线程执行新加入任务");
        creatATask(1500);
        printCount();

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("第一个任务执行完毕，核心线程空闲，阻塞队列的任务被取出来，使用核心线程来执行");
        printCount();

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("第二个任务执行完毕，核心线程空闲，非核心线程在执行第三个任务");
        printCount();

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第三个任务执行完毕，非核心线程被销毁，核心线程保留");
        printCount();

        fixedThreadPool.shutdown();
    }
}
