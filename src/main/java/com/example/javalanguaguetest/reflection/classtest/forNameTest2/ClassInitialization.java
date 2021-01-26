package com.example.javalanguaguetest.reflection.classtest.forNameTest2;

import com.sun.org.apache.xml.internal.security.Init;

import java.util.Random;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/27 2:30 上午
 */
public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {

        Class initable = Initable.class;
        System.out.println("after creating Initable ref");
//        Initable.staticFinal有final修饰，被认为是编译期常量，不会导致初始化
        System.out.println("Initable.staticFinal：" + Initable.staticFinal);
//        下面这句输出的不是编译期常量  导致了Initable类的初始化，进而导致了静态代码块的执行
        System.out.println("Initable.staticFinal2：" + Initable.staticFinal2);

        System.out.println();
//        会导致类的初始化，进而会执行静态代码块
        System.out.println("Initable2.staticNonFinal" + Initable2.staticNonFinal);


        System.out.println();
//        不会进行初始化，但是会进行解释
        Class initable3 = Class.forName("com.example.javalanguaguetest.reflection.classtest.forNameTest2.Initable3");
        System.out.println("after creating Initable3 ref");
        System.out.println("Initable3.staticNonFinal：" + Initable3.staticNonFinal);
    }
}
