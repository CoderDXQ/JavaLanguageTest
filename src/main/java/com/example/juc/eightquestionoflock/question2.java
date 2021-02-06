package com.example.juc.eightquestionoflock;

import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/6 1:02 下午
 */
public class question2 {

    public static void main(String[] args) {
//        一个对象
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();

        new Thread(() -> {
            System.out.println("A执行");
            phone1.sendSms();
        }, "A").start();

        //调用非静态同步方法  synchronized锁的是调用者而不是提供方法的对象实例
        //调用静态同步方法 synchronized锁的是Class类模板
//        虽然线程A和线程C调用的是同一个对象，但是线程C调用的hello()方法没有synchronized,所以不需要得到锁也能执行
        new Thread(() -> {
            System.out.println("C执行");
            phone1.hello();
        }, "C").start();


//        这一块代码执行完后才执行下面的代码 所以线程A启动一秒后线程B启动
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        线程B与线程A调用的不是同一个对象，所以二者之间的锁没有影响，实际上是并行的
        new Thread(() -> {
            System.out.println("B执行");
            phone2.call();
        }, "B").start();

    }

}

class Phone2 {

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

    public void hello() {
        System.out.println("hello");
    }
}
