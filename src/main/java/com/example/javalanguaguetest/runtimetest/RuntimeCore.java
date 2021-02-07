package com.example.javalanguaguetest.runtimetest;

import com.sun.tools.classfile.ConstantPool;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/7 10:18 下午
 */
public class RuntimeCore {


    public static void main(String[] args) {
//        Runtime:运行时，是一个封装了JVM的类。每一个JAVA程序实际上都是启动了一个JVM进程，每一个JVM进程都对应一个Runtime实例，此实例是由JVM为其实例化的。所以我们不能实例化一个Runtime对象，应用程序也不能创建自己的 Runtime 类实例，但可以通过 getRuntime 方法获取当前Runtime运行时对象的引用。一旦得到了一个当前的Runtime对象的引用，就可以调用Runtime对象的方法去控制Java虚拟机的状态和行为。
//        查看官方文档可以看到，Runtime类中没有构造方法，本类的构造方法被私有化了， 所以才会有getRuntime方法返回本来的实例化对象，这与单例设计模式不谋而合
//          这实际上就是个单例
//        Runtime runtime = new Runtime();
        Runtime runtime = Runtime.getRuntime();

//        查看可用的线程数
        System.out.println(runtime.availableProcessors());

    }


}
