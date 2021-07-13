package com.example.designpatterns.visitor;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/14 12:45 上午
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {
//        接待中心实例
        ComputePart computePart = new Computer();
        computePart.accept(new ComputerPartDisplayVisitor());
    }
}
