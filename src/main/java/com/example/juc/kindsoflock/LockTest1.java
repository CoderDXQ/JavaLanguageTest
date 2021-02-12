package com.example.juc.kindsoflock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/12 10:22 上午
 */
public class LockTest1 {

//    公平锁与非公平锁
    public static void create(Boolean fair) {
        try {
            ReentrantLock sync = fair ? new ReentrantLock(true) : new ReentrantLock(false);
//            System.out.println(sync.);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        create(true);
        create(false);
    }
}
