package com.example.javalanguaguetest.extendstest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/12 10:03 下午
 */
public class EqualsTest {
    public static void main(String[] args) {


        //同一台机器上 如果设置了当前时间 那么所有文件的当前时间都是统一的 不允许多态存在
        String st1 = "1987-12-15";
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Employee alice1 = new Employee("Alice Adams", 75000, LocalDate.parse(st1, fmt1));
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice Adams", 75000, LocalDate.parse(st1, fmt1));
        Employee bob = new Employee("Bob Brandson", 50000, LocalDate.parse(st1, fmt1));

        System.out.println("alice1==alice2: " + (alice1 == alice2));
        System.out.println("alice1==alice3: " + (alice1 == alice3));

        System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));
        System.out.println("alice1.equals(bob): " + alice1.equals(bob));

        System.out.println("bob.toString(): " + bob);

        Manager carl = new Manager("Carl Cracker", 80000, LocalDate.parse(st1, fmt1));
        Manager boss = new Manager("Carl Cracker", 80000, LocalDate.parse(st1, fmt1));
        boss.setBonus(5000);

        System.out.println("boss.toString(): " + boss);
        System.out.println("carl.equals(boss): " + carl.equals(boss));

        //下面两个的值是相同的 因为这两个对象在虚拟机中都指向同一个常量池中的元素
        System.out.println("alice1.hashCode(): " + alice1.hashCode());
        System.out.println("alice3.hashCode(): " + alice3.hashCode());

        System.out.println("bob.hashCode(): " + bob.hashCode());
        System.out.println("carl.hashCode(): " + carl.hashCode());
    }
}
