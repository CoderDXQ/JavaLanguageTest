package com.example.designpatterns.visitor;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/14 12:45 上午
 */
//访客可以访问不同的接口 通过注入不同的part的实现类的实例来决定访问哪里
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }
}
