package com.example.brushalgorithmproblem.swordtooffer;

import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/17 12:42 上午
 */
public class JZ15 {

    public static class ListNode {
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
        solution.ReverseList(listNode);

    }

    public ListNode ReverseList(ListNode head) {



        return head;
    }
}
