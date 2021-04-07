package com.example.writtenexaminationandinterview.myAOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/6 10:25 下午
 */
//使用JDK动态代理必须实现InvocationHandler接口并重写invoke()方法
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public Object bind(Object target) {
//        绑定一个委托对象 其实就是接口的实现对象
        this.target = target;
//        返回一个代理对象  会自动调用invoke()方法
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("权限检查");
//        调用传入的方法
        Object result = method.invoke(target, args);
        System.out.println("日志记录");
        return result;
    }
}
