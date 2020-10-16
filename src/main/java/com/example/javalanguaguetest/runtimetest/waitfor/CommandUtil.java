package com.example.javalanguaguetest.runtimetest.waitfor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/16 9:52 上午
 */
public class CommandUtil {
    //保存进程标准输入流信息
    private List<String> stdotList = new ArrayList<>();
    //保存进程标准错误流信息
    private List<String> errorList = new ArrayList<>();

    public void executeCommand(String command) {

        stdotList.clear();
        errorList.clear();

        Process p = null;

        try {
            p = Runtime.getRuntime().exec(command);
//创建两个线程  分别读取输入流缓冲区和错误流缓冲区
            ThreadUtil stdotThread = new ThreadUtil(stdotList, p.getInputStream());//在这里只是新建了对象 并没有新建线程
            ThreadUtil errorThread = new ThreadUtil(errorList, p.getErrorStream());//这两个参数直接传进构造方法

            stdotThread.start();//在start方法里会新建线程并启动run方法
            errorThread.start();

            p.waitFor();
            //一直挂起，直到子进程执行结束
            //返回0值表示正常退出
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<String> getErorList() {
        return errorList;
    }

    public List<String> getStdotList() {
        return stdotList;
    }

}

class ThreadUtil implements Runnable {
    //属于单字节编码，最多能表示的字符范围是0-255，应用于英文系列。
    private String character1 = "ISO-8859-1";
    //汉子的国标码，专门用来表示汉字，是双字节编码，而英文字母和iso8859-1一致（兼容iso8859-1编码）。
    // 其中gbk编码能够用来同时表示繁体字和简体字，而gb2312只能表示简体字，gbk是兼容gb2312编码的。
    private String character2 = "GB2312";
    //最统一的编码，可以用来表示所有语言的字符，而且是定长双字节（也有四字节的）编码，包括英文字母在内。
    private String character3 = "unicode";
    //相比于unicode会使用更少的空间，但如果已经知道是汉字 推荐GB2312
    private String character4 = "utf-8";

    private List<String> list;
    private InputStream inputStream;

    public ThreadUtil(List<String> list, InputStream inputStream) {
        this.list = list;
        this.inputStream = inputStream;
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.setDaemon(true);//设置守护进程
//定义：守护线程--也称“服务线程”，在没有用户线程可服务时会自动离开。优先级：守护线程的优先级比较低，用于为系统中的其它对象和线程提供服务。
        thread.start();//启动线程
    }

    @Override
    public void run() {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(inputStream, character4));
            String line = null;

            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
