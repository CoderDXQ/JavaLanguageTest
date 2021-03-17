package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/17 10:47 下午
 */

//相交链表
public class lt160 {
    //    首尾相接法
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode h1 = headA, h2 = headB;
//        不行就用equals 即便是数值一样 在内存中也不是同一个
        while (h1 != h2) {
            System.out.println(h1.val + " " + h2.val);
//            这样会改变原来链表的值
//            h1 = h1.next == null ? headB : h1.next;
//            h2 = h2.next == null ? headA : h2.next;
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }

    public static void main(String[] args) {
        int[] list1 = new int[]{4, 1, 8, 4, 5};
        int[] list2 = new int[]{5, 6, 1, 8, 4, 5};

//        4
        System.out.println(getIntersectionNode(ListUtils.create(list1), ListUtils.create(list2)).val);
    }
}
