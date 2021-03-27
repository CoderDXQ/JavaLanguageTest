package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 11:08 下午
 */
public class lt146 {

    //   使用双端队列来实现 同时也是双向链表
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //    cache只是标记缓存里面有没有  淘汰的先后顺序使用双端队列实现
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public lt146(int capacity) {
        this.size = 0;
        this.capacity = capacity;

//        双向链表的构造
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
//        最近使用的放在头部 到时候淘汰的时候从尾部淘汰即可
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
//            添加进缓存
            cache.put(key, newNode);
//            添加至双端链表的头部
            addToHead(newNode);
            size++;

            if (cache.size() > capacity) {
//                从双端链表尾删除 并从cache中删除
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }

        } else {
            node.value = value;
//            最近使用过的放在双端队列的最前面
            moveToHead(node);
        }
    }

//    分解的几个操作

    private void addToHead(DLinkedNode node) {
//        首尾节点不存储数据
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    //    删除最后一个结点
    private DLinkedNode removeTail() {
//        首尾节点不存储数据
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        lt146 lRUCache = new lt146(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));// 返回 3
        System.out.println(lRUCache.get(4));// 返回 4

    }

}
