package com.example.javalanguaguetest.generics.pair1;


/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/16 3:47 下午
 */
public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};

        //指定泛型的具体类型
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min=" + mm.getFirst());
        System.out.println("max=" + mm.getSecond());

    }
}

class ArrayAlg {
    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        //返回一个实例化对象
        return new Pair<>(min, max);
    }
}
