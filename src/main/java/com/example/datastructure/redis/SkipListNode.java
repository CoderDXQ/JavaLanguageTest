package com.example.datastructure.redis;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/18 10:38 上午
 */

//跳表结点 跳表结点中的数据是成员对象 其余的都是检索用的
public class SkipListNode<T> {

    //    索引层 多个索引层结点组成数组，每个结点的forward指针指向要跳过去的结点  通过forward来加快查找速度
    private SkipListLevel[] level;

    //    后退指针 指向前一个节点
    private SkipListNode<T> backword;

    //    分值 是一个浮点数  跳表中所有结点都按照分值大小来排序
    private Double score;

    //    成员对象 具体的数据对象
    private T obj;

    SkipListNode(T obj) {
        this.obj = obj;
        this.level = new SkipListLevel[32];
        initLevel(this.level, 32);
        this.score = Double.valueOf(0);
    }

    public SkipListNode(T obj, int levelHeight, Double score) {
        this.score = score;
        this.obj = obj;
        this.level = new SkipListLevel[levelHeight];
        initLevel(this.level, levelHeight);
    }

    //    初始化索引层
    private void initLevel(SkipListLevel[] level, int height) {
        for (int i = 0; i < height; i++) {
            level[i] = new SkipListLevel();
        }
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof SkipListNode) {
            SkipListNode node = (SkipListNode) anObject;
            return score.equals(node.score) && obj.equals(node.obj);
        }
        return false;
    }

    public SkipListLevel[] getLevel() {
        return level;
    }

    public void setLevel(SkipListLevel[] level) {
        this.level = level;
    }

    public SkipListNode<T> getBackword() {
        return backword;
    }

    public void setBackword(SkipListNode<T> backword) {
        this.backword = backword;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
