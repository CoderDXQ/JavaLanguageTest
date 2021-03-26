package com.example.brushalgorithmproblem.leetcodehot100;


/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/1 9:56 下午
 */

//链表工具类 帮助刷题时的代码调试  提高速度和效率
public class ListUtils {
    /**
     * 顺序打印链表内容
     *
     * @param head
     */
    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 使用整型数组创建链表
     * 创建的链表是依次顺序相连的
     *
     * @param array
     * @return
     */
    public static ListNode create(int[] array) {
        ListNode pHead = new ListNode(array[0]);
        ListNode cur = pHead;
        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        return pHead;
    }

    /**
     * 根据数值返回链表结点
     *
     * @param i
     * @return
     */
    public static ListNode find(ListNode head, int i) {
        while (head != null && head.val != i) {
            head = head.next;
        }
        return head;
    }


}
