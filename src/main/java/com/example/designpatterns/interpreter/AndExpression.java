package com.example.designpatterns.interpreter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/11 10:40 下午
 */
//表达式实现类 组合实现
public class AndExpression implements Expression {
    private Expression expr1 = null;
    private Expression expr2 = null;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}
