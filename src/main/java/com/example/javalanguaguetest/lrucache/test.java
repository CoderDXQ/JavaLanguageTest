package com.example.javalanguaguetest.lrucache;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/2 12:36 上午
 */
public class test {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);

        lruCache.put(1, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);

        lruCache.printLRUCache();
        System.out.println();

        lruCache.put(4, 4);
        lruCache.put(5, 5);
        lruCache.put(6, 6);

        lruCache.printLRUCache();
        System.out.println();
        System.out.println(lruCache.getSize());
        System.out.println(lruCache.getCapacity());


        System.out.println();
        lruCache.put(1, 1);
        lruCache.printLRUCache();

        System.out.println();
        lruCache.get(3);
        lruCache.printLRUCache();
    }
}
