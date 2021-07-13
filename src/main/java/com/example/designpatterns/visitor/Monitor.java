package com.example.designpatterns.visitor;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/14 12:44 上午
 */
public class Monitor implements ComputePart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
