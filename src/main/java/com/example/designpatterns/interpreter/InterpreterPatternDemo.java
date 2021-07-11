package com.example.designpatterns.interpreter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/11 10:41 下午
 */
public class InterpreterPatternDemo {

    //    按照规则构造相应的解释器
    //    规则：Robert和John是男性 只要包含这两个词其一的都是男性
    public static Expression getMaleExpression() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    //    规则：Julie是一个已婚女性
    public static Expression getMarriedWomanExpression() {
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
//        获得解释器
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("DDD is male? " + isMale.interpret("DDD"));

        System.out.println("Julie is a married women? "
                + isMarriedWoman.interpret("Married Julie"));

        System.out.println("Laurence is a married women? "
                + isMarriedWoman.interpret("Laurence Julie"));

    }
}
