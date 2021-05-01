package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/31 8:44 下午
 */
//两个链表的第一个公共结点
public class JZ36 {

    public static class ListNode {
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

    public static void create(ListNode l1, ListNode l2) {
        l1.next = l2;
    }

    //    双指针法 拼接法解决指针异步的问题
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
//        这个判断条件其实是不对的
        while (p1 != p2) {
            System.out.println(p1.val + " " + p2.val);
            p1 = p1 == null ? pHead2 : p1.next;

            p2 = p2 == null ? pHead1 : p2.next;
        }

//        这样写在没有交点时是会进入死循环的
//        while (p1.val != p2.val) {
//            System.out.println(p1.val + " " + p2.val);
//            p1 = p1.next == null ? pHead2 : p1.next;
//
//            p2 = p2.next == null ? pHead1 : p2.next;
//        }
//
        System.out.println(p1.val);
        return p1;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 1, 8, 4, 5};
        int[] arr2 = {5, 0, 1, 8, 4, 5};

        ListNode[] pHead1 = new ListNode[arr1.length];
        ListNode[] pHead2 = new ListNode[arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            pHead1[i] = new ListNode(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            pHead2[i] = new ListNode(arr2[i]);
        }


        for (int i = 0; i < arr1.length; i++) {
            System.out.println(pHead1[i]);
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(pHead2[i]);
        }
        System.out.println();

        for (int i = 0; i < arr1.length - 1; i++) {
            create(pHead1[i], pHead1[i + 1]);
        }

        for (int i = 0; i < arr2.length - 1; i++) {
            create(pHead2[i], pHead2[i + 1]);
        }

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(pHead1[i]);
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(pHead2[i]);
        }

        System.out.println();
//        也可以统计链表节点的入度，但是这个算法的时间复杂度虽然是O(n)级别，但是还是比双指针法差一点
        System.out.println(FindFirstCommonNode(pHead1[0], pHead2[0]));
    }
}
