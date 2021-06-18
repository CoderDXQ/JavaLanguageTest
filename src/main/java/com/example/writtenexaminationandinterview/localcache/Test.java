package com.example.writtenexaminationandinterview.localcache;

import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/18 11:03 下午
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        LFUCache localCache = new LFUCache(5);
        localCache.put("key", 666, 4);
        System.out.println("清理缓存前key : " + localCache.get("key"));
        TimeUnit.SECONDS.sleep(6);
        System.out.println("清理缓存后key : " + localCache.get("key"));
        System.out.println();

        LFUCache localCache1 = new LFUCache(3);
        for (int i = 0; i < 3; i++) {
            localCache1.put("key" + i, "name" + i, 10);
        }

//        输出结果会有一个null 因为容量是3 会有一个被淘汰
        for (int i = 0; i < 3; i++) {
            System.out.println(localCache1.get("key" + i));
        }

//        触发淘汰
        localCache1.put("key3", "name3", 10);
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.println(localCache1.get("key" + i));
        }

        LRUCache lruCache = new LRUCache(5);
        for (int i = 0; i < 5; i++) {
            lruCache.put("lru" + i, "张三" + i);
        }
//        触发淘汰
        lruCache.put("lru5", "李四");

        for (int i = 0; i < 6; i++) {
            System.out.println(lruCache.get("lru" + i));
        }


    }
}
