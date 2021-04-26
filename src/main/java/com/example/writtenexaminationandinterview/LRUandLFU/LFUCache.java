package com.example.writtenexaminationandinterview.LRUandLFU;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/26 10:59 下午
 */
public class LFUCache {
    //    实现自定义比较接口  用于TreeSet
    class Node implements Comparable<LFUCache.Node> {
        //        cnt是频率 time是时间戳
        int cnt, time, key, value;

        public Node(int cnt, int time, int key, int value) {
            this.cnt = cnt;
            this.time = time;
            this.key = key;
            this.value = value;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

//            频次和时间戳相等即认为相等
            if (o instanceof LFUCache.Node) {
                LFUCache.Node rhs = (LFUCache.Node) o;
                return this.cnt == rhs.cnt && this.time == rhs.time;
            }

            return false;
        }

        @Override
        public int hashCode() {
            return cnt * 1000000007 + time;
        }


        //        用于在二叉平衡树中进行比较
        @Override
        public int compareTo(LFUCache.Node o) {
//            频次相等的情况下比较更新时间
            return cnt == o.cnt ? time - o.time : cnt - o.cnt;
        }
    }

    int capacity, time;
    //    窗口表 大小是capacity
    Map<Integer, LFUCache.Node> key_table;
    //        二叉平衡树 存放所有LFU结点的信息 用于返回当缓存表满时需要从中删除的结点
    TreeSet<LFUCache.Node> S;

    //    构造方法
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.time = 0;
        key_table = new HashMap<Integer, LFUCache.Node>();
        S = new TreeSet<LFUCache.Node>();
    }

    //    查询之后要更新频率和时间戳
    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }

        if (!key_table.containsKey(key)) {
            return -1;
        }

//        拿到旧的缓存结点
        LFUCache.Node cache = key_table.get(key);

//        从二叉平衡树中删除旧的结点
        S.remove(cache);

//        更新旧节点的信息
        cache.cnt += 1;
        cache.time = ++time;

//        将更新后的就缓存结点放回缓存和平衡二叉树
        S.add(cache);
        key_table.put(key, cache);
        return cache.value;

    }

    //    更新操作
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

//        缓存表中没有
        if (!key_table.containsKey(key)) {
//            清出一个位置来  把缓存表中最小频率的那个删除掉
            if (key_table.size() == capacity) {
//                S(二叉平衡树中是按cnt的值从小到大排的)
                key_table.remove(S.first().key);
                S.remove(S.first());
            }
            LFUCache.Node cache = new LFUCache.Node(1, ++time, key, value);
//            放入缓存和平衡二叉树
            key_table.put(key, cache);
            S.add(cache);
        } else {
//            缓存中原来就有
            LFUCache.Node cache = key_table.get(key);
            S.remove(cache);
            cache.cnt += 1;
            cache.time = ++time;
            cache.value = value;
            S.add(cache);
            key_table.put(key, cache);
        }

    }

    public static void main(String[] args) {
        // cnt(x) = 键 x 的使用计数
// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
        LFUCache lFUCache = new LFUCache(2);
        lFUCache.put(1, 1);   // cache=[1,_], cnt(1)=1
        lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lFUCache.get(1));// 返回 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lFUCache.get(2));// 返回 -1（未找到）
        System.out.println(lFUCache.get(3));// 返回 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lFUCache.get(1));// 返回 -1（未找到）
        System.out.println(lFUCache.get(3));// 返回 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lFUCache.get(4));// 返回 4
        // cache=[3,4], cnt(4)=2, cnt(3)=3

    }
}
