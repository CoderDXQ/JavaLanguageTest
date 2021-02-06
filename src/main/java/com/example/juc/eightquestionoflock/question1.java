package com.example.juc.eightquestionoflock;

import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/5 9:32 下午
 */
public class question1 {

    public static void main(String[] args) {
//        一个对象
        Phone phone = new Phone();
//        调用静态同步方法 synchronized锁的是Class类模板
//        调用普通同步方法 synchronized锁的是调用者
        new Thread(() -> {
            System.out.println("A执行");
            phone.sendSms();
        }, "A").start();

//        这一块代码执行完后才执行下面的代码
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            System.out.println("B执行");
            phone.call();
        }, "B").start();

    }

}

class Phone {

    //    因为两个线程使用的是同一个实例，所以B线程要在A线程释放锁之后才能执行
    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }
}
