package com.example.writtenexaminationandinterview.multithread.ABCPrint;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 4:47 下午
 */
//三线程交替打印
public class ABCPrint {

    private Lock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    private char currentThreadName = 'A';

    public static void main(String[] args) {
        ABCPrint print = new ABCPrint();

//        固定线程池
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(print.new ThreadA());
        service.execute(print.new ThreadB());
        service.execute(print.new ThreadC());
//        关闭线程池
        service.shutdown();
    }

    private class ThreadA implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
//                加锁
                lock.lock();
                try {
                    while (currentThreadName != 'A') {
                        try {
                            //阻塞
                            conditionA.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
//                    走到这里说明currentThreadName = 'A'
                    System.out.println("A");
//                    调用'B'
                    currentThreadName = 'B';
//                    唤醒B
                    conditionB.signal();
                } finally {
//                    释放锁
                    lock.unlock();
                }
            }
        }
    }

    private class ThreadB implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
//                加锁
                lock.lock();
                try {
                    while (currentThreadName != 'B') {
                        try {
                            //阻塞
                            conditionB.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
//                    走到这里说明currentThreadName = 'B'
                    System.out.println("B");
//                    调用'C'
                    currentThreadName = 'C';
//                    唤醒C
                    conditionC.signal();
                } finally {
//                    释放锁
                    lock.unlock();
                }
            }
        }
    }

    private class ThreadC implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
//                加锁
                lock.lock();
                try {
                    while (currentThreadName != 'C') {
                        try {
                            //阻塞
                            conditionC.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
//                    走到这里说明currentThreadName = 'C'
                    System.out.println("C");
//                    调用'A'
                    currentThreadName = 'A';
//                    唤醒A
                    conditionA.signal();
                } finally {
//                    释放锁
                    lock.unlock();
                }
            }
        }
    }


}
