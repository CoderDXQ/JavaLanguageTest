package com.example.juc.consumerandprovider;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/4 2:42 下午
 */
//生产者和消费者问题  使用OOP降低耦合性
public class ConsumerAndProvider {
    public static void main(String[] args) {
        Work work = new Work();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
//                    OOP
                    work.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    work.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
//                    OOP
                    work.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "C").start();

    }
}

class Work {
    private int number = 0;

    public synchronized void increment() throws InterruptedException {

//        if (number != 0) {
//            this.wait();
//        }

//        防止虚假唤醒
        while (number != 0) {
            this.wait();
        }


        number++;
        System.out.println(Thread.currentThread().getName() + "->" + number + " increment()");
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
//        if (number == 0) {
//            this.wait();
//        }

        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "->" + number + " decrement()");
        this.notifyAll();

    }
}
