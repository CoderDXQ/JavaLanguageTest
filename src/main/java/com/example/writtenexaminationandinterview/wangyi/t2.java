package com.example.writtenexaminationandinterview.wangyi;


/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/10 2:53 下午
 */
public class t2 {

    public static ListNode minusList(ListNode minuendList, ListNode subtrahendList) {
        // write code here


        return null;
    }

    //    反转链表
    public static void Reverse(ListNode head) {

        ListNode pre = null;
        ListNode prepre = null;
        ListNode slow = head;
        while (slow != null) {
            pre = slow;
            slow = slow.next;
            pre.next = prepre;
            prepre = pre;
        }

    }


    public static void main(String[] args) {

        //{1, 2, 4},{-1, 2, 3}
        int[] num1 = new int[]{1, 2, 4};
        int[] num2 = new int[]{-1, 2, 3};

        ListNode l1 = ListUtils.create(num1);
        ListNode l2 = ListUtils.create(num2);

        Reverse(l1);
        ListUtils.print(l1);


    }


}
