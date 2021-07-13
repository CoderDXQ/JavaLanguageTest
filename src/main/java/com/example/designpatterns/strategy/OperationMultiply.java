package com.example.designpatterns.strategy;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/13 11:47 下午
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
