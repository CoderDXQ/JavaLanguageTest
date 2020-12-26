package com.example.javalanguaguetest.queue;


import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/26 12:17 下午
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer = new Consumer(queue);

//        借助Executors
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer);

        System.out.println();
        System.out.println(Thread.currentThread().getName() + "睡眠10秒");
        Thread.sleep(10 * 1000);
//        四个线程执行时间限定为10秒
        producer1.stop();
        producer2.stop();
        producer3.stop();

//        控制一下，在下面的输出之前让三个生产者进程得以结束
        Thread.sleep(2000);

        System.out.println("生产者进程全部stop，消费者进程继续执行2秒");
        System.out.println();
//        因为三个生产者线程和主线程是并行的，所以如果不在上面睡眠2秒的话，在输出下面这一句之后有可能还在输出  "退出生产者线程！"
        System.out.println(Thread.currentThread().getName() + "睡眠2秒");
        Thread.sleep(2000);

//        关闭Executor
        service.shutdown();
    }


    public static class Consumer implements Runnable {

        private BlockingQueue<String> queue;
        private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

        public Consumer(BlockingQueue<String> queue) {
            this.queue = queue;
        }


        @Override
        public void run() {
            System.out.println("启动消费者线程！");
            Random r = new Random();
            boolean isRunning = true;

            try {
                while (isRunning) {
                    System.out.println("正在从队列获取数据。。。");
                    String data = queue.poll(2, TimeUnit.SECONDS);
                    if (data != null) {
                        System.out.println("拿到数据：" + data);
                        System.out.println("正在消费数据：" + data);
                        Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));

                    } else {
                        isRunning = false;
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
//          设置中断标志  记录中断发生的事实 告诉线程应该中断了 线程自己进行处理 在java里，一个线程不能中断另一个线程 所以，Thread.stop, Thread.suspend, Thread.resume 都已经被废弃了
                //调用interrupt()方法后，该线程会得到一个interrupt异常，可以通过对该异常的处理而退出线程、
//            在任何时候碰到InterruptedException，都要手动把自己这个线程中断。由于这个时候已经处于非阻塞状态，所以可以正常中断
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("退出消费者线程！");
            }

        }
    }

    public static class Producer implements Runnable {

        private volatile boolean isRunning = true;
        private BlockingQueue queue;
        //        在Java语言中，++i和i++操作并不是线程安全的，在使用的时候，不可避免的会用到synchronized关键字。而AtomicInteger则通过一种线程安全的加减操作接口进行实现。
//        使用这个数据类型是为了确保线程安全，在java中++i和i++都不是线程安全的需要与synchronized关键字共同使用
        private static AtomicInteger count = new AtomicInteger();
        //    java中常数的定义方法
        private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            String data = null;
            Random r = new Random();

            System.out.println("启动生产者线程！");

            try {
                while (isRunning) {
                    System.out.println("正在生产数据。。。");
                    Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
//                    这个方法是将原来的数自加1的操作
                    data = "data:" + count.incrementAndGet();
                    System.out.println("将数据：" + data + "放入队列。。。");

//                    执行放入操作
                    if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                        System.out.println("放入数据失败：" + data);
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
//          设置中断标志 记录中断发生的事实 告诉线程应该中断了 线程自己进行处理 在java里，一个线程不能中断另一个线程 所以，Thread.stop, Thread.suspend, Thread.resume 都已经被废弃了
                //调用interrupt()方法后，该线程会得到一个interrupt异常，可以通过对该异常的处理而退出线程
//            在任何时候碰到InterruptedException，都要手动把自己这个线程中断。由于这个时候已经处于非阻塞状态，所以可以正常中断
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("退出生产者线程！");
            }

        }

        public void stop() {
            isRunning = false;
        }
    }


}
