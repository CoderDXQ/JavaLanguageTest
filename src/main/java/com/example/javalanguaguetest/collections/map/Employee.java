package com.example.javalanguaguetest.collections.map;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/17 12:25 下午
 */
public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
