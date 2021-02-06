package com.example.juc.eightquestionoflock;

import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/6 1:11 下午
 */
public class question3 {
    public static void main(String[] args) {

//        创建两个对象实例
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();

        //虽然两个线程分别调用两个对象实例的两个不同 静态 方法，但是因为方法使用static修饰（类加载的时候就有了，两个静态方法都在同一个Class类模板里），所以两个对象的Class类模板只有一个
        //调用静态同步方法 synchronized锁的是Class类模板
        //调用普通同步方法 synchronized锁的是调用者
        new Thread(() -> {
            System.out.println("线程A执行");
            phone1.sendSms();
        }, "A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            System.out.println("线程B执行");
            phone2.call();
        }, "B").start();
    }
}

class Phone3 {
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
            System.out.println(Thread.currentThread().getName() + "等待4秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call() {
        System.out.println("打电话");
    }

    public void hello() {
        System.out.println("hello");
    }
}
