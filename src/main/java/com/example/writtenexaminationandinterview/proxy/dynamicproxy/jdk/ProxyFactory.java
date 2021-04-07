package com.example.writtenexaminationandinterview.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 2:50 下午
 */
public class ProxyFactory {

    //    目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //    为目标对象生成代理对象  invoke方法中对目标对象的方法进行了加强
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务");
//                执行目标对象方法
                Object returnValue = method.invoke(target, args);
                System.out.println("提交事务");
                return null;
            }
        });


    }


}
