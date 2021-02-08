package com.example.juc.blockingQueue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/18 10:30 上午
 */
public class BlockingQueueTest {

    //阻塞队列的容量
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 10;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);


    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory (e.g. /opt/jdk1.8.0/src): ");
            //建议输入本包下的test文件夹的绝对路径
            String directory = in.nextLine();
            //建议输入字符串：haha
            System.out.println("Enter keyword (e.g. volatile): ");
            String keyword = in.nextLine();

            Runnable enumerator = () -> {
                try {
                    //遍历枚举文件
                    enumerate(new File(directory));
                    //放入指示终止的文件
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            //使用单线程来遍历枚举文件夹中的文件 生产者启动线程 生产者进程和消费者进程是同时存在的 阻塞队列为空时消费者进程全部阻塞
            new Thread(enumerator).start();


            //消费者
            //使用多线程来搜索文件 此模型是生产者-消费者模型  生产者生产的东西都放在阻塞队列中，所有消费者都从阻塞队列中取，所以不会有并发问题
            for (int i = 0; i <= SEARCH_THREADS; i++) {
                Runnable search = () -> {
                    try {
                        boolean done = false;
                        //线程会处理文一个文件后再从阻塞队列获取新的文件
                        while (!done) {
                            //从阻塞队列中取文件
                            File file = queue.take();
                            //如果取到终止文件就再放回去 标识符done更改使该线程结束 然后其他线程拿到终止文件也会使自己的线程结束
                            if (file == DUMMY) {
                                queue.put(file);
                                done = true;
                            } else search(file, keyword);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };
                //消费者启动线程
                new Thread(search).start();
            }
        }
    }

    //遍历枚举文件夹下的文件并加入阻塞队列
    public static void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) enumerate(file);
            else queue.put(file);
        }
    }

    public static void search(File file, String keyword) throws IOException {

        //读取文件
        try (Scanner in = new Scanner(file, "UTF-8")) {
            int lineNumber = 0;
            //按行读取文件内容并检查该行有没有待查询字段keyword
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    System.out.printf("%s:%s:%d:%s:%n当前阻塞队列的元素个数: %d%n", Thread.currentThread().getName(), file.getPath(), lineNumber, line, queue.size());
                    //单独使用一条语句输出的话会因为并发导致时序关系错乱
                    //  System.out.println("当前阻塞队列的元素个数" + queue.size());
                }
            }
        }
    }
}
