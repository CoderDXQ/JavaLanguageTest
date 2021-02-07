package com.example.juc.futuretaskandcallable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/7 8:44 下午
 */
public class CallableTestAndFutureTask {
    public static void main(String[] args) throws Exception {

//        使用Runnable()启动线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用Runnable()启动线程");
            }
        }).start();
        System.out.println();
//        使用Callable()启动线程  应该不行？？？
//        new Thread(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                System.out.println("jj");
//                return 1024;
//            }
//        }).start();

//        使用FutureTask来启动线程 FutureTask是一个适配类，创建时需要传入一个Thread类或者Callable()类或者Runnable类实例
        new Thread(new FutureTask<Integer>(new MyThread())).start();
        System.out.println();

//        FutureTask要求有返回值，返回值类型就是尖括号中的类型，如下是Integer，Callable的call()方法有返回值而Runnalbe没有
        new Thread(new FutureTask<Integer>((Callable<Integer>) () -> {
            System.out.println("使用FutureTask适配Callable来创建线程");
            return 1024;
        })).start();
        System.out.println();

//        不能使用FutureTask适配Runnabl来创建线程,因为FutureTask要求有返回值而Runnable的run()方法没有返回值
//        new Thread(new FutureTask<Integer>((Runnable<>) () -> {
//            System.out.println("jj");
//        })).start();

        MyThread myThread = new MyThread();
        ItThread itThread = new ItThread();

        FutureTask futureTask = new FutureTask(myThread);
//        不能使用FutureTask适配实现Runnable的线程类实例，因为后者没有返回值
//        FutureTask futureTask1=new FutureTask(itThread);

        new Thread(futureTask, "A").start();
        System.out.println();

//        下面这句不会被执行，因为结果被缓存了
        new Thread(futureTask, "B").start();
        System.out.println();

//        这个方法可能会造成阻塞，所以要放到最后
        Integer out = (Integer) futureTask.get();
        System.out.println(out);


    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " call()");
        return 1024;
    }
}

class ItThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run()");
    }
}
