package com.example.javalanguaguetest.collections.linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/17 10:30 上午
 */
public class LinkedListTest {
    public static void main(String[] args) {

        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        //迭代器的两种定义方法
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            //顺序归并 next()方法返回将要访问的下一个对象
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }
        System.out.println(a);

        //重置b的迭代器
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                //删除上次访问的对象
                bIter.remove();
            }
        }
        System.out.println(b);

        //从集合a中移除集合b的所有元素
        a.removeAll(b);

        System.out.println(a);
    }
}
