package com.example.brushalgorithmproblem.swordtooffer;

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
}
