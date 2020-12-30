package com.example.javalanguaguetest.callback.easy;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/30 11:32 上午
 */
public class Main {
    public static void main(String[] args) {

//        回调需要传入被回调的函数 10后面是一个内部类，重写了ComputerCallBack里的接口
        new TestCallBack().compute(10, new ComputerCallBack() {
            @Override
            public void onComputedEnd() {
                System.out.println("end back!!!");
            }
        });
    }
}
