package com.example.brushalgorithmproblem.linkedlist;

/**
 * 双向循环链表  是首尾相接的双向链表，不是简单的双向链表
 *
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/3 12:54 下午
 */
public class DoublyCircularLinkList<T> {
    protected class Node {
        T data;
        Node pre;
        Node next;

        public Node(T data) {
            this.data = data;
            this.pre = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return this.data.toString();
        }
    }

    protected Node head = null;
    protected int length = 0;

    protected Node getNode(int position) {
        if (head == null || position < 0 || position >= length) {
            throw new IndexOutOfBoundsException();
        } else {
//            利用双向链表的特点，即可以向两个方向遍历
            int half = this.length >> 1;
            Node curNode;
            int tmp;
            if (position <= half) {
                curNode = head;
                tmp = 0;
                while (tmp < position) {
                    tmp++;
                    curNode = curNode.next;
                }
            } else {
//                循环链表首尾相接
                curNode = head.pre;
                tmp = this.length - 1;
                while (tmp > position) {
                    tmp--;
                    curNode = curNode.pre;
                }
            }
            return curNode;
        }
    }

    protected void insert(int position, T data) {
        Node newNode = new Node(data);

        if (position == 0) {
            Node oldFirst = head;
            head = newNode;
            head.next = oldFirst;
            if (oldFirst != null) {
                head.pre = oldFirst.pre;
                oldFirst.pre.next = head;
                oldFirst.pre = head;
            } else {
//                单元素双向链表的形式 链表原来为空
                newNode.pre = newNode;
                newNode.next = newNode;
            }
        } else {
//            循环链表
            Node node = getNode(position - 1);
            newNode.pre = node;
            newNode.next = node.next;
            node.next.pre = newNode;
            node.next = newNode;
        }
        this.length++;
    }

    public T remove(int position) {
        T data = null;
        if (position == 0) {
            data = head.data;
            if (this.length == 1) {
                //如果只有一个元素，直接将头结点置空即可
                this.head = null;
            } else {
                Node oldFirst = head;
                head = head.next;
                head.pre = oldFirst.pre;
                oldFirst.pre.next = head;
            }

        } else {
            Node node = getNode(position - 1);
            Node removeNode = node.next;
            data = removeNode.data;
            node.next = removeNode.next;
            removeNode.next.pre = node;

        }
        this.length--;
        return data;
    }

    public T get(int position) {
        return getNode(position).data;
    }

    @Override
    public String toString() {
        Node curNode = head;
        String outString = "";

//        循环链表首尾相连
        if (curNode != null) {
            do {
                outString += curNode.toString() + ",";
                curNode = curNode.next;
            } while (curNode != head);
        }
        return outString;
    }

    public static void main(String[] args) {
        DoublyCircularLinkList<String> list = new DoublyCircularLinkList<>();

        list.insert(0, "1");
        list.insert(1, "2");
        list.insert(2, "3");
        list.insert(0, "0");
        System.out.println(list.toString());
        System.out.println();

        list.remove(0);
        System.out.println(list.toString());
        System.out.println();

        list.remove(1);
        System.out.println(list.toString());
        System.out.println();

        list.remove(1);
        list.remove(0);

        System.out.println("最后结果：");
        System.out.println(list.toString());
        System.out.println();
    }
}
