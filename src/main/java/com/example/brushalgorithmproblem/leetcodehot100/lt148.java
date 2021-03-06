package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/30 9:34 上午
 */
//排序链表
public class lt148 {

    //    归并
    public static ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public static ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
//            截断操作
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
//        快慢指针中间分
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
//        分到最小
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
//        引导结点
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        }
        if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    //    优先队列
    public static ListNode sortList1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        ListNode node = head;
        while (node != null) {
            queue.add(node.val);
            node = node.next;
        }

//        引导结点
        ListNode result = new ListNode(0);
        node = result;

        while (!queue.isEmpty()) {
            ListNode temp = new ListNode(queue.poll());
            node.next = temp;
            node = node.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        int[] heads = new int[]{4, 2, 1, 3};
        ListUtils.print(sortList(ListUtils.create(heads)));
        ListUtils.print(sortList1(ListUtils.create(heads)));
    }

}
