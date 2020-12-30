package com.example.javalanguaguetest.callback.easy1;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/30 12:04 下午
 */
public class Caller {
    public MyCallInterface mc;

    public void setCallfuc(MyCallInterface mc) {
        this.mc = mc;
    }

    //    执行回调
    public void call() {
        System.out.println("调用回调函数。");
        this.mc.method();
    }
}
