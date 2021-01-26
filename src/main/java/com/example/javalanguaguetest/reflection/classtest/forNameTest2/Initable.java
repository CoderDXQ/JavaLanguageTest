package com.example.javalanguaguetest.reflection.classtest.forNameTest2;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/27 1:30 上午
 */
public class Initable {

    //    这是一个编译期常量（因为有final修饰） 不会进行本类的初始化
    static final int staticFinal = 47;
    //    调用静态内部实例  这不是一个编译期常量（即使有final修饰）  会导致本类的初始化
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }

}
