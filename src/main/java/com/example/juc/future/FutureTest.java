package com.example.juc.future;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

//在某个文件夹中检索文件是否包含某个关键词，并返回包含关键字的文件的总数量
public class FutureTest {
    public static void main(String[] args) throws IOException {

        System.out.println("建议输入本包下的test文件夹的绝对路径");
//        /Users/duanxiangqing/Desktop/java语法 /src/main/java/com/example/juc/future/test
        String checkpath = ".";
        File aa = new File(checkpath);
        String abspath = aa.getAbsolutePath();
        Integer lastindex = abspath.lastIndexOf(".");
        String directory = abspath.substring(0, lastindex) + "src/main/java/com/example/juc/future/test";
        System.out.println(directory);

        //建议输入字符串：haha 或者 dxq
        System.out.println("Enter keyword haha 或者 dxq");
        String keyword = "dxq";

        //创建一个包含计算任务的对象
        MatchCounter counter = new MatchCounter(new File(directory), keyword);
        //未来的计算任务 返回值是Integer 这不是个数组
        FutureTask<Integer> task = new FutureTask<>(counter);
        //将未来计算任务扔到一个线程中执行 计算结果自动存储在FutureTask<Integer>中
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

//Callable接口的实现类 Callable有返回值
class MatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;

    public MatchCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    //call()方法会自动执行
    @Override
    public Integer call() {
        int count = 0;
        try {
            File[] files = directory.listFiles();

            //创建未来计算任务列表 Callable返回Integer值存储在Future中
            List<Future<Integer>> results = new ArrayList<>();

            //在本线程传入的directory中，如果包含文件夹，那么该线程就为每个文件夹新建一个线程去处理，如果包含文件，就自己挨个检索文件中是否包含关键词
            for (File file : files) {
                //当前线程只处理当前目录下的文件夹和文件 对于每个文件夹，新建一个线程相同的处理 对于每个文件调用search()方法检查是否包含目标字符串 当前目录的平级文件的命中数记录在count中
                if (file.isDirectory()) {
                    //使用多线程实现枚举遍历文件夹 为每个文件夹创建一个未来计算任务 然后放进results这个列表中
                    MatchCounter counter = new MatchCounter(file, keyword);
//                    新建计算任务
                    FutureTask<Integer> task = new FutureTask<>(counter);
                    results.add(task);
                    //每个线程只能扔进去一个计算任务
                    Thread t = new Thread(task);

                    //看一共启动了多少线程 每个线程负责处理一个文件夹
                    System.out.println(t.getName() + "线程启动处理新文件夹（路径）");

                    t.start();
                } else {
//                    检索字符串 找到返回true，没找到返回false
                    if (search(file)) {
                        count++;
                    }
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
//            读入文件，然后一行一行的检索
            try (Scanner in = new Scanner(file, "UTF-8")) {
                boolean found = false;
                while (!found && in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.contains(keyword)) {
                        found = true;
                    }
                }

                System.out.println(Thread.currentThread().getName() + " is running for search");
                return found;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            System.out.println(Thread.currentThread().getName() + " is running for search");
            //出错的情况下也返回false
            return false;
        }
    }
}
