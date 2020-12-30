package com.example.javalanguaguetest.callback.use_callback_to_test_the_runtime_of_function;

import static java.lang.System.currentTimeMillis;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/30 4:25 下午
 */
public class TestObject {
    public static void main(String[] args) {
        TestObject test = new TestObject();
        test.testTime();
    }

    public static void testMethod() {
        System.out.println("被调用啦");
        for (int i = 0; i < 100000000; i++) {

        }
        System.out.println("调用完啦");
    }

    public void testTime() {
        long begin = currentTimeMillis();
        testMethod();
        System.out.println("TestObject：[use time]:" + (currentTimeMillis() - begin));
    }
}
