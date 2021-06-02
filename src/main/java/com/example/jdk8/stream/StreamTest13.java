package com.example.jdk8.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author duanxiangqing
 * @date 2021/6/2
 */
//List转Map
public class StreamTest13 {


    public static void main(String[] args) {

        List<Long> nums = Arrays.asList(2L, 3L, 4L, 5L, 1L, 9L, 8L);

//        构造测试map
        Map<Long, Long> map = nums.stream().collect(Collectors.toMap(key -> key, key -> key + 1));

        map.forEach((a, b) -> System.out.println("key: " + a + " ,value: " + b));
        System.out.println();

//        在lambda表达式中 参数相同的情况的处理
//        Map<Long, Long> numsMap = nums.stream().collect(Collectors.toMap(key -> key, key -> map.get(key)));
        Map<Long, Long> numsMap = nums.stream().collect(Collectors.toMap(key -> key, value -> value));

        numsMap.forEach((a, b) -> System.out.println("key: " + a + " ,value: " + b));

    }


}
