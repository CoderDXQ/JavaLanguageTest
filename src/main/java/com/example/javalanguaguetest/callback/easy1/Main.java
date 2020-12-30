package com.example.javalanguaguetest.callback.easy1;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/30 12:03 下午
 */
public class Main implements MyCallInterface {
    public static void main(String[] args) {
        Caller caller = new Caller();
        caller.setCallfuc(new Main());
        System.out.println("下面执行回调。");
        caller.call();
    }


    //    重写接口方法
    @Override
    public void method() {
        System.out.println("被调用了。");
    }
}
