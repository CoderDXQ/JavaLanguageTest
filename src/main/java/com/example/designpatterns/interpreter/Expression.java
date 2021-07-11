package com.example.designpatterns.interpreter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/11 10:34 下午
 */
//表达式接口
public interface Expression {
    public boolean interpret(String context);
}
