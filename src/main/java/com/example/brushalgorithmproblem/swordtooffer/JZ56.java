package com.example.brushalgorithmproblem.swordtooffer;

import java.util.HashMap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 6:19 下午
 */
public class JZ56 {


    //    删除重复节点
    public static ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode result = null;
        ListNode cur = new ListNode();
        cur.next = pHead;
        ListNode gonext = null;
        boolean flag = false;
//        直接在原来的链表上编织新的链表
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                gonext = cur.next.next;
                while (gonext != null && gonext.val == cur.next.val) {
                    gonext = gonext.next;
                }
                cur.next = gonext;
            } else {
                if (flag == false) {
                    result = cur.next;
                    flag = true;
                }
                cur = cur.next;
            }
        }
        if (result == null) {
            result = gonext;
        }
        return result;
    }

    //    新建链表
    public static ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        HashMap<Integer, Integer> set = new HashMap<>();
        ListNode head = pHead;
        while (head != null) {
            if (set.containsKey(head.val)) {
                set.put(head.val, set.get(head.val) + 1);
            } else {
                set.put(head.val, 1);
            }
            head = head.next;
        }

        head = pHead;
        ListNode result = new ListNode();
        ListNode back = result;
//        直接在原来的链表上编织新的链表
        while (head != null) {
            if (set.get(head.val) == 1) {
                result.next = head;
                result = result.next;
            }
            head = head.next;
        }
//        如果直接使用新节点建立新链表就不用这么麻烦 这里主要是断掉最后几个元素相同的情况
        result.next = null;

        return back.next;
    }


    public static void main(String[] args) {
        int[] lists = new int[]{1, 1, 1, 1, 1, 1, 2};

        ListUtils.print(ListUtils.create(lists));

        ListUtils.print(deleteDuplication(ListUtils.create(lists)));
        ListUtils.print(deleteDuplication1(ListUtils.create(lists)));

    }
}
