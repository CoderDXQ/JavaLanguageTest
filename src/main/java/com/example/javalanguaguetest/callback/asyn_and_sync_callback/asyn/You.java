package com.example.javalanguaguetest.callback.asyn_and_sync_callback.asyn;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/25 4:14 下午
 */
public class You {
    static void call_for_help(String msg, CallbackInterface callback) {
        System.out.println("A函数启动.      ==>  你用电脑，遇到了问题.\n");
        System.out.println("A函数调用B函数.  ==>  你向你朋友发起求助，同时提供 ***远程控制*** 给他.\n");
        YourFriend yourFriend = new YourFriend(msg, callback);
//        默认会先执行run()函数
        yourFriend.start();
        System.out.println("A函数返回.    ==>  你出门办事.\n");
    }
}
