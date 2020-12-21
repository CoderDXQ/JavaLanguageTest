package com.example.brushalgorithmproblem.swordtooffer;

import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/17 12:42 上午
 */
public class JZ15 {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        JZ15 solution = new JZ15();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);

        solution.shuchu(listNode);

        solution.ReverseList(listNode);

        solution.shuchu(listNode);

    }

    //    原地算法
    public ListNode ReverseList(ListNode head) {
        ListNode next = null;
        ListNode pre = null;
        if (head == null || head.next == null)
            return head;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        //   shuchu(pre);

        return pre;
    }

    private void shuchu(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }
}

