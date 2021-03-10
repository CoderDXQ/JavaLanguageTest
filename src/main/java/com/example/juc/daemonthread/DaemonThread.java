package com.example.juc.daemonthread;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/9 11:55 下午
 */
public class DaemonThread {

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("daemon thread: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    //    线程分两种：用户线程和守护线程，所有用户线程都退出后，守护线程就会被杀死。
    public static void main(String[] args) {

        Thread daemonThread = new Thread(new DaemonRunner());

//        通过设置这个字段将用户线程变为守护线程
        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println("isDaemon? = " + daemonThread.isDaemon());

//        任意输入字符后，当前线程切换至主线程，此时DaemonRunner线程退出，守护线程也被杀死
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("DaemonThread is alive? " + daemonThread.isAlive());

        System.out.println(Thread.currentThread().getName());
//          运行线程关闭时启动线程
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("JVM Exit!");
            }
        });


    }
}