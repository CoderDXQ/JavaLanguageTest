package com.example.brushalgorithmproblem.swordtooffer;

import com.sun.scenario.effect.Merge;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/21 4:54 下午
 */
public class JZ16 {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        JZ16 solution = new JZ16();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(5);
        list1.next.next.next.next = new ListNode(7);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(8);
        list2.next.next.next.next = new ListNode(9);

        solution.shuchu(list1);
        solution.shuchu(list2);

        //    solution.Merge(list1, list2);

        solution.shuchu(solution.Merge1(list1, list2));

    }

    //非递归版
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode head1 = new ListNode(-1);
        head1 = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
                head = head.next;
            } else {
                head.next = list2;
                list2 = list2.next;
                head = head.next;
            }
        }

        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }

        shuchu(head1.next);
        return head1.next;
    }

    // 好好理解一下
    // 递归版 分解问题：把一个任务分解成重复的多个子任务
//    并且这个算法不需要额外的存储空间
    public ListNode Merge1(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
//        好好理解一下
        if (list1.val <= list2.val) {
//            递归返回list的头结点，那么接下来就要处理list1.next才能续上这个返回的链表
            list1.next = Merge1(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge1(list1, list2.next);
            return list2;
        }
    }

    private void shuchu(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }
}
