package com.example.javalanguaguetest.callback.asyn_and_sync_callback.sync;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/25 3:50 下午
 */
public class SynchronousCallback {
    private static String msg = "我的电脑出了点问题XXX，你帮我看看，给你开个远程.";

    public static void main(String[] args) {
        CallbackInterface callback = new RemoteControl();
        You.call_for_help(msg, callback);
    }
}