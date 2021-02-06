package com.example.juc.eightquestionoflock;

import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/6 1:22 下午
 */
public class question4 {
    public static void main(String[] args) {
        // 两个对象的Class类模板只有一个，static，锁的是Class
        Phone4 phone1 = new Phone4();
        Phone4 phone2 = new Phone4();
        //调用静态同步方法 synchronized锁的是Class类模板
        new Thread(() -> {
            System.out.println("线程A执行");
            phone1.sendSms();
        }, "A").start();
        // 捕获
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        调用普通同步方法 synchronized锁的是调用者
        new Thread(() -> {
            System.out.println("线程B执行");
            phone2.call();
        }, "B").start();
    }
}

class Phone4 {
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
            System.out.println(Thread.currentThread().getName() + "等待4秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }

    public void hello() {
        System.out.println("hello");
    }
}
