package com.example.jdk8.lambda;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/15 11:53 下午
 */
//函数式接口：只有一个抽象方法的接口叫做函数式接口
@FunctionalInterface //注明是函数式接口
public interface MyFunc {
    public Integer getValue(Integer num);
}
