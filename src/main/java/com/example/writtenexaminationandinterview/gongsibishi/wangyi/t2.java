package com.example.writtenexaminationandinterview.gongsibishi.wangyi;


public class t2 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }


        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode create(int[] array) {
        ListNode pHead = new ListNode(array[0]);
        ListNode cur = pHead;
        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        return pHead;
    }

    public static void exe(ListNode l1, ListNode l2) {

        reverse(l1);

        System.out.println();
    }

    //    加法
    public static void add() {

    }

    //    减法
    public static void sub() {

    }


    //    检查一下是否成功？？？
    public static void reverse(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode newhead = null;

        while (cur != null) {
            pre = cur;
            cur = cur.next;
            pre.next = newhead;
            newhead = pre;
        }

        System.out.println();

    }

    public static void main(String[] args) {
        int[] l1 = new int[]{1, 2, 4};

        int[] l2 = new int[]{-1, 2, 3};

        exe(create(l1), create(l2));


    }


}
