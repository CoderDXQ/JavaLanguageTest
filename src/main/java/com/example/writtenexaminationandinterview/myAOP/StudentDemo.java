package com.example.writtenexaminationandinterview.myAOP;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/6 10:32 下午
 */
//测试类
public class StudentDemo {

    public static void main(String[] args) {
        StudentDao sd = new StudentDaoImpl();
        sd.login();
        sd.regist();
        System.out.println("---------------------------");

        MyInvocationHandler handler = new MyInvocationHandler();
        StudentDao proxy = (StudentDao) handler.bind(sd);
        proxy.login();
        proxy.regist();

    }

}
