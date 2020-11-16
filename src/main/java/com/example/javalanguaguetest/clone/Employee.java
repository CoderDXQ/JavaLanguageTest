package com.example.javalanguaguetest.clone;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/15 8:41 下午
 */
public class Employee implements Cloneable {
    private String name;
    private double salary;
    private Date hireday;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireday = new Date();
    }

    //clone()方法是Cloneable接口中定义的访达 在这里重写
    public Employee clone() throws CloneNotSupportedException {
        //调用Object类的clone()方法
        Employee cloned = (Employee) super.clone();
        System.out.println("***********************在Employee类的clone()方法内部******************************");
        System.out.println(cloned);
        System.out.println("***********************************************************************");

        cloned.hireday = (Date) hireday.clone();
        System.out.println(cloned);

        cloned.setHireday(1999,9,9);
        System.out.println("***********************************************************************");

        return cloned;
    }

    //设置雇佣时间
    public void setHireday(int year, int month, int day) {
        Date newHireday = new GregorianCalendar(year, month - 1, day).getTime();
        hireday.setTime(newHireday.getTime());
    }

    //加薪
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    //重写toString()方法
    public String toString() {
        return "Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireday + "]";
    }
}
