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
        if (head != null) {
            System.out.println(head.val + " ");
            head = head.next;
        }
    }
}
