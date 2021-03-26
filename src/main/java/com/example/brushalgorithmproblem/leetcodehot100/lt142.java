package com.example.brushalgorithmproblem.leetcodehot100;

import com.example.javalanguaguetest.callback.two_writing_method_of_callback2.Li;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/26 6:42 下午
 */
public class lt142 {

    //    快慢指针  还有一种方法是记录链表的结点，但是需要额外的存储空间
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
//            相等说明有环
            if (slow != null && fast != null && fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    public static ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }


    public static void main(String[] args) {
        int[] lists = new int[]{1, 2};
        ListNode head = ListUtils.create(lists);

        ListNode l1 = ListUtils.find(head, 2);
        ListNode l2 = ListUtils.find(head, 1);
        if (l1 != null) {
            l1.next = l2;
        }

//        head = new ListNode(1);
        ListNode result = detectCycle(head);
        if (result == null) {
            System.out.println("null");
        } else {
            System.out.println(result.val);
        }

        ListNode result1 = detectCycle(head);
        if (result1 == null) {
            System.out.println("null");
        } else {
            System.out.println(result1.val);
        }

//        ListUtils.print(head);

    }
}
