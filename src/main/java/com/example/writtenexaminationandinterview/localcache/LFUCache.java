package com.example.writtenexaminationandinterview.localcache;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/18 9:46 下午
 */
//LFU的淘汰策略是在不过期的数据中淘汰使用次数最少的那个  因此需要记录每个key使用的次数 并且要启动一个线程定时淘汰过期数据
public class LFUCache<K, V> {

    private ConcurrentHashMap<Object, Cache> concurrentHashMap;

    //缓存长度
    final int size;

    public LFUCache(int size) {
        this.concurrentHashMap = new ConcurrentHashMap<>(size);
        this.size = size;
//        在构造这个实例的时候启动一个线程处理过期缓存 淘汰或者更新
        new Thread(new TimeoutTimerThread()).start();
    }

    //    检测字段是否合法
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    //    判满
    private boolean isFull() {
        return concurrentHashMap.size() == size;
    }

    //    或许最少使用的缓存
    private Object getKickedKey() {
        Cache min = Collections.min(concurrentHashMap.values());
        return min.getKey();
    }

    //    获取key对应的键值
    public Object get(K key) {
        checkNotNull(key);
        if (concurrentHashMap.isEmpty()) {
            return null;
        }
        if (!concurrentHashMap.containsKey(key)) {
            return null;
        }
//        先获取cache
        Cache cache = concurrentHashMap.get(key);
        if (cache == null) {
            return null;
        }
        cache.setHitCount(cache.getHitCount() + 1);
        cache.setAccessTime(System.currentTimeMillis());
//        再获取键值
        return cache.getValue();
    }

    public void put(K key, V value, long expire) {
        checkNotNull(key);
        checkNotNull(value);
//        当缓存存在时，更新缓存
        if (concurrentHashMap.containsKey(key)) {
            Cache cache = concurrentHashMap.get(key);
            cache.setExpireTime(expire);
            cache.setValue(value);
            cache.setHitCount(cache.getHitCount() + 1);
            cache.setAccessTime(System.currentTimeMillis());
            cache.setWriteTime(System.currentTimeMillis());
            return;

        }
//        当缓存满时清理缓存
        if (isFull()) {
            Object kickedKey = getKickedKey();
            if (kickedKey != null) {
                concurrentHashMap.remove(kickedKey);
            } else {
                return;
            }
        }
//        插入原本不存在的缓存
        Cache cache = new Cache();
        cache.setKey(key);
        cache.setValue(value);
        cache.setHitCount(1);
        cache.setWriteTime(System.currentTimeMillis());
        cache.setAccessTime(System.currentTimeMillis());
        cache.setExpireTime(expire);
        concurrentHashMap.put(key, cache);
    }


    //    处理过期缓存的线程
    class TimeoutTimerThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
//                    睡眠一段时间  防止浪费计算资源
                    TimeUnit.SECONDS.sleep(3);
//                    执行缓存过期处理策略
                    expireCache();
                    if (concurrentHashMap.isEmpty()) {
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void expireCache() {
            System.out.println("检测缓存是否过期");
//            遍历检查  这不是lazy模式
            for (Object key : concurrentHashMap.keySet()) {
                Cache cache = concurrentHashMap.get(key);
//                计算某个缓存已经存在的时间
                long timeoutTime = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - cache.getWriteTime());
                System.out.println(timeoutTime);
                if (cache.getExpireTime() > timeoutTime) {
                    continue;
                }
//                清理缓存
                System.out.println("清除过期缓存 : " + key);
                concurrentHashMap.remove(key);
            }
        }
    }
}
