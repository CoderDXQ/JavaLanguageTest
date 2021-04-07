package com.example.writtenexaminationandinterview.proxy.dynamicproxy.jdk;

import org.junit.Test;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 3:00 下午
 */
public class TestProxy {

    @Test
    public void testDynamicProxy() {
        IUserDao target = new UserDao();
//        输出目标对象信息
        System.out.println(target.getClass());
//        获取代理对象 代理对象通过getProxyInstance()方法实现对目标对象的功能加强
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
//        输出代理对象信息
        System.out.println(proxy.getClass());
//        执行代理方法
        proxy.save();
    }

}
