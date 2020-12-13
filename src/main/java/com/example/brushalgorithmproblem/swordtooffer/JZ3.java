package com.example.brushalgorithmproblem.swordtooffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/13 11:50 下午
 */
public class JZ3 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        JZ3 solution = new JZ3();
        ListNode listNode = new ListNode(67);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(24);
        listNode.next.next.next = new ListNode(58);

        System.out.println(solution.printListFromTailToHead(listNode));
        System.out.println(solution.printListFromTailToHead1(listNode));
        System.out.println(solution.printListFromTailToHead2(listNode));

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//使用栈
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> stack = new Stack<Integer>();

        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.empty()) {
            arr.add(stack.pop());
        }
        return arr;

    }

    ArrayList<Integer> arr = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
//递归
//        这个必须提到方法外面，不然每次都返回此时新建的ArrayList的头一个元素
        // ArrayList<Integer> arr = new ArrayList<>();

        if (listNode != null) {
            printListFromTailToHead1(listNode.next);
            arr.add(listNode.val);
        }
        return arr;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
//add()方法的使用
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = listNode;
        while (tmp != null) {
            list.add(0, tmp.val);
            tmp = tmp.next;
        }
        return list;
    }
}

