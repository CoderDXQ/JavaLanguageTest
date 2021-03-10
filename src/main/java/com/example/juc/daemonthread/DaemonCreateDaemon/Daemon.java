package com.example.juc.daemonthread.DaemonCreateDaemon;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 12:58 上午
 */

//守护线程创建的线程也是守护线程
public class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn" + i + " started.");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ".");
        }
        while (true) {
            Thread.yield();
        }
    }
}
