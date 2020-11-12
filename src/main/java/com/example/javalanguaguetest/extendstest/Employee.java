package com.example.javalanguaguetest.extendstest;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/12 8:14 下午
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, LocalDate hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    //传入的是加薪的百分比
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        //强制类型转换
        Employee other = (Employee) otherObject;

        return Objects.equals(name, other.name) && salary == other.getSalary() && Objects.equals(hireDay, other.hireDay);

    }

    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";

    }


}
