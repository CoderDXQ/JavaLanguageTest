package com.example.designpatterns.dataAccessObject;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/16 10:18 下午
 */
//数据实体
public class Student {
    private String name;
    private int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
