package com.example.jdk8.functioninterface.converter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/6 10:23 下午
 */
//函数式接口 传入和传出值
@FunctionalInterface
public interface Converter<F, T> {
    //    抽象方法 函数式接口
    T convert(F from);

}

