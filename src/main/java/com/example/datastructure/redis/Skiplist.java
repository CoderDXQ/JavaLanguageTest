package com.example.datastructure.redis;

import org.springframework.boot.autoconfigure.cache.CacheProperties;
import sun.tools.attach.HotSpotVirtualMachine;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/26 10:28 下午
 */
//Redis中跳表的java实现
public class Skiplist<T extends Comparable<? super T>> implements RedisObj {
    //    首尾结点的指针
    private SkipListNode<T> header;
    private SkipListNode<T> tail;

    //    记录跳表的数量节点
    private long length;

    //    最大结点的层数
    private int maxLevelHeight;

    public Skiplist() {
        SkipListNode<T> node = new SkipListNode<>(null);
        this.header = node;
        this.tail = node;
        this.length = 0;
        this.maxLevelHeight = 0;
    }


    public static void main(String[] args) {

    }
}
