package com.example.designpatterns.interpreter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/11 10:37 下午
 */
//表达式实现类 一个基本的实现
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    //    判断传入的字符串中是否包含data
    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}
