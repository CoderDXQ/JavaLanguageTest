package com.example.javalanguaguetest.linkedlist;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/29 7:44 下午
 */
public class PerformanceTestForArrayListAndLinkedList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        int size = 10000 * 1000;
        int index = 5000 * 1000;


//        ArrayList比LinkedList快 因为LinkedList要初始化节点然后对前后指针赋值
        System.out.println("ArrayList add " + size);
//        静态方法可以被直接调用，不需要实例化
        addData(arrayList, size);
        System.out.println("LinkedList add" + size);
        addData(linkedList, size);
        System.out.println();

//        数组可以根据下标直接拿到数据 链表需要遍历过去
        System.out.println("ArrayList get" + index + " th");
        getIndex(arrayList, index);
        System.out.println("LinkedList get" + index + " th");
        getIndex(linkedList, index);
        System.out.println();

        //数组可以根据下标直接set数据 链表需要遍历过去
        System.out.println("ArrayList set" + index + " th");
        setIndex(arrayList, index);
        System.out.println("LinkedList set" + index + " th");
        setIndex(linkedList, index);
        System.out.println();

        //数组可以根据下标直接add数据 链表需要遍历过去
        System.out.println("ArrayList add" + index + " th");
        addIndex(arrayList, index);
        System.out.println("LinkedList add" + index + " th");
        addIndex(linkedList, index);
        System.out.println();

        //数组可以根据下标直接remove数据 链表需要遍历过去
        System.out.println("ArrayList remove" + index + " th");
        removeIndex(arrayList, index);
        System.out.println("LinkedList remove" + index + " th");
        removeIndex(linkedList, index);
        System.out.println();

        //数组可以根据下标直接remove数据 链表需要遍历过去
        System.out.println("ArrayList remove Object" + index);
        removeObject(arrayList, (Object) index);
        System.out.println("LinkedList remove Object" + index);
        removeObject(linkedList, (Object) index);
        System.out.println();

//LinkedList里面也有个size变量，在这个add()方法中，LinkedList（有头尾双指针）总是尾插或者头插，所以与ArrayList速度差别不大
        System.out.println("ArrayList add");
        add(arrayList);
        System.out.println("LinkedList add");
        add(linkedList);
        System.out.println();

//        对于LinkedList来说，这个foreach()方法包装了迭代器，速度快一点，但还是比ArrayList慢
        System.out.println("ArrayList foreach");
        foreach(arrayList);
        System.out.println("LinkedList foreach");
        foreach(linkedList);
        System.out.println();

//        这个方法是遍历获取链表中的每一个数，LinkedList每次都要遍历过去，所以非常慢，而ArrayList可以根据下标直接取数
        System.out.println("ArrayList forSize");
        forSize(arrayList);
        System.out.println("LinkedList forSize");
//        下面这个方法很慢，LinkedList每次都要遍历过去取数
//        forSize(linkedList);
        System.out.println();

//        说明使用下标遍历就是比使用迭代器快
        System.out.println("ArrayList iterator");
        ite(arrayList);
        System.out.println("LinkedList iterator");
        ite(linkedList);
        System.out.println();

    }

    //    可以同时接收ArrayList和LinkedList
    private static void addData(List<Integer> list, int size) {
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void getIndex(List<Integer> list, int index) {
        long s1 = System.currentTimeMillis();
        list.get(index);
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void setIndex(List<Integer> list, int index) {
        long s1 = System.currentTimeMillis();
        list.set(index, 1024);
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void addIndex(List<Integer> list, int index) {
        long s1 = System.currentTimeMillis();
        list.add(index, 1024);
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void removeIndex(List<Integer> list, int index) {
        long s1 = System.currentTimeMillis();
        list.remove(index);
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void removeObject(List<Integer> list, Object obj) {
        long s1 = System.currentTimeMillis();
        list.remove(obj);
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void add(List<Integer> list) {
        long s1 = System.currentTimeMillis();
        list.add(1024);
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void foreach(List<Integer> list) {
        long s1 = System.currentTimeMillis();
//        对于LinkedList来说，这个方法包装了迭代器，速度快一点，但还是比ArrayList慢
        for (Integer i : list) {
            //do nothing
        }
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void forSize(List<Integer> list) {
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void ite(List<Integer> list) {
        long s1 = System.currentTimeMillis();
        Iterator<Integer> ite = list.iterator();
        while (ite.hasNext()) {
//            向后移动
            ite.next();
        }
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }
}
