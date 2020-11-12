package com.example.javalanguaguetest.extendstest;

import java.time.LocalDate;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/12 8:15 下午
 */
public class Manager extends Employee {
    private double bonus;

    //不能使用IDEA自动生成的 重写一个
    public Manager(String name, double salary, LocalDate hireDay) {
        super(name, salary, hireDay);
        bonus = 0;
    }

    //重写父类方法
    public double getSalary() {
        //调用父类方法
        double baseSalary = super.getSalary();
        return bonus + baseSalary;
    }

    //不能使用IDEA自动生成的 重写一个
    public void setBonus(double b) {
        bonus = b;
    }
}
