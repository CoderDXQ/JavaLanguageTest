package com.example.writtenexaminationandinterview.myAOP;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/6 10:24 下午
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public void login() {
        System.out.println("登录");
    }

    @Override
    public void regist() {
        System.out.println("注册");
    }
}
