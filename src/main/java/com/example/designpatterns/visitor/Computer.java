package com.example.designpatterns.visitor;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/14 12:44 上午
 */
//接待中心的实现类
public class Computer implements ComputePart {
    ComputePart[] parts;

    public Computer() {
        parts = new ComputePart[]{new Mouse(), new Keyboard(), new Monitor()};
    }

    //    各部分接待游客
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (ComputePart part : parts) {
            part.accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
