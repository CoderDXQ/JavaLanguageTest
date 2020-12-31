package com.example.javalanguaguetest.callback.asyn_and_sync_callback.asyn;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/25 3:55 下午
 */
public class AsynchronousCallback {
    private static String msg = "我的电脑出了点问题XXX，你帮我看看，给你开个远程.";

    public static void main(String[] args) {
//        实现回调接口
        CallbackInterface callback = new RemoteControl();
        You.call_for_help(msg, callback);
    }
}
