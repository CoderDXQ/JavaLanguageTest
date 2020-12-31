package com.example.javalanguaguetest.callback.asyn_and_sync_callback.sync;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/31 10:26 上午
 */
public class YourFriend {

    private static String[] actions = {"右键计算机",
            "选择属性",
            "选择高级系统设置",
            "... ..."
    };

    static void resolve_problem(String msg, CallbackInterface callback) {
        System.out.println("B函数被调用.    ==>  你朋友收到你的求助.\n");
//        回调
        callback.do_remote_actions(actions);
        System.out.println("B函数返回.    ==>  你朋友向你反馈处理结果.\n");
    }
}
