package com.example.datastructure.redis;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/18 10:38 上午
 */
public class SkipListNode<T> {

    //    层
    private SkipListLevel[] level;

    //    后退指针
    private SkipListNode<T> backword;

    //    分值
    private Double score;

    //    成员对象
    private T obj;

    SkipListNode(T obj) {
        this.obj = obj;
        this.level = new SkipListLevel[32];
        initLevel(this.level, 32);
        this.score = Double.valueOf(0);
    }

    public SkipListNode(Double score, T obj, int levelHeight) {
        this.score = score;
        this.obj = obj;
        this.level = new SkipListLevel[levelHeight];
        initLevel(this.level, levelHeight);
    }

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
