package com.example.brushalgorithmproblem.swordtooffer;

import java.util.HashMap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/3 12:23 上午
 */
public class JZ25 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    //    使用HashMap记录节点间的关系
    public RandomListNode Clone(RandomListNode pHead) {

        HashMap<RandomListNode, RandomListNode> record = new HashMap<RandomListNode, RandomListNode>();

//        建立旧节点与新节点的一一对应关系
        RandomListNode head = pHead;
        while (head != null) {
            record.put(head, new RandomListNode(head.label));
            head = head.next;
        }

//        复制关系
        head = pHead;
        while (head != null) {
            record.get(head).next = (head.next == null) ? null : record.get(head.next);
            record.get(head).random = (head.random == null) ? null : record.get(head.random);
            head = head.next;
        }
        return record.get(pHead);
    }

    //    模板复制
    public RandomListNode Clone1(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        //插入节点制造模板
        RandomListNode p = pHead;
        RandomListNode pnext, prandom;
        while (p != null) {
            RandomListNode temp = new RandomListNode(p.label);
            pnext = p.next;
            p.next = temp;
            p.next.next = pnext;
            p = pnext;
        }

//        复制随机节点关系
        p = pHead;
        while (p != null) {
            prandom = p.random;
            p.next.random = p.random == null ? null : prandom.next;
            p = p.next.next;
        }

//        脱离模板

//        这个方法未完全脱离
//        p = pHead.next;
//        RandomListNode out = pHead.next;
//        while (p != null) {
//            p.next = p.next == null ? null : p.next.next;
//            p = p.next;
//        }

        p = pHead;
        RandomListNode pcopy = pHead.next;
        RandomListNode out = pHead.next;
        while (p != null) {
            p.next = pcopy.next;
            pcopy.next = pcopy.next == null ? null : pcopy.next.next;
            p = p.next;
            pcopy = pcopy.next;
        }

        return out;
    }

    public static void main(String[] args) {

    }
}
