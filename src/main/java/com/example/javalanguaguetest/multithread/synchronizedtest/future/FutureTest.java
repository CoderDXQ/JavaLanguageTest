package com.example.javalanguaguetest.multithread.synchronizedtest.future;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/18 4:25 下午
 */
public class FutureTest {
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory (e.g. /opt/jdk1.8.0/src): ");
            //建议输入本包下的test文件夹的绝对路径
            String directory = in.nextLine();
            //建议输入字符串：haha
            System.out.println("Enter keyword (e.g. volatile): ");
            String keyword = in.nextLine();

            //创建一个包含计算任务的对象
            MatchCounter counter = new MatchCounter(new File(directory), keyword);
            //未来的计算任务 返回值是Integer 这不是个数组
            FutureTask<Integer> task = new FutureTask<>(counter);
            //将未来计算任务扔到一个线程中执行
            Thread t = new Thread(task);
            t.start();

            try {
                //get()方法的调用会被阻塞 get()方法会得到call()方法的返回结果 指导task的计算完成
                System.out.println(task.get() + " matching files.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

//Callable接口的实现类
class MatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;

    public MatchCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    //call()方法会自动执行
    public Integer call() {
        int count = 0;
        try {
            File[] files = directory.listFiles();

            //创建未来计算任务列表
            List<Future<Integer>> results = new ArrayList<>();

            for (File file : files) {
                //当前线程只处理当前目录下的文件夹和文件 对于每个文件夹，新建一个线程相同的处理 对于每个文件调用search()方法检查是否包含目标字符串 当前目录的平级文件的命中数记录在count中
                if (file.isDirectory()) {
                    //使用多线程实现枚举遍历文件夹 为每个文件夹创建一个未来计算任务 然后放进results这个列表中
                    MatchCounter counter = new MatchCounter(file, keyword);
                    FutureTask<Integer> task = new FutureTask<>(counter);
                    results.add(task);
                    //每个线程只能扔进去一个计算任务
                    Thread t = new Thread(task);

                    //看一共启动了多少线程
                    System.out.println(t.getName());

                    t.start();
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

    //检查某个文件是否包含某个字符串
    public boolean search(File file) {
        try {
            try (Scanner in = new Scanner(file, "UTF-8")) {
                boolean found = false;
                while (!found && in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.contains(keyword)) found = true;
                }

                System.out.println(Thread.currentThread().getName() + " is running");
                return found;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            System.out.println(Thread.currentThread().getName() + " is running");
            //出错的情况下也返回false
            return false;
        }
    }
}
