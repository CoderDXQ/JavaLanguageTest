package com.example.writtenexaminationandinterview.gongsibishi.wangyi;

//使用链表做有符号的加减法
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

    public static ListNode exe(ListNode l1, ListNode l2) {

        boolean add = false;
        boolean sub = false;

//       符号标记  true是正 false是负
        boolean flag = true;

//        判断使用加减法还有结果符号
        if (l1.val >= 0) {
            if (l2.val <= 0) {
                add = true;
                flag = true;
            } else {
                sub = true;
//                表示减法的时候两个数都大于0 结果的具体符号有待判断
                flag=true;
            }
        } else {
            if (l2.val >= 0) {
                add = true;
                flag = false;
            } else {
                sub = true;
//                表示减法的时候两个数都小于0 结果的具体符号有待判断
                flag=false;
            }

        }


        if (add == true) {
            ListNode result = add(l1, l2);
            if (flag == false) {
                result.val = -result.val;
            }
            return result;
        }

        if (sub == true) {
            ListNode result = sub(l1, l2);
            return result;
        }

        return null;
    }

    //    加法
    public static ListNode add(ListNode l1, ListNode l2) {
        ListNode newl1 = reverse(l1);
        ListNode newl2 = reverse(l2);

        //        全部变成正数
        if (l1.val < 0) {
            l1.val = -l1.val;
        }
        if (l2.val < 0) {
            l2.val = -l2.val;
        }

        ListNode newhead = new ListNode(0);
        ListNode re = newhead;
        int carry = 0;
        while (newl1 != null || newl2 != null) {
            if (newl1 != null && newl2 != null) {
                newhead.val = (carry + newl1.val + newl2.val) % 10;
                carry = (carry + newl1.val + newl2.val) / 10;
                newhead.next = new ListNode(0);
                newl1 = newl1.next;
                newl2 = newl2.next;
                newhead = newhead.next;
            } else if (newl1 != null) {
                newhead.val = (carry + newl1.val) % 10;
                carry = (carry + newl1.val) / 10;
                newhead.next = new ListNode(0);
                newl1 = newl1.next;
                newhead = newhead.next;
            } else if (newl2 != null) {
                newhead.val = (carry + newl2.val) % 10;
                carry = (carry + newl2.val) / 10;
                newhead.next = new ListNode(0);
                newl2 = newl2.next;
                newhead = newhead.next;
            }

        }

        ListNode result = reverse(re);

        while (result.val == 0) {
            result = result.next;
        }
        return result;
    }

    //    减法 还要比较大小确定正负号
    public static ListNode sub(ListNode l1, ListNode l2) {

//        确定结果符号
        boolean flag=true;

        ListNode newl1 = reverse(l1);
        ListNode newl2 = reverse(l2);




        return null;
    }


    //    链表翻转
    public static ListNode reverse(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode newhead = null;

        while (cur != null) {
            pre = cur;
            cur = cur.next;
            pre.next = newhead;
            newhead = pre;
        }

//        while (newhead!=null){
//            System.out.print(newhead.val+" ");
//            newhead=newhead.next;
//        }

        return newhead;

    }

    public static void main(String[] args) {

//        验证各种加法
//        int[] l1 = new int[]{1, 2, 4};
//        int[] l2 = new int[]{-1, 2, 6};

//        int[] l1 = new int[]{1, 2, 4};
//        int[] l2 = new int[]{-1, 2, 6,8};

//        int[] l1 = new int[]{-1, 2, 4};
//        int[] l2 = new int[]{1, 2, 6, 8};

//        验证各种减法
        int[] l1 = new int[]{1, 2, 4};

        int[] l2 = new int[]{1, 2, 6};

        ListNode result = exe(create(l1), create(l2));

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }


    }


}
