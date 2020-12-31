package com.example.javalanguaguetest.callback.asyn_and_sync_callback.asyn;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/31 10:26 上午
 */

//异步方法多开几个线程并行跑就是异步，同步方法只在一个线程跑就是同步
public class YourFriend extends Thread {

    private static String[] actions = {"右键计算机",
            "选择属性",
            "选择高级系统设置",
            "... ..."
    };

    String msg;
    CallbackInterface callback;

    public YourFriend(String msg, CallbackInterface callback) {
        super();
        this.msg = msg;
        this.callback = callback;
    }


    static void resolve_problem(String msg, CallbackInterface callback) {
        System.out.println("B函数被调用.    ==>  你朋友收到你的求助.\n");
//        回调RemoteControl
        callback.do_remote_actions(actions);
        System.out.println("B函数返回.    ==>  你朋友向你反馈处理结果.\n");
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        执行回调
        resolve_problem(this.msg, this.callback);
//        super.run();
    }
}
