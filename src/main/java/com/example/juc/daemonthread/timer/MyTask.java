package com.example.juc.daemonthread.timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 12:28 上午
 */
public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("任务执行了，时间为：" + new Date());
    }
}
