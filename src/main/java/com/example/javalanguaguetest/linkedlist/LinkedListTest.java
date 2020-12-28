package com.example.javalanguaguetest.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/28 10:29 上午
 */

/*
LinkedList是基于链表实现的，ArrayList是基于数组实现的，所以LinkedList插入性能好，查询性能差；ArrayList插入性能差，查询性能好

* */

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");

        System.out.println("链表的第一个元素是：" + linkedList.getFirst());

        System.out.println("链表的最后一个元素是:" + linkedList.getLast());

//        这个方法封装了迭代器，所以比较快  在所有的遍历方法中  迭代器是最快的
        for (String str : linkedList) {
            System.out.print(str + " ");
        }
        System.out.println();
//      添加元素
        linkedList.addFirst("X");
        linkedList.addLast("Z");
        for (String str : linkedList) {
            System.out.print(str + " ");
        }
        System.out.println();

//        移除元素
        linkedList.removeFirst();
        linkedList.removeLast();
        for (String str : linkedList) {
            System.out.print(str + " ");
        }
        System.out.println();
        System.out.println();


//        从链表生成子表 下标从0开始
        List list = linkedList.subList(1, 3);
        System.out.println("1:" + linkedList);
        System.out.println(list);

//        在子表中删除的同时也会在原来的母表中删除，说明在生成子表的时候并没有拷贝，而是使用了引用
        list.remove(1);
        System.out.println(list);
        System.out.println("2:" + linkedList);

//        强制类型转换成ArrayList
        System.out.println("2:" + linkedList);
        ArrayList<String> arrayList = new ArrayList<String>(linkedList);
        System.out.println("3:" + linkedList);
        System.out.println(arrayList);
        for (String s : arrayList) {
            System.out.print("s = " + s + "   ");
        }
        System.out.println();
        System.out.println();

//        各种删除元素
        LinkedList<String> lList = new LinkedList<String>();
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");
        System.out.println(lList);

        Object object = lList.removeFirst();
        System.out.println(object + "has been removed");
        System.out.println(lList);
        object = lList.removeLast();
        System.out.println(object + "has been removed");
        System.out.println(lList);

        lList.addLast("5");
        lList.addFirst("1");
        System.out.println(lList);
        lList.subList(2, 5).clear();
        System.out.println(lList);
        lList.remove("2");
        System.out.println(lList);
        System.out.println();

//        将LinkedList转换为数组，数组长度为0
        LinkedList<String> theList = new LinkedList<String>();
        theList.add("A");
        theList.add("B");
        theList.add("C");
        theList.add("D");
        String[] my = theList.toArray(new String[0]);
        for (String ss : my) {
            System.out.println(ss);
        }
        System.out.println();

        String[] mm = theList.toArray(new String[theList.size()]);
        for (String ss : mm) {
            System.out.println(ss);
        }
        System.out.println();

//        查找元素位置
        System.out.println(lList);
        System.out.println(lList.indexOf("5"));
        System.out.println(lList.indexOf("1"));

//        替换元素
        lList.set(0, "Replaced");
        System.out.println(lList);
        System.out.println();

//        确认链表是否包含特定元素
        if (lList.contains("Replaced")) {
            System.out.println("LinkedList contains Replaced");
        } else {
            System.out.println("LinkedList does not contains Replaced");
        }

        if (lList.contains("A")) {
            System.out.println("LinkedList contains A");
        } else {
            System.out.println("LinkedList does not contains A");
        }
        lList.addFirst("A");
        if (lList.contains("A")) {
            System.out.println("LinkedList contains A");
        } else {
            System.out.println("LinkedList does not contains A");
        }


    }
}
