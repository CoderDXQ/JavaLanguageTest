package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/17 11:56 下午
 */

//删除链表的倒数第 N 个结点
public class lt19 {

    //    快慢指针  快慢指针有两种：一种是速度快，可以用来找平均分段的节点；另一种是同速但是提前走，可以用来找倒数第n个点
    public static ListNode removeNthFromEnd(ListNode head, int n) {

//        防止删除头元素
        ListNode result = new ListNode(-1);
        result.next = head;

        ListNode fast = head, slow = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        ListNode pre = result;
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }

        pre.next = slow.next;

        return result.next;
    }


    public static void main(String[] args) {
        int[] heads = new int[]{1};
        int n = 1;
//        4
        ListUtils.print(removeNthFromEnd(ListUtils.create(heads), n));
    }
}
