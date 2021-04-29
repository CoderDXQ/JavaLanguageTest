package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/15 4:45 下午
 */
//合并K个升序链表
public class lt23 {

    //    顺序合并
    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoKLists(ans, lists[i]);
        }

        return ans;
    }

    private static ListNode mergeTwoKLists(ListNode a, ListNode b) {

        if (a == null || b == null) {
            return a != null ? a : b;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {

            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;

        }

        tail.next = (aPtr != null) ? aPtr : bPtr;

        return head.next;
    }

    //    分治合并
    public static ListNode mergeKLists1(ListNode[] lists) {

        return merge(lists, 0, lists.length - 1);

    }

    private static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }


        if (l > r) {
            return null;
        }

        int mid = (l + r) >> 1;
        return mergeTwoKLists(merge(lists, l, mid), merge(lists, mid + 1, r));

    }

    //    优先队列
    public static ListNode mergeKLists2(ListNode[] lists) {

//        使用lambda表达式自定义优先队列比较器
        PriorityQueue<ListNode> queue = new PriorityQueue<>((v1, v2) ->
                v1.val - v2.val
        );

//        将所有链表的头结点放到优先队列中
        for (ListNode node : lists) {
            queue.add(node);
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        while (!queue.isEmpty()) {

            ListNode minNode = queue.poll();
            tail.next = minNode;
            if (minNode.next != null) {
                queue.offer(minNode.next);
            }
            tail = tail.next;
        }

        return dummyHead.next;
    }

    //    整体合并
    public static ListNode mergeKLists3(ListNode[] lists) {

        int len = lists.length;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        while (true) {

            ListNode min = null;
            int num = -1;
//            找到所有链表的最小的元素
            for (int i = 0; i < len; i++) {
//                略过空表
                if (lists[i] == null) {
                    continue;
                }
                if (min == null || min.val > lists[i].val) {
                    min = lists[i];
                    num = i;
                }
            }

//            表示没有找到最小的元素即没有元素了
            if (num == -1) {
                break;
            }

            tail.next = min;
            tail = tail.next;
            lists[num] = lists[num].next;

        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        ListNode l1 = ListUtils.create(new int[]{1, 4, 5});
        ListNode l2 = ListUtils.create(new int[]{1, 3, 4});
        ListNode l3 = ListUtils.create(new int[]{2, 6});

        ListNode[] lists = new ListNode[]{l1, l2, l3};

//        ListNode node = mergeKLists(lists);
//
//        while (node != null) {
//            System.out.print(node.val + " ");
//            node = node.next;
//        }
//        System.out.println();


//        ListNode node = mergeKLists1(lists);
//
//        while (node != null) {
//            System.out.print(node.val + " ");
//            node = node.next;
//        }
//        System.out.println();


//        ListNode node = mergeKLists2(lists);
//
//        while (node != null) {
//            System.out.print(node.val + " ");
//            node = node.next;
//        }
//        System.out.println();


        ListNode node = mergeKLists3(lists);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();


    }

}
