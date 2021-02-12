package com.example.juc.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/25 10:15 上午
 */
public class ThreadTest1 {
    public static void main(String[] args) {

        //固定容量的线程池
        //线程池中固定五个线程执行任务
/*        ExecutorService threadPool = Executors.newFixedThreadPool(5);//源码是LinkedBlockingQueue<Runnable>()
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + "办理业务");
                });
                //   Thread.sleep(400);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();//关闭线程池
        }*/


        //固定容量的线程池
        //线程池中固定五个线程执行任务
/*        ExecutorService threadPool = Executors.newFixedThreadPool(5);//源码是LinkedBlockingQueue<Runnable>()
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + "办理业务");
                });
                //让执行完sout命令的线程睡眠400ms以确保下次调用的不是这个线程，以此造成线程池中的线程依次被调用
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();//关闭线程池
        }*/


        //单例的线程池
/*        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
         */

        //可扩展的线程池
        //线程池的工作流程：常驻线程先参与处理，常驻线程满了就放阻塞队列，阻塞队列满了就扩容线程数到最大，再满了就使用拒绝策略
        //线程池支持的最大并发量应该是 最大线程数+阻塞队列容量，常驻线程（核心线程）包含于最大线程数
        //调优技巧：如果程序是CPU密集型，可以设置最大线程数是cpu核心数+1即Runtime.getRuntime().availableProcessors()+1，以保证cpu的效率最高
        //如果程序是IO密集型，应该考虑调小线程数以节约计算资源
        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    try {
                        //通过控制下面这个时间可以控制线程池的开辟数量
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t" + "办理业务");

                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


    }
}
