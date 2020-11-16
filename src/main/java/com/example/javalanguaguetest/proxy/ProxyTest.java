package com.example.javalanguaguetest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/16 10:28 上午
 */

//代理可以被认为是一种重定向的方法 在运行时重定向某些类的某些方法
public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        //这个数组是顺序的
        for (int i = 0; i < elements.length; i++) {
            //定义一个Integer类
            Integer value = i + 1;
            //把定义的Integer类包装进InvocationHandler类（调用处理类）
            InvocationHandler handler = new TraceHandler(value);

            //把InvocationHandler类包装进动态处理类
            //动态代理类 在运行时创建一个实现某些给定接口的新类及其实例对象
            //下面这个方法的三个参数 类加载器类型 该方法返回对象实现的接口 调用处理器(内含invoke()方法，invoke()方法是自动执行的)
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        //生成要在element[]数组中查找的值
        Integer key = new Random().nextInt(elements.length) + 1;
        System.out.println("key=" + key);

        //result是在element[]数组中二分查找的位置结果
        //二分查找的过程中 element[]数组中被经历的元素会调用自己的invoke()方法

        //在二分查找过程中，由于element[]数组中的元素是代理对象类 代理对象类也实现了Comparable接口 这个接口直接调用代理对象处理器的invoke()方法进行输出
        //然后，由于element[]数组中的元素是包装的Integer类 然后再执行Integer类的Comparable接口
        int result = Arrays.binarySearch(elements, key);
        System.out.println("result=" + result);


        System.out.println();
        //这里的println()方法先调用代理对象的toString()方法 然后再调用Integer类的toString()方法
        if (result >= 0) System.out.println(elements[result]);
    }
}


class TraceHandler implements InvocationHandler {
    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    //重写invoke()方法 多态 这里调用的是compareTo()方法
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + m.getName() + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");
        //调用Integer类原来被代理接口 即调用被包装的类的被代理的接口
        return m.invoke(target, args);
    }
}


