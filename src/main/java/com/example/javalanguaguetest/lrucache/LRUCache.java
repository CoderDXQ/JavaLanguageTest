package com.example.javalanguaguetest.lrucache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/2 12:35 上午
 */

//https://leetcode-cn.com/problems/lru-cache/
//LRU缓存机制
public class LRUCache {

    //    使用内部类定义双端队列节点 LRU实际上就是在维护一个双端队列链表
    class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;

        public DoubleLinkedNode() {
        }

        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "DoubleLinkedNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


    //    容量
    private int capacity;
    private int size;
    //   对应于LRUCache维持一个key（键）和node（键值）的映射 cache的元素种类与LRUCache相同
//    cache中的key与LRUCache中的元素的key是一样的
    private Map<Integer, DoubleLinkedNode> cache = new HashMap<>();
    //    首、尾双指针
    private DoubleLinkedNode head, tail;

    //    利用构造函数初始化LRUCache
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
//首尾相连形成一个最基础的链表 这个链表以后会逐渐变长 并且在这个链表中 越靠前代表最近越晚被使用  越靠后代表最近越早被使用
        head.next = tail;
        tail.prev = head;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<Integer, DoubleLinkedNode> getCache() {
        return cache;
    }

    public DoubleLinkedNode getHead() {
        return head;
    }

    public DoubleLinkedNode getTail() {
        return tail;
    }

    //    输出LRUCache的所有元素
    public void printLRUCache() {
        DoubleLinkedNode node = head.next;
        while (node != tail) {
            System.out.println(node);
            node = node.next;
        }
    }

    //    基本操作：新节点直接加载LRUCache的最前面
    private void addToHead(DoubleLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    //    基本操作：删除节点
    private void removeNode(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //    基本操作：将某个节点移到最前面
    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    //    基本操作：删除尾结点
    private DoubleLinkedNode removeTail() {
        DoubleLinkedNode node = tail.prev;
        if (node != head) {
            removeNode(node);
            return node;
        } else {
            return null;
        }
    }


    //    获取关键字的值 认为这是被使用了 而且是最近被使用
    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
//        因为node节点最近被使用过了，所以要移动到LRUCache链表的最前面
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);

        if (node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            cache.put(key, newNode);
//            移动到LRUCache表头，代表最近最晚被使用过
            addToHead(newNode);
            size++;
//            处理超出LRUCache容量的情况 即把最近最晚被使用的元素从LRUCache删除 同时在映射cache中
            if (size > capacity) {
//                删除尾元素
                DoubleLinkedNode tail = removeTail();
//                删除cache中的元素，该元素对应于cache中的尾元素
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
//            node节点最近被使用过，所以需要更新LRUCache链表
            moveToHead(node);
        }
    }


}
