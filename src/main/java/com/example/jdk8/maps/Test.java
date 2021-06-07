package com.example.jdk8.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/7 12:21 上午
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
//        元素类型要搞对
        map.forEach((id, val) -> System.out.println(val));

        System.out.println();

//        存在则计算
        map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println(map.get(3));
        System.out.println();

        map.computeIfPresent(9, (num, val) -> null);
        System.out.println(map.containsKey(9));
        System.out.println();

        map.computeIfAbsent(23, num -> "val" + num);
        System.out.println(map.get(23));
        System.out.println();

//        缺失则替换  在这里不需要替换
        map.computeIfAbsent(2, num -> "bam");
        System.out.println(map.get(2));
        System.out.println();

//        删除一个键和值都完全匹配的项
        System.out.println(map.get(5));
        map.remove(5, "val5");
        System.out.println(map.get(5));
        System.out.println();

        System.out.println(map.getOrDefault(42, "not found"));
        System.out.println(map.get(42));
        System.out.println();

//        合并 连接
        System.out.println(map.get(9));
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));
        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));
    }
}
