package com.example.juc.daemonthread.DaemonCreateDaemon;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 1:02 上午
 */
public class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) {
//            使当前线程由执行状态变为就绪状态 让出cpu执行时间
            Thread.yield();
        }
    }
}
