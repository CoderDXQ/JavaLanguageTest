package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/16 12:11 上午
 */
//快慢指针法
public class JZ14 {
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
        JZ14 solution = new JZ14();
        int k = 1;//5,0,1,4
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        solution.FindKthToTail(listNode, k);
        solution.FindKthToTail1(listNode, k);
    }

    public ListNode FindKthToTail1(ListNode head, int k) {
        if (head == null || k == 0) return null;
        ListNode h1 = head;
        ListNode h2 = head;

        for (int i = 0; i < k; i++) {
            h1 = h1.next;
            if (i < k - 1 && h1 == null) return null;
            if (i == k - 1 && h1 == null) return h2;

        }
        while (h1 != null) {
            h1 = h1.next;
            h2 = h2.next;
        }
        System.out.println(h2);
        return h2;
    }


    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;

        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println(slow);
        return slow;
    }
}
