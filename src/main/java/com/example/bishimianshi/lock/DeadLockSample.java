package com.example.bishimianshi.lock;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 10:21 上午
 */
public class DeadLockSample extends Thread {

    private Object a = null;
    private Object b = null;

    public DeadLockSample(Object a, Object b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (a) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b) {
                System.out.println("Success");
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Object a = new Object();
        Object b = new Object();

        DeadLockSample d1 = new DeadLockSample(a, b);
        DeadLockSample d2 = new DeadLockSample(b, a);

//        没有输出就证明有死锁
        d1.start();
        d2.start();

        d1.join();
        d2.join();

    }

}
