package com.example.javalanguaguetest.callback.easy2;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/30 12:12 下午
 */
public class FooBar {
    private ICallBack callBack;

    public FooBar(ICallBack callBack) {
        this.callBack = callBack;
    }

    public void doSth() {
        System.out.println("准备调用");
        callBack.postExec();
    }
}
