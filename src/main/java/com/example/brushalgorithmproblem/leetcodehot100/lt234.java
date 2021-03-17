package com.example.brushalgorithmproblem.leetcodehot100;


import java.util.ArrayList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/17 10:46 上午
 */

//回文链表
public class lt234 {

    //    反转链表+快慢指针  快慢指针用来找链表中中间的位置
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode pre = null;
        ListNode prepre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
//        fast!=null&&fast.next==null 链表有奇数个元素
//        fast==null 链表有偶数个元素
        if (fast != null) {
            slow = slow.next;
        }

        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    //    转化为数组
    public static boolean isPalindrome1(ListNode head) {
//        用ArrayList不需要指定数组的长度
        ArrayList list = new ArrayList();
        int k = 0;
        while (head != null) {
            list.add(head.val);
            k++;
            head = head.next;
        }

        int mid = list.size() >> 1;
        int left, right;
        if ((list.size() & 1) == 1) {
            left = mid - 1;
            right = mid + 1;
        } else {
            right = mid;
            left = mid - 1;
        }

        while (left > -1 && list.get(left) == list.get(right)) {
            left--;
            right++;
        }

        if (left >= 0) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] lists = new int[]{1, 0, 0};
        System.out.println(isPalindrome(ListUtils.create(lists)));
        System.out.println(isPalindrome1(ListUtils.create(lists)));
    }

}
