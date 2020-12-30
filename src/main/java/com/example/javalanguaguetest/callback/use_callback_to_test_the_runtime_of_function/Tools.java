package com.example.javalanguaguetest.callback.use_callback_to_test_the_runtime_of_function;

import javax.tools.Tool;

import static com.example.javalanguaguetest.callback.use_callback_to_test_the_runtime_of_function.TestObject.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/30 4:25 下午
 */
public class Tools {

    //    执行回调的函数
    public void testTime(CallBack callBack) {
        long begin = System.currentTimeMillis();
//        执行回调
        callBack.execute();
        System.out.println("Tools：[use time]:" + (System.currentTimeMillis() - begin));
    }

    public static void main(String[] args) {
        Tools tool = new Tools();
        tool.testTime(new CallBack() {
            @Override
            public void execute() {
//                public类里的静态方法可以直接调用
                TestObject.testMethod();
                System.out.println("回调结束");
            }
        });
    }
}
