package com.example.javalanguaguetest.callback.easy;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/30 11:32 上午
 */
public class TestCallBack {
    public void compute(int n, ComputerCallBack callBack) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
//        执行回调
        callBack.onComputedEnd();
    }
}
