package com.example.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/6 11:37 下午
 */
//JDK8 流计算
public class Test {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");

//        常用方法
        stringList
                .stream()
                .filter((s) -> s.startsWith("a"))
                .sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println();

//        匹配
        boolean anyStartsWithA = stringList
                .stream()
                .anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA);

        boolean allStartsWithA =
                stringList
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA);

        boolean noneStartsWithZ =
                stringList
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));
        System.out.println(noneStartsWithZ);
        System.out.println();

//        计数
        long startWithB =
                stringList
                        .stream()
                        .filter(s -> s.startsWith("b"))
                        .count();
        System.out.println(startWithB);
        System.out.println();

//        Reduce规约操作
//        连接
        Optional<String> reduced =
                stringList
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        System.out.println(reduced);

//        字符串连接
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);

//        求最小值
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);

//        求和 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumValue);

//        求和 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(sumValue);

//        过滤
        concat = Stream.of("a", "B", "c", "D", "e", "F")
                .filter(x -> x.compareTo("Z") > 0)
                .reduce("", String::concat);
        System.out.println(concat);

    }
}
