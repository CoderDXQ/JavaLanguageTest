package com.example.designpatterns.strategy;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/13 11:48 下午
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

//        注入策略 也可以在创建实例的注入策略，有构造方法来实现
        context.setStrategy(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context.setStrategy(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context.setStrategy(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
