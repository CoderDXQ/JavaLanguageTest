package com.example.juc.daemonthread.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 12:30 上午
 */
//使用Timer类创建守护线程
public class Test1 {
    public static void main(String[] args) {
        System.out.println("当前时间：" + new Date());

//        日历类
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date date = calendar.getTime();
        MyTask task = new MyTask();

//        启动用户线程
//        Timer timer = new Timer();
//        启动守护线程
        Timer timer = new Timer(true);

        timer.schedule(task, date);
    }
}
