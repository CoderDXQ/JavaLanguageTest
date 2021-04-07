package com.example.writtenexaminationandinterview.proxy.dynamicproxy.cglib;

import org.junit.Test;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 2:35 下午
 */
public class TestProxy {

    @Test
    public void testCglibProxy(){
//        目标对象
        UserDao target=new UserDao();
        System.out.println(target.getClass());
//        代理对象 使用工厂模式创建子类代理对象 给目标对象增加功能
        UserDao proxy= (UserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
//        执行代理对象方法
        proxy.save();

    }


}
