package com.example.javalanguaguetest.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/3 4:20 下午
 */

class Test {
    private String s;

    public Test() {
        s = "asdfghjkl";
    }

    public void method1() {
        System.out.println("The String is " + s);
    }

    public void method2(int n) {
        System.out.println("The number is " + n);
    }

    private void method3() {
        System.out.println("Private method invoked");
    }
}

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Test obj = new Test();

        Class cls = obj.getClass();
        //打印类名
        System.out.println("The name of class is " + cls.getName());

        Constructor constructor = cls.getConstructor();
        //打印构造器（构造方法）名
        System.out.println("The name of constructor is " + constructor.getName());

        System.out.println("\n");

        System.out.println("The public methods of class are :");
        //打印某个类里的公有方法名 包括一些默认的隐藏方法 私有方法在不使用反射的情况下无法被访问到
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        System.out.println("\n");


        //通过反射来调用method2()方法 参数是int
        //声明
        Method methodcall1 = cls.getDeclaredMethod("method2", int.class);
        //调用
        methodcall1.invoke(obj, 19);
        System.out.println("\n");


        //通过反射访问类的私有变量
        //获取私有字段
        Field field = cls.getDeclaredField("s");
        //允许访问该字段
        field.setAccessible(true);
        //赋值
        field.set(obj, "JAVA");
        Method methodcall2 = cls.getDeclaredMethod("method1");
        //invoke调用
        methodcall2.invoke(obj);
        System.out.println("\n");


        //通过反射访问类的私有方法
        Method methodcall3 = cls.getDeclaredMethod("method3");
        //允许访问该方法
        methodcall3.setAccessible(true);
        methodcall3.invoke(obj);
        System.out.println("\n");
    }
}
