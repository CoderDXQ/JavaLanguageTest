package com.example.javalanguaguetest.callback.asyn_and_sync_callback.sync;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/31 10:20 上午
 */
public class RemoteControl implements CallbackInterface {
    @Override
    public void do_remote_actions(String[] actions) {
        System.out.println("C函数被调用.    ==>  你朋友通过你开的 ***远程控制*** 操作你的电脑.\n");
        for (String action : actions) {
            System.out.println(action);
        }
        System.out.println("C函数返回.    ==>  处理完毕，退出远程的使用.\n");
    }
}
