package com.example.juc.daemonthread.DaemonCreateDaemon;

import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 1:06 上午
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon()=" + d.isDaemon() + ".");

//        如果没有这一句 线程d新创建的十个守护线程都来不及执行
        TimeUnit.SECONDS.sleep(1);
    }
}
