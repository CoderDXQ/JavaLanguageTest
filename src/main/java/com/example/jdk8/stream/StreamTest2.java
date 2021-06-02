package com.example.jdk8.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/2 12:59 上午
 */
public class StreamTest2 {


    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        List<Integer> squaresList = numbers.stream()
                .map(i -> i * i)
                .sorted((x, y) -> y - x)
                .collect(Collectors.toList());
        squaresList.forEach(System.out::println);
        System.out.println();

        squaresList.forEach(num -> {
            num++;
            System.out.println(num);
        });
        System.out.println();

//        List转Map
        List<String> strList = Arrays.asList("a", "ba", "bb", "abc", "cbb", "bba", "cab");
        Map<Integer, String> strMap = new HashMap<>();

        strMap = strList.stream()
                .collect(Collectors.toMap(str -> strList.indexOf(str), str -> str));

        strMap.forEach((key, value) -> {
            System.out.println(key + "::" + value);
        });


    }


}
