package com.example.javalanguaguetest.callback.easy3;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/30 9:35 下午
 */
public class Student {

    //    Teacher类实现了CallBack接口，所以可以用CallBack来接收Teacher类的实例
    public void resolveQuestion(CallBack callBack, final String question) {
        System.out.println("Student receive the question:" + question);
        System.out.println("Student:I am busy");
        doSomething();
//        回调 这里之所以能进行回调是因为把callBack这个实例当成参数传进来了
        callBack.tellAnswer(2);
    }

    public void doSomething() {
        try {
            System.out.println("执行了doSomething()方法");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
