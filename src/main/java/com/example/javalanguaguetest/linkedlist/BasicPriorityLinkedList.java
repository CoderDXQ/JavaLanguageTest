package com.example.javalanguaguetest.linkedlist;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/28 5:19 下午
 */

//实现优先级链表 使用Deque实现优先级链表

public class BasicPriorityLinkedList {

    protected LinkedList[] linkedLists;
    protected int priorities;
    protected int size;

    @Override
    public String toString() {
        System.out.println();
        for (LinkedList l : linkedLists) {
            System.out.println(l);
        }
        return "BasicPriorityLinkedList{" +
                "linkedLists=" + Arrays.toString(linkedLists) +
                ", priorities=" + priorities +
                ", size=" + size +
                '}';
    }

    //    设置初始优先级 构造函数 构造函数不需要返回类型
    public BasicPriorityLinkedList(int priorities) {
        this.priorities = priorities;
        initDeques();
    }

    //在某个优先级的链表的前面添加元素
    public void addFirst(Object obj, int priority) {
        linkedLists[priority].addFirst(obj);

        size++;
    }

    //在某个优先级的链表的后面添加元素
    public void addLast(Object obj, int priority) {
        linkedLists[priority].addLast(obj);
        size++;
    }

    //删除第一个元素  从优先级最高的链表开始删除
    public Object removeFirst() {
        Object obj = null;
        for (int i = priorities - 1; i >= 0; i--) {
            LinkedList ll = linkedLists[i];
            if (!ll.isEmpty()) {
                obj = ll.removeFirst();
                break;
            }
        }
        if (obj != null) {
            size--;
        }
        return obj;
    }

    //删除最后一个元素  从优先级最低的链表开始删除
    public Object removeLast() {
        Object obj = null;
        for (int i = 0; i < priorities; i++) {
            LinkedList ll = linkedLists[i];
            if (!ll.isEmpty()) {
                obj = ll.removeLast();
            }
            if (obj != null) {
                break;
            }
        }
        if (obj != null) {
            size--;
        }
        return obj;
    }

    //    获取第一个元素 从优先级最高的链表开始找
    public Object peekFirst() {
        Object obj = null;
        for (int i = priorities - 1; i >= 0; i--) {
            LinkedList ll = linkedLists[i];
            if (!ll.isEmpty()) {
                obj = ll.getFirst();
            }
            if (obj != null) {
                break;
            }
        }
        return obj;
    }

    //获取所有的元素 按照优先级高低来
    public List getAll() {
        List all = new ArrayList();
        for (int i = priorities - 1; i >= 0; i--) {
            LinkedList deque = linkedLists[i];
            all.addAll(deque);
//            简单写法
//            all.addAll(linkedLists[i]);
        }
        return all;
    }

    //    清理就是初始化
    public void clear() {
        initDeques();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
//        返回true或者false
        return size == 0;
    }

    //    返回一个新的迭代器类
    public ListIterator iterator() {
        return new PriorityLinkedListIterator(linkedLists);
    }


    //链表的元素也是链表  这是一个邻接表 最大的优先级同样代表子链表的个数
    private void initDeques() {
        linkedLists = new LinkedList[priorities];
        for (int i = 0; i < priorities; i++) {
            linkedLists[i] = new LinkedList();
        }
        size = 0;
    }

    //    编写一个迭代器类 这是一个内部类
    class PriorityLinkedListIterator implements ListIterator {
        private LinkedList[] lists;
        private int index;
        private ListIterator currentIter;

        @Override
        public String toString() {
            return "PriorityLinkedListIterator{" +
                    "lists=" + Arrays.toString(lists) +
                    ", index=" + index +
                    ", currentIter=" + currentIter +
                    '}';
        }

        public LinkedList[] getLists() {
            return lists;
        }

        public int getIndex() {
            return index;
        }

        public ListIterator getCurrentIter() {
            return currentIter;
        }

        // 初始化迭代器是优先级最高的子链表的迭代器
        PriorityLinkedListIterator(LinkedList[] lists) {
            this.lists = lists;
            index = lists.length - 1;
            currentIter = lists[index].listIterator();
        }


        /* //LinkedList中的hasNext()方法的实现
        public boolean hasNext() {
            return nextIndex < size;
        }*/
        @Override
        public boolean hasNext() {
//            如果当前传入的迭代器位置（子链表）hasNext()则有元素，直接返回true
            if (currentIter.hasNext()) {
                return true;
            }
//            否则，遍历邻接表(从高优先级向低优先级)，如果接下来的迭代器位置hasNext就返回
            while (index >= 0) {
//                退出while循环的条件
                if (index == 0 || currentIter.hasNext()) {
                    break;
                }
                index--;
                currentIter = lists[index].listIterator();
            }
//            下面这个方法调用的不是这个方法，不会造成递归
            return currentIter.hasNext();
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            System.out.println(currentIter.next());
            return currentIter.next();
        }

        @Override
        public boolean hasPrevious() {
            return currentIter.hasPrevious();
//            throw new UnsupportedOperationException();
        }

        @Override
        public Object previous() {
            return currentIter.previous();
//            throw new UnsupportedOperationException();
        }

        @Override
        public int nextIndex() {
            return currentIter.nextIndex();
//            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            return currentIter.previousIndex();
//            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            currentIter.remove();
            size--;
        }

        @Override
        public void set(Object o) {
            currentIter.set(o);
//            throw new UnsupportedOperationException();
        }

        @Override
        public void add(Object o) {
            currentIter.add(o);
            size++;
//            throw new UnsupportedOperationException();
        }
    }
}
