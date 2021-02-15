package com.example.jdk8.lambda;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/15 11:11 下午
 */

//策略设计模式的接口
public interface MyPredicate<T> {
    //    定义接口中的方法
    public boolean test(
            T t
    );
}
