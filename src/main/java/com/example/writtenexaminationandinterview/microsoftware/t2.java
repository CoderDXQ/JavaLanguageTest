package com.example.writtenexaminationandinterview.microsoftware;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/28 2:19 下午
 */
public class t2 {

    //    注意去重的情况
    public static int solution(int N, int[] A, int[] B) {
        // write your code in Java SE 8
//        存的是次数
        int[] jilu = new int[N + 1];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            jilu[A[i]]++;
            jilu[B[i]]++;
        }

        Integer[] jisuan = IntStream.of(jilu).boxed().collect(Collectors.toList()).toArray(new Integer[0]);

        Arrays.sort(jisuan, Collections.reverseOrder());

        int i = 0;
        while (jisuan[i] > 0) {
            sum += jisuan[i] * N;
            N--;
            i++;
        }

        return sum;
    }

    public static void main(String[] args) {
        int N = 3;
        int[] A = new int[]{1};
        int[] B = new int[]{3};
        System.out.println(solution(N, A, B));

    }

}
