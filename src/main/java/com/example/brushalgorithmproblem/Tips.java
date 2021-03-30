package com.example.brushalgorithmproblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/29 4:40 下午
 */

//做题时常用的一些技巧方法
public class Tips {


    public static void main(String[] args) {

//        基本类型数组转包装类型数组
        int[] jilu = new int[]{};
        Integer[] jisuan = IntStream.of(jilu).boxed().collect(Collectors.toList()).toArray(new Integer[0]);

//        二维数组排序
        int[][] intervals = new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer i1 = o1[0];
                Integer i2 = o2[0];
                return i1.compareTo(i2);
            }
        });

    }


}
