package com.example.designpatterns.visitor;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/14 12:43 上午
 */
//接待中心 接待访客并提供服务
public interface ComputePart {
    //    注入访客然后才能提供服务、
    public void accept(ComputerPartVisitor computerPartVisitor);
}
