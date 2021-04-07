package com.example.writtenexaminationandinterview.proxy.staticproxy;

import org.junit.Test;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 2:03 下午
 */
public class TestProxy {

    @Test
    public void testStaticProxy(){
//        目标对象
        IUserDao target=new UserDao();
//        代理对象 代理对象帮忙执行目标对象的方法
        UserDaoProxy proxy=new UserDaoProxy(target);
        proxy.save();

    }

}
