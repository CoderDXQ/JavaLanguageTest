package com.example.writtenexaminationandinterview.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 2:29 下午
 */
public class ProxyFactory implements MethodInterceptor {

    //    目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
//        工具类
        Enhancer en = new Enhancer();
//        设置父类
        en.setSuperclass(target.getClass());
//        设置回调函数 自动回调intercept()方法
        en.setCallback(this);
//        创建子类对象代理
        return en.create();
    }

    //    代理对象调用save()方法的时候被拦截 然后执行这个方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
//        执行目标对象方法
        Object returnValue = method.invoke(target, objects);
        System.out.println("关闭事务");
        return null;
    }

}
