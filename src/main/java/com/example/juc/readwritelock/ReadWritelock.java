package com.example.juc.readwritelock;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/8 11:28 下午
 */

//为避免脏写问题的发生  每次只允许一个线程进行写操作，但是可以允许多个读线程进行读操作
public class ReadWritelock {
    public static void main(String[] args) {

//        使用无锁的类 会出现脏写问题
//        MyCache myCache = new MyCache();

//        使用有锁的类 不会出现脏写问题
        MyCacheLock myCache = new MyCacheLock();

//        写入
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp + "", temp + "");
            }, "线程" + String.valueOf(i)).start();
        }

        System.out.println();
//        Map的lambda表达式用法
        Map<String, Object> maps = myCache.getMap();
        maps.forEach((key, value) -> {
            System.out.println("key=" + key + " value=" + value);
        });
        System.out.println();

//        读取
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp + "");
            }, "线程" + String.valueOf(i)).start();
        }

    }
}

//自定义缓存 没有锁
@Data
class MyCache {
    //    这里使用Map模仿读和写
    private volatile Map<String, Object> map = new HashMap<>();

    //    存在多个线程同时写的问题、
    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入OK");
    }

    //多个线程同时读取
    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "读取key=" + key);
        Object o = map.get(key);

//        线程睡眠随机时间
        try {
            Random random = new Random();
            TimeUnit.SECONDS.sleep(Math.abs(random.nextInt() % 5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "读取key=" + key + "时value=" + o + " 完成读取");
    }


}

//有锁的自定义缓存
@Data
class MyCacheLock {

    //    这里使用Map模仿读和写
    private volatile Map<String, Object> map = new HashMap<>();

    //    读写锁，更加细粒度的控制 写锁只允许一个线程进入 读锁可重入
    private ReentrantReadWriteLock readWritelock = new ReentrantReadWriteLock();
    //    可重入锁
    private Lock lock = new ReentrantLock();

    public void put(String key, Object value) {
//        写锁只允许一个线程进入
        readWritelock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWritelock.writeLock().unlock();
        }
    }

    public void get(String key) {
//        读锁可重入
        readWritelock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            Object o = map.get(key);
            //        线程睡眠随机时间
            try {
                Random random = new Random();
                TimeUnit.SECONDS.sleep(Math.abs(random.nextInt() % 5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWritelock.readLock().unlock();
        }
    }


}

