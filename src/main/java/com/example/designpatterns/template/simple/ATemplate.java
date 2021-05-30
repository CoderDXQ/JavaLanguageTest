package com.example.designpatterns.template.simple;

/**
 * @author duanxiangqing
 * @date 2021/5/30
 */
//模板方法类 是一个抽象类
public abstract class ATemplate {

//    模板方法
    public void templateMethod() {
        before();
        doAction();
        after();
    }

//    钩子函数
    protected void before() {
    }

//    抽象方法 子类继承后重写业务逻辑
    public abstract void doAction();

    private void after() {
        System.out.println("After!");
    }

}
