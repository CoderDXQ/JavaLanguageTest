package com.example.javalanguaguetest.collections.treeSet;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/17 11:51 上午
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 46562));
        parts.add(new Item("Modem", 9912));
        //本次打印按partNumber排序
        System.out.println(parts);

        //构造一个定义排序比较器的树集 使用Comparator接口的comparing()方法 按照description排序
        NavigableSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));

        //往树集扔数
        sortByDescription.addAll(parts);

        System.out.println(sortByDescription);
    }
}
