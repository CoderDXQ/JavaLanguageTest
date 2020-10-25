package com.example.javalanguaguetest.dualthread;

import java.util.concurrent.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/25 9:53 上午
 */
public class ThreadTest {
    public static void main(String[] args) {
        //获取当前线程名称
        Thread.currentThread().getName();

        //创建了线程池，但是线程池中现在没有线程
        ExecutorService es = Executors.newCachedThreadPool();

        //往线程池中添加线程对象
        es.submit(() -> {
            System.out.println("成功添加了线程");
        });

        //关闭线程池
        es.shutdown();

        //创建单线程的线程池
        ExecutorService ess = Executors.newSingleThreadExecutor();

        //创建固定大小的线程池
        ExecutorService esss = Executors.newFixedThreadPool(3);


        //定时调度池（代码会自动执行）
        //创建一个具备有一个线程大小的定时调度线程池
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

        //4个参数：Runnable接口（线程对象），三秒后开始，每两秒重复一次，时间单位
        ses.scheduleAtFixedRate(() -> {
                    System.out.println("成功添加了线程")
                }, 3, 2, TimeUnit.SECONDS
        );

    }
}
