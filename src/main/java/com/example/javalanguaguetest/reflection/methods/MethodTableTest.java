package com.example.javalanguaguetest.reflection.methods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/15 7:13 下午
 */
public class MethodTableTest {

    public static void main(String[] args) throws Exception {
        //获得对象所声明的公开方法 private方法不能获取
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);


        //执行方法
        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);

        System.out.println();

        System.out.println("The following call will generate an exception.");
        //编译时没有错误 但是运行时会有错误 获得对象所声明的公开方法 private方法不能获取
        Method prisquare = MethodTableTest.class.getMethod("privatesquare", double.class);
    }

    public static double square(double x) {
        return x * x;
    }

    private static double privatesquare(double x) {
        return x * x;
    }

    public static void printTable(double from, double to, int n, Method f) {
        //打印方法的声明
        System.out.println(f);

        double dx = (to - from) / (n - 1);

        for (double x = from; x <= to; x += dx) {
            try {
                //反射调用方法
                double y = (Double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
