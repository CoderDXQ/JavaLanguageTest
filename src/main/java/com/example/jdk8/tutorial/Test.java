package com.example.jdk8.tutorial;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/6 10:05 下午
 */

//接口
interface Formula {

    //    抽象方法 没有实现 会被重写
    double calculate(int a);

    //    虚拟扩展方法  向接口添加非抽象方法的实现
    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}

public class Test {


    public static void main(String[] args) {

//        内部实现类
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(100));

    }

}
