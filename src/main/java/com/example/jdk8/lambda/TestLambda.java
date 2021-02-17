package com.example.jdk8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/17 10:55 下午
 */
public class TestLambda {

    List<Employee> employees = Arrays.asList(
            new Employee("AA", 18, 99),
            new Employee("BB", 40, 99),
            new Employee("CC", 60, 99),
            new Employee("DD", 88, 99),
            new Employee("EE", 18, 99)
    );


    //使用lambda表达式进行多条件排序
    @Test
    public void test1() {
//        sort接口需要传入被排序的数组和排序类（这里使用lambda写了一个匿名内部类）
        Collections.sort(employees, (e1, e2) -> {
//            年龄相同的按名字的字典序排
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
//                按年龄从大到小排
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        employees.forEach(System.out::println);
    }


    //    lambda实现的匿名内部类就包含具体的策略
    @Test
    public void test2() {
//        去掉前面的空格
        String trimstr = strHandler("\t\t\tjsdbv", (str) -> str.trim());
        System.out.println(trimstr);
//        小写转大写
        String upper = strHandler("svfds", (str) -> str.toUpperCase());
        System.out.println(upper);
//        截取  将字符串和lambda实现的匿名内部类传入strHandler()方法，该匿名内部类被认为是MyFunction接口的实现类，实现了其中的getValue()方法
        String newStr = strHandler("asdfghjkl", (str) -> str.substring(2, 5));
        System.out.println(newStr);
    }

    //    策略模式
    public String strHandler(String str, MyFunction mf) {
        return mf.getValue(str);
    }

    //    lambda表达式实现的匿名内部类就包含具体的策略
    @Test
    public void test3() {
        op(100L, 200L, (x, y) -> x + y);

        op(100L, 200L, (x, y) -> x * y);
    }

    public void op(Long l1, Long l2, MyFunction2<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }


}
