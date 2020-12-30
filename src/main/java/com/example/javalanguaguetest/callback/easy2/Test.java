package com.example.javalanguaguetest.callback.easy2;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/30 12:12 下午
 */
public class Test {
    public static void main(String[] args) {

//        这个内部类是往构造函数里传的参数 并且这个内部类是接口的实现类
        FooBar foo = new FooBar(new ICallBack() {
            @Override
            public void postExec() {
                System.out.println("被调用啦");
            }
        });

        foo.doSth();
    }
}
