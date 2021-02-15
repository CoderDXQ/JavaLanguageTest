package com.example.jdk8.lambda;

import com.example.javalanguaguetest.callback.two_writing_method_of_callback2.Li;
import org.junit.Test;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/12 1:46 下午
 */
public class LambdaTest {

    @Test
    public void test1() {
//        原来匿名内部类的写法 一个比较类
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
//TreeSet是一个有序的SET集合 在com中定义了排序(比较)规则
        TreeSet<Integer> ts = new TreeSet<Integer>(com);
    }

    //使用lambda表达式的匿名内部类的写法
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ys = new TreeSet<Integer>(com);
    }


    List<Employee> employees = Arrays.asList(
            new Employee("AA", 18, 99),
            new Employee("BB", 40, 99),
            new Employee("CC", 60, 99),
            new Employee("DD", 88, 99),
            new Employee("EE", 18, 99)
    );

    @Test //会自动执行上面的赋值语句
    public void test3() {
        List<Employee> list = filterEmployees(employees);

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    //    传统的过滤器写法
    public List<Employee> filterEmployees(List<Employee> list) {

        List<Employee> emps = new ArrayList<>();

        for (Employee emp : list) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }
        return emps;
    }

    //    按照策略设计模式来实现过滤器 需要传入实现接口的类 类中有过滤规则（一个方法）
    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {

        List<Employee> emps = new ArrayList<>();

        for (Employee employee : list) {
            if (mp.test(employee)) {
                emps.add(employee);
            }
        }
        return emps;
    }

    //策略设计模式和匿名内部类实现过滤器
    @Test
    public void test5() {
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() <= 5000;
            }
        });
        list.forEach(System.out::println);
    }


    //    使用策略设计模式和lambda写匿名内部类的过滤器写法
    @Test
    public void test4() {
        List<Employee> list = filterEmployee(employees, (e) -> e.getSalary() <= 5000);
        list.forEach(System.out::println);
    }

    //    使用stream流实现过滤器
    @Test
    public void test6() {
        employees.stream()
                .filter((e) -> e.getSalary() <= 5000)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("-----------------------------------------");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

}
