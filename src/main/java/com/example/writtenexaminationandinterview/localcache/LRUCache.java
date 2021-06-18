package com.example.writtenexaminationandinterview.localcache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/18 10:30 下午
 */
//LRU的淘汰策略是淘汰最近未被使用的元素  因此只需要将每次使用的结点移动到链表尾，淘汰的时候删除头结点即可
public class LRUCache<K, V> {

    private class Node {
        Node prev;
        Node next;
        Object key;
        Object value;

        public Node(Object key, Object value) {
            this.prev = null;
            this.next = null;
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    private ConcurrentHashMap<Object, Node> concurrentHashMap;

    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    //    在构造函数中进行初始化
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.concurrentHashMap = new ConcurrentHashMap<>(capacity);
        tail.prev = head;
        head.next = tail;
    }


    public Object get(K key) {
        checkNotNull(key);
        if (concurrentHashMap.isEmpty()) {
            return null;
        }
        if (!concurrentHashMap.containsKey(key)) {
            return null;
        }
//        更新就是将结点移动到末尾
        Node current = concurrentHashMap.get(key);
//        将当前节点从链表移出
        current.prev.next = current.next;
        current.next.prev = current.prev;
//        移动到链表末尾  淘汰的时候是删除头结点
        move_to_tail(current);
        return current.value;
    }


    public void put(K key, V value) {
        checkNotNull(key);
        checkNotNull(value);
//        当缓存存在时 更新缓存
        if (concurrentHashMap.containsKey(key)) {
            Node current = concurrentHashMap.get(key);
//        将当前节点从链表移出
            current.prev.next = current.next;
            current.next.prev = current.prev;
//        移动到链表末尾  淘汰的时候是删除头结点
            move_to_tail(current);
            return;
        }
//        当缓存满时 执行淘汰策略
        if (isFull()) {
            concurrentHashMap.remove(head.next.key);
            head.next.next.prev = head;
            head.next = head.next.next;
        }
//        正常的插入之前不存在的结点(数据)
        Node node = new Node(key, value);
        concurrentHashMap.put(key, node);
        move_to_tail(node);
    }

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    private boolean isFull() {
        return concurrentHashMap.size() == capacity;
    }

    //    将当前节点移动到尾部
    private void move_to_tail(Node current) {
        tail.prev.next = current;
        current.prev = tail.prev;
        tail.prev = current;
        current.next = tail;
    }
}
