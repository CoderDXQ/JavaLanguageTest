package com.example.javalanguaguetest.synchronizedtest.threadPool;


import sun.nio.ch.ThreadPool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/18 8:50 下午
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory (e.g. /opt/jdk1.8.0/src): ");
            //建议输入本包下的test文件夹的绝对路径
            String directory = in.nextLine();
            //建议输入字符串：haha
            System.out.println("Enter keyword (e.g. volatile): ");
            String keyword = in.nextLine();

            ExecutorService pool = Executors.newCachedThreadPool();

            MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
            Future<Integer> result = pool.submit(counter);

            try {
                System.out.println(result.get() + " matching files.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            //关闭线程池
            pool.shutdown();

            int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
            System.out.println("largest pool size=" + largestPoolSize);
        }
    }
}

//Callable接口的实现类会自动执行call()方法
class MatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MatchCounter(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    public Integer call() {
        count = 0;
        try {
            File[] files = directory.listFiles();

            //创建未来计算任务列表
            List<Future<Integer>> results = new ArrayList<>();

            for (File file : files) {
                //当前线程只处理当前目录下的文件夹和文件 对于每个文件夹，新建一个线程相同的处理 对于每个文件调用search()方法检查是否包含目标字符串 当前目录的平级文件的命中数记录在count中
                if (file.isDirectory()) {
                    //使用多线程实现枚举遍历文件夹 为每个文件夹创建一个未来计算任务 然后放进results这个列表中
                    MatchCounter counter = new MatchCounter(file, keyword, pool);
                    //从线程池中捞一个线程执行计算任务
                    Future<Integer> result = pool.submit(counter);
                    //将未来计算任务加入list
                    results.add(result);
                } else {
                    if (search(file)) count++;
                }
            }

            //打印results看看都有哪些计算任务
            // System.out.println(results);
            //调用每个计算任务的结果进行累加 这里会有一个递归的过程
            //count在这里不一定是0 是本级目录的命中文件在数 使用下面这个for循环加上本级各文件夹的计算结果 然后向上返回
            for (Future<Integer> result : results) {
                try {
                    count += result.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public boolean search(File file) {
        try {
            try (Scanner in = new Scanner(file, "UTF-8")) {
                boolean found = false;
                while (!found && in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.contains(keyword)) found = true;
                }
                // System.out.println(Thread.currentThread().getName() + " is running");
                return found;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            // System.out.println(Thread.currentThread().getName() + " is running");
            //出错的情况下也返回false
            return false;
        }
    }
}
