package com.example.datastructure.redis;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/18 10:42 上午
 */
public class SkipListLevel {
    //    前进指针
    private SkipListNode forward;

    //    跨度
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
