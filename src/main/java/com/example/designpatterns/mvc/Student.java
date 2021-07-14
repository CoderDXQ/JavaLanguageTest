package com.example.designpatterns.mvc;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/14 11:06 下午
 */
//model model一般存放数据或者与数据源进行交互
public class Student {
    private String rollNo;
    private String name;

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
