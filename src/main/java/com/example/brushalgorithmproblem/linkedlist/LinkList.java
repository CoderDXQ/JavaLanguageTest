package com.example.brushalgorithmproblem.linkedlist;

import java.util.Objects;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/3 12:01 下午
 */
public class LinkList<T> {

    /**
     * 自定义节点数据类型
     */
    private class Node {
        private T value;
        private Node next;

        public Node() {
        }

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return Objects.equals(value, node.value) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }
    }

    private Node head = null;
    private int length = 0;

    public LinkList() {
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    /**
     * 根据位置查找节点
     *
     * @param position
     * @return
     */
    protected Node getNode(int position) {
        if (head == null || position < 0 || position >= length) {
            throw new IndexOutOfBoundsException();
        } else {
//            认为头结点的下标是0
            Node curNode = head;
            int tmp = 0;
            while (tmp < position) {
                curNode = curNode.next;
                tmp++;
            }
            return curNode;
        }
    }

    /**
     * 获取节点的数据  使用泛型实现
     *
     * @param position
     * @return
     */
    public T get(int position) {
        return getNode(position).value;
    }

    /**
     * 复用insert方法实现后插
     *
     * @param data
     */
    public void pushBack(T data) {
        insert(this.length, data);
    }

    /**
     * 按照下标插入元素
     *
     * @param position
     * @param value
     */
    public void insert(int position, T value) {
        Node newNode = new Node(value);
        if (position == 0) {
            Node oldFirst = head;
            head = newNode;
            head.next = oldFirst;
        } else {
            Node node = getNode(position - 1);
            Node nextNode = node.next;
            node.next = newNode;
            newNode.next = nextNode;
        }
        this.length++;
    }

    /**
     * 按照下标移除元素
     *
     * @param position
     * @return
     */
    public T remove(int position) {
        T data = null;
        if (position == 0) {
            data = head.value;
            head = head.next;
        } else if (position < length && position > 0) {
            Node node = getNode(position - 1);
            Node delNode = node.next;
            node.next = delNode.next;
            data = delNode.value;
        } else {
            throw new IndexOutOfBoundsException();
        }
        length--;
        return data;
    }

    /**
     * 查找元素并返回下标  未找到返回-1
     *
     * @param data
     * @return
     */
    public int indexOf(T data) {
        Node curNode = head;
        int position = 0;
        while (curNode != null) {
            if (curNode.value.equals(data)) {
                return position;
            }
            curNode = curNode.next;
            position++;
        }
        return -1;
    }

    /**
     * 输出链表内容
     *
     * @param linkList
     */
    public static void printLinkList(LinkList<String> linkList) {
        System.out.println("链表元素如下：");
        for (int i = 0; i < linkList.length; i++) {
            System.out.print(linkList.getNode(i).value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkList<String> linkList = new LinkList<String>();
        linkList.pushBack("0");
        linkList.pushBack("1");
        linkList.insert(2, "2");

        printLinkList(linkList);
        System.out.println();


        linkList.insert(2, "3");
        printLinkList(linkList);
        System.out.println();

        System.out.println(linkList.length);

        System.out.println(linkList.getNode(2));

        System.out.println(linkList.get(2));

        System.out.println(linkList.indexOf("2"));

        System.out.println();
        linkList.remove(0);
        printLinkList(linkList);
        System.out.println();

        linkList.remove(2);
        linkList.remove(1);
        printLinkList(linkList);
        System.out.println();

        linkList.remove(0);
        printLinkList(linkList);
        System.out.println();

        //        抛出Index越界异常
//        linkList.remove(0);

//        抛出Index越界异常
//        linkList.remove(5);
    }

}
