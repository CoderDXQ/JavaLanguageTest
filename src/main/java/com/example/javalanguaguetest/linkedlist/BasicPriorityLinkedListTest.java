package com.example.javalanguaguetest.linkedlist;

import com.sun.xml.internal.bind.v2.TODO;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import sun.security.x509.InvalidityDateExtension;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/29 1:46 上午
 */


//测试自己写的BasicPriorityLinkedList类以及其中的迭代器类
public class BasicPriorityLinkedListTest {
    public static void main(String[] args) {

        BasicPriorityLinkedList basicPriorityLinkedList = new BasicPriorityLinkedList(5);

        System.out.println("测试优先级列表的基本功能：");
        basicPriorityLinkedList.addFirst("0", 0);
        basicPriorityLinkedList.addFirst("1", 1);
        basicPriorityLinkedList.addFirst("2", 2);
        basicPriorityLinkedList.addFirst("3", 3);
        basicPriorityLinkedList.addFirst("4", 4);

        basicPriorityLinkedList.addFirst("1", 1);
        basicPriorityLinkedList.addFirst("2", 2);
        basicPriorityLinkedList.addFirst("3", 3);
        basicPriorityLinkedList.addFirst("4", 4);

        basicPriorityLinkedList.addLast("last", 0);
        basicPriorityLinkedList.addLast("last", 1);
        basicPriorityLinkedList.addLast("last", 2);
        basicPriorityLinkedList.addLast("last", 3);
        basicPriorityLinkedList.addLast("last", 4);
        System.out.println(basicPriorityLinkedList);

//        从优先级高的开始删除
        basicPriorityLinkedList.removeFirst();
        basicPriorityLinkedList.removeFirst();
        basicPriorityLinkedList.removeFirst();
        basicPriorityLinkedList.removeFirst();
        System.out.println(basicPriorityLinkedList);

//        从优先级低的开始删除
        basicPriorityLinkedList.removeLast();
        basicPriorityLinkedList.removeLast();
        basicPriorityLinkedList.removeLast();
        System.out.println(basicPriorityLinkedList);

        System.out.println();
        System.out.println("peekFirst():" + basicPriorityLinkedList.peekFirst());
        System.out.println("peekFirst():" + basicPriorityLinkedList.peekFirst());
        System.out.println("peekFirst():" + basicPriorityLinkedList.peekFirst());

        System.out.println();
        System.out.println("getAll():" + basicPriorityLinkedList.getAll());
        System.out.println("size():" + basicPriorityLinkedList.size());
        System.out.println("isEmpty():" + basicPriorityLinkedList.isEmpty());
        System.out.println();


        System.out.println("执行clear()方法后：");
        basicPriorityLinkedList.clear();
        System.out.println("getAll():" + basicPriorityLinkedList.getAll());
        System.out.println("size():" + basicPriorityLinkedList.size());
        System.out.println("isEmpty():" + basicPriorityLinkedList.isEmpty());

        System.out.println();

//测试优先级列表的迭代器
        System.out.println("测试优先级链表迭代器：");

//        内部类的实例化
        BasicPriorityLinkedList.PriorityLinkedListIterator iterator = (BasicPriorityLinkedList.PriorityLinkedListIterator) basicPriorityLinkedList.iterator();
        Iterator it = basicPriorityLinkedList.iterator();
        System.out.println("迭代器：" + iterator.toString());

        System.out.println("hasNext():" + iterator.hasNext());
        System.out.println("添加元素！");
        basicPriorityLinkedList.addFirst("0", 0);
        basicPriorityLinkedList.addFirst("1", 1);
        basicPriorityLinkedList.addFirst("2", 2);
        basicPriorityLinkedList.addFirst("3", 3);
        basicPriorityLinkedList.addFirst("4", 4);
        basicPriorityLinkedList.addFirst("0", 0);
        basicPriorityLinkedList.addFirst("1", 1);
        basicPriorityLinkedList.addFirst("2", 2);
        basicPriorityLinkedList.addFirst("3", 3);
        basicPriorityLinkedList.addFirst("4", 4);
        System.out.println("hasNext():" + iterator.hasNext());
        System.out.println();

        System.out.println(basicPriorityLinkedList);
        System.out.println();

        System.out.println("显示指针的成员值：");
        System.out.println(iterator);
        System.out.println();

//        LinkedList l=(LinkedList) it.next();
//        System.out.println(l);
//        String s = (String) iterator.next();
//        System.out.println(s);
        System.out.println("hasPrevious():" + iterator.hasPrevious());
        //   System.out.println("previous():"+iterator.previous());
        System.out.println("nextIndex():" + iterator.nextIndex());
        System.out.println("previousIndex():" + iterator.previousIndex());
        System.out.println();

//        下面的方法会议hasNext()方法冲突报ConcurrentModificationException异常（并发修改冲突）
        //TODO:next() previous() remove() set() add()


    }
}
