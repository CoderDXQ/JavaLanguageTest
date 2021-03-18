package com.example.datastructure.redis;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/18 10:42 上午
 */
//索引层结点 使用forward来指向要跳跃的下一个节点
public class SkipListLevel {
    //    前进指针 指向要跳转的后续结点
    private SkipListNode forward;

    //    跨度 与指向的结点间的距离
    private int span;

    public SkipListLevel() {
        this.forward = null;
        this.span = 0;
    }

    public SkipListLevel(SkipListNode forward, int span) {
        this.forward = forward;
        this.span = span;
    }

    public SkipListNode getForward() {
        return forward;
    }

    public void setForward(SkipListNode forward) {
        this.forward = forward;
    }

    public int getSpan() {
        return span;
    }

    public void setSpan(int span) {
        this.span = span;
    }

    public void modifySpan(int offset) {
        this.span += offset;
    }


}
