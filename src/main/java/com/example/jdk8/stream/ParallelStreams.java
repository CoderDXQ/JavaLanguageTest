package com.example.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/7 12:00 上午
 */
//并行流是在多个线程中执行的
public class ParallelStreams {

    public static void main(String[] args) {

        int max = 1000000;
        List<String> values = new ArrayList<>(max);

        for (int i = 0; i < max; i++) {
            values.add(UUID.randomUUID().toString());
        }

//        串行
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("Sequential sort took: %d ms", millis));
//        并行
        t0 = System.nanoTime();
        count = values.parallelStream().sorted().count();
        System.out.println(count);
        t1 = System.nanoTime();
        millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("Parallel sort took: %d ms", millis));

    }

}
