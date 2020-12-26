package com.example.javalanguaguetest.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/24 1:20 上午
 */
//add 增加一个元素 如果队列已满，则抛出一个IIIegaISlabEepeplian异常
//remove 移除并返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
//element 返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
//offer 增加一个元素并返回true 如果队列已满，则返回false
//poll 移除并返回头部的元素 如果队列为空，则返回null
//peek 返回队列头部的元素 如果队列为空，则返回null
//put 添加一个元素 在队列满时会阻塞
//take 移除并返回队列头部的元素 在队列空时阻塞
//不能插入null
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();

        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");

        for (String q : queue) {
            System.out.println(q);
        }

        System.out.println("===");
        System.out.println("poll=" + queue.poll());
        for (String q : queue) {
            System.out.println(q);
        }

        System.out.println("===");
        System.out.println("element=" + queue.element());
        for (String q : queue) {
            System.out.println(q);
        }

        System.out.println("===");
        System.out.println("peek=" + queue.peek());
        for (String q : queue) {
            System.out.println(q);
        }

        System.out.println("===");
        System.out.println("is queue empty?: " + queue.isEmpty());

        System.out.println("===");
        System.out.println("size of queue:" + queue.size());

        System.out.println("===");
        String name = "e";
        if (queue.contains(name)) {
            System.out.println("queue contains: " + name);
        } else {
            System.out.println("queue does not contains: " + name);
        }

        System.out.println("===Iterating over a Queue using Java 8 forEach()===");
//        lambda表达式
        queue.forEach(ele -> System.out.println(ele));

        System.out.println("===Iterating over a Queue using iterator()===");
        Iterator<String> queueIterator = queue.iterator();
        ;
        while (queueIterator.hasNext()) {
            String elem = queueIterator.next();
            System.out.println(elem);

        }

        System.out.println("===Iteratoring over a Queue using iterator() and Java 8 forEachRemaining() ===");
//        复位
        queueIterator = queue.iterator();
        queueIterator.forEachRemaining(ele -> System.out.println(ele));

        System.out.println("===Iterating over a Queue using simple for-each loop===");
        for (String na : queue) {
            System.out.println(na);
        }

    }
}
