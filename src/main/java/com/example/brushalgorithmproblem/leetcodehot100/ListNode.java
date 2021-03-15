package com.example.brushalgorithmproblem.leetcodehot100;

import lombok.NoArgsConstructor;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/1 9:55 下午
 */
@NoArgsConstructor
public class ListNode {
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
