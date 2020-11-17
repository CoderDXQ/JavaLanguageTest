package com.example.javalanguaguetest.collections.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/17 12:25 下午
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("1", new Employee("a"));
        staff.put("2", new Employee("b"));
        staff.put("3", new Employee("c"));
        staff.put("4", new Employee("d"));

        //需要在Employee类中重写toString()方法才能正确输出 否则只能输出hashcode
        System.out.println(staff);

        //移除元素
        staff.remove("2");
        System.out.println(staff);

        //覆盖元素
        staff.put("4", new Employee("e"));
        System.out.println(staff);

        //输出某个元素
        System.out.println(staff.get("3"));

        //遍历 lambda表达式
        staff.forEach((k, v) -> System.out.println("key=" + k + ",value=" + v));
    }
}
