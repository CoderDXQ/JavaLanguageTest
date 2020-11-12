package com.example.javalanguaguetest.extendstest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/12 8:15 下午
 */
public class ManagerTest {
    public static void main(String[] args) {

        //LocaDate的处理 这个时间只能有一个值 不能变化 否则就不是当地时间的意思了 当地时间的值具有唯一性
        String str = "1987-12-15";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Manager boss = new Manager("Carl Cracker", 80000, LocalDate.parse(str, fmt));

        boss.setBonus(5000);

        Employee[] staff = new Employee[3];
        //子类对象可以赋值给父类 反之则不能
        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, LocalDate.parse(str, fmt));
        staff[2] = new Employee("Tommy Tester", 40000, LocalDate.parse(str, fmt));

        //当子类重写了父类方法时 优先调用子类重写的方法 boss.getSalary()即是如此
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
    }
}
