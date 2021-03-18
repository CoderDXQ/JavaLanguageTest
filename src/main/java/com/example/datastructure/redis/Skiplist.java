package com.example.datastructure.redis;

import java.util.Random;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/26 10:28 下午
 */
//参考：https://www.cnblogs.com/buptleida/p/12838880.html
//Redis中跳表的java实现
//跳表的结构结点 存储跳表的首尾结点、结点数量、层数
public class Skiplist<T extends Comparable<? super T>> implements RedisObj {
    //    首尾结点的指针
    private SkipListNode<T> header;
    private SkipListNode<T> tail;

    //    记录跳表的结点数量
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

    /**
     * 产生一个0-31之间的随机数
     *
     * @return
     */
    private static int getRandomHeight() {
        Random random = new Random();
        int i = 0;
        for (; i < 32; i++) {
            if (random.nextInt(2) == 0) {
                break;
            }
        }
        return i;
    }

    /**
     * @param score 分值
     * @param obj   成员对象
     * @return
     */
    public SkipListNode zslInsert(Double score, T obj) {
        int levelHeight = getRandomHeight();
        SkipListNode<T> target = new SkipListNode<>(obj, levelHeight, score);


        return target;
    }


    public static void main(String[] args) {


    }
}
