package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/16 11:28 上午
 */
public class lt2 {

    //    空间复杂度为常数的方法
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = 0;
        ListNode head = l1;
        ListNode pre = l1;

        while (l1 != null && l2 != null) {
            sum = sum + l1.val + l2.val;
            l1.val = sum % 10;
            sum /= 10;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = sum + l1.val;
            l1.val = sum % 10;
            sum /= 10;
            pre = l1;
            l1 = l1.next;
            if (sum == 0) {
                return head;
            }
        }

        while (l2 != null) {
            sum += l2.val;
            l2.val = sum % 10;
            sum /= 10;
            pre.next = l2;
            pre = l2;
            l2 = l2.next;
            if (sum == 0) {
                return head;
            }
        }

        if (sum > 0) {
            pre.next = new ListNode(sum);
            sum /= 10;
        }

        return head;
    }


    public static void main(String[] args) {
        int[] l1 = new int[]{9, 9, 9, 9, 9, 9, 9};
        int[] l2 = new int[]{9, 9, 9, 9};
        ListUtils.print(addTwoNumbers(ListUtils.create(l1), ListUtils.create(l2)));
    }
}
