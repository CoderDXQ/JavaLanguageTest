package com.example.javalanguaguetest.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/17 10:50 上午
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        long totaltime = 0;

        //控制台输入以command+D结束
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totaltime += callTime;
            }
        }

        Iterator<String> iter = words.iterator();
        for (int i = 0; i <= 20 && iter.hasNext(); i++)
            System.out.println(iter.next());

        System.out.println("...");
        System.out.println(words.size() + " distinct words. " + totaltime + " milliseconds.");
    }
}
