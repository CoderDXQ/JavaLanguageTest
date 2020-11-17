package com.example.javalanguaguetest.collections.priorityQueue;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/17 12:19 下午
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1906, 12, 9));
        pq.add(LocalDate.of(1815, 12, 10));
        pq.add(LocalDate.of(1903, 12, 3));
        pq.add(LocalDate.of(1910, 6, 22));

        System.out.println("Iterating over elements...");
        for (LocalDate date : pq)
            System.out.println(date);
        System.out.println("Removing elements...");
        while (!pq.isEmpty())
            System.out.println(pq.remove());

        System.out.println("Now...");
        if (pq.isEmpty()) System.out.println("It is empty.");
        for (LocalDate date : pq)
            System.out.println(date);
    }
}
