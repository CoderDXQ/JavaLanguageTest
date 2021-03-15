package com.example.brushalgorithmproblem.leetcodehot100;

import java.security.cert.Certificate;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/15 7:37 下午
 */
public class lt21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

//        在逻辑上是多余的
//        if (l1 == null && l2 == null) {
//            return null;
//        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode();
        ListNode cur = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }

//        l1和l2只可能有一个没有合并上 因此只需要接上没有合并上的那一个链表即可
        cur.next = l1 == null ? l2 : l1;
        return head.next;

    }

    //    递归
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

        int[] l1 = new int[]{1, 2, 4};
        int[] l2 = new int[]{1, 3, 4};

        ListNode ll1 = ListUtils.create(l1);
        ListNode ll2 = ListUtils.create(l2);

        ListUtils.print(mergeTwoLists(ll1, ll2));

        ListUtils.print(mergeTwoLists1(ll1, ll2));

    }
}
