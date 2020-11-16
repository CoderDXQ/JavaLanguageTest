package com.example.javalanguaguetest.generics.pair2;

import java.time.LocalDate;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/16 4:10 下午
 */
public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(1906, 12, 9),
                LocalDate.of(1815, 12, 10),
                LocalDate.of(1903, 12, 3),
                LocalDate.of(1910, 6, 22),
        };
        //使用泛型方法 可以向该方法传入不同类型的参数 减少了方法的多态的实现代码量
        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min=" + mm.getFirst());
        System.out.println("max=" + mm.getSecond());
        System.out.println();

        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mmm = ArrayAlg.minmax(words);
        System.out.println("min=" + mmm.getFirst());
        System.out.println("max=" + mmm.getSecond());
    }
}


class ArrayAlg {
    //泛型方法
    //T和Comparable绑定，绑定的对象可以是类也可以是接口 这叫类型限定，限定之后T只有被绑定的方法
    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        //返回一个实例化对象
        return new Pair<>(min, max);
    }
}
