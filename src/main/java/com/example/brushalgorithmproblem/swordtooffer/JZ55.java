package com.example.brushalgorithmproblem.swordtooffer;

import java.util.HashSet;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 9:04 下午
 */
public class JZ55 {

    //    哈希 第一个重复的节点就是环的入口
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> set = new HashSet<>();

        while (pHead != null) {
            if (set.contains(pHead)) {
                return pHead;
            }
            set.add(pHead);
            pHead = pHead.next;
        }

        return null;
    }

    //    同速快慢指针
    public static ListNode EntryNodeOfLoop1(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        boolean flag = false;
        //找到相遇点
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                flag = true;
                break;
            }
        }
        if (flag == false) {
            return null;
        }
//        计算环的长度
        int k = 0;
        fast = fast.next;
        while (fast != slow) {
            k++;
            fast = fast.next;
        }
        k++;

        fast = pHead;
        slow = pHead;
//        同速快慢指针
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    //    抽象异速快慢指针 设起点到环的入口的距离为l，环的入口到相遇点的距离为k,那么2(l+k)=l+k+ns,解得ns=l+k即l=ns-k,也就是说在相遇后将快指针从起点与慢指针同速重新走，相遇的时候刚好在环的入口
    public static ListNode EntryNodeOfLoop2(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //找到相遇点
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null || slow == null || fast.next == null) {
            return null;
        }

        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }


    public static void main(String[] args) {

    }
}
