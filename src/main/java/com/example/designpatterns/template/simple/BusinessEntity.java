package com.example.designpatterns.template.simple;

import com.example.designpatterns.template.simple.ATemplate;

/**
 * @author duanxiangqing
 * @date 2021/5/30
 */
//模板类的实现类
public class BusinessEntity extends ATemplate {

    @Override
    protected void before() {
        super.before();
        System.out.println("Before!");
    }

    @Override
    public void doAction() {
        System.out.println("doAction1");
    }

}
