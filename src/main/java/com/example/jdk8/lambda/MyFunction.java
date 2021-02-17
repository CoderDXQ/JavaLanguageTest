package com.example.jdk8.lambda;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/17 11:16 下午
 */

//策略模式
@FunctionalInterface//声明这是一个函数式接口
public interface MyFunction {
    public String getValue(String str);
}
