package com.example.jdk8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/2 12:17 上午
 */
//jdk8的stream流的用法
public class StreamTest1 {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

        System.out.println("列表: " + strings);

        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符串数量: " + count);

        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("字符串长度为3的数量为: " + count);

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选后的列表: " + filtered);

        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//        去重
        List<Integer> squareList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println("Square List: " + squareList);

        List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
        System.out.println("列表: " + integers);

        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中的最大的数: " + stats.getMax());
        System.out.println("列表中的最小的数: " + stats.getMin());
        System.out.println("所有数之和: " + stats.getSum());
        System.out.println("平均数: " + stats.getAverage());

        System.out.println("随机数: ");
        Random random = new Random();

        random.ints().limit(10).sorted().forEach(System.out::println);

        System.out.println("并行处理");
        count = strings.parallelStream().filter(string -> string.isEmpty()).count();

        System.out.println("并行处理空字符串的数量为: " + count);

    }

}
