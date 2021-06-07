package com.example.jdk8.optional;

import java.util.Optional;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/6 11:29 下午
 */
public class Test {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");
//        判断是否有值
        System.out.println(optional.isPresent());
//        获取值
        System.out.println(optional.get());
//        判断是否有值 如果有将其返回 如果没有返回括号里的参数
        System.out.println(optional.orElse("fallback"));
//        optional.isPresent((s) -> System.out.println(s.charAt(0)));

        System.out.println();
        System.out.println(optional.get());
//        过滤 输出结果为Optional.empty
        System.out.println(optional.filter(a -> a.startsWith("a")));

    }

}
