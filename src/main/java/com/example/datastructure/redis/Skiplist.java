package com.example.datastructure.redis;

import java.util.Random;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/26 10:28 下午
 */
//参考：https://www.cnblogs.com/buptleida/p/12838880.html
//Redis中跳表的java实现
//跳表的结构结点 存储跳表的首尾结点、结点数量、层数
public class Skiplist<T extends Comparable<? super T>> implements RedisObj {
    //    首尾结点的指针
    private SkipListNode<T> header;
    private SkipListNode<T> tail;

    //    记录跳表的结点数量
    private long length;

    //    最大结点的层数
    private int maxLevelHeight;

    /**
     * 无参构造
     */
    public Skiplist() {
        SkipListNode<T> node = new SkipListNode<>(null);
        this.header = node;
        this.tail = node;
        this.length = 0;
        this.maxLevelHeight = 0;
    }

    /**
     * 使用幂次定律获取随机的索引层高度
     * 产生一个0-31之间的随机数
     *
     * @return
     */
    private static int getRandomHeight() {
        Random random = new Random();
        int i = 0;
        for (; i < 32; i++) {
            if (random.nextInt(2) == 0) {
                break;
            }
        }
        return i;
    }

    /**
     * 插入跳表结点
     *
     * @param score 分值
     * @param obj   成员对象
     * @return
     */
    public SkipListNode zslInsert(Double score, T obj) {
        int levelHeight = getRandomHeight();
        SkipListNode<T> target = new SkipListNode<>(obj, levelHeight, score);

//        创建更新数组 里面的结点都是需要更新数据的结点
        SkipListNode[] update = new SkipListNode[Math.max(levelHeight, maxLevelHeight)];

        int[] rank = new int[update.length];
        int i = update.length - 1;
//        新结点的索引层数大于原来的最大层数  把多余的层数（超高的索引层）进行初始化 超高的层是由header的forward指针直接指向过来的
        if (levelHeight > maxLevelHeight) {
            for (; i >= maxLevelHeight; i--) {
                update[i] = header;
                rank[i] = 0;
            }
            maxLevelHeight = levelHeight;
        }

//        收集需要更新的结点（针对低一点的索引层）i就是层高  下载在同一层上进行跳转
        for (; i >= 0; i--) {
            SkipListNode<T> node = header;
            SkipListNode<T> next = node.getLevel()[i].getForward();
            rank[i] = 0;
//            找到与target最接近的结点 每次都从头结点的不同索引开始跳着找与target最接近的加进来
            while (next != null && (score > next.getScore() || score == next.getScore() && next.getObj().compareTo(obj) < 0)) {
//                rank数组中存放的累计跳转的跨度和
                rank[i] += node.getLevel()[i].getSpan();
                node = next;
                next = node.getLevel()[i].getForward();
            }
//            update[]里面的结点都是需要更新数据的结点
            update[i] = node;
        }

//        更新收集的结点的span  在这些高度的结点（ 高度>=levelHeight）只需要更新sapn值 不需要更新forward指针
//        当新结点的高度大于以前的最高高度时 前面部分结点的span值+1
//        span是跨度 是当前节点与其forward指针所指向的结点之间的距离
        for (i = update.length - 1; i >= levelHeight; i--) {
//            没有forward指针
            if (update[i].getLevel()[i].getForward() == null) {
                continue;
            }
//             有前进指针的索引+1
            int span = update[i].getLevel()[i].getSpan();

            update[i].getLevel()[i].setSpan(++span);
        }

//        继续遍历update[] 进行插入和更新操作 在这些高度的结点（ 高度<levelHeight）既需要更新sapn值 又需要更新forward指针
        for (; i >= 0; i--) {
            SkipListLevel pre = update[i].getLevel()[i];
//            将target结点插入update[i]和temp之间
            SkipListNode<T> temp = pre.getForward();
            int span = pre.getSpan();

//            pre的forward指针指向target
            pre.setForward(target);
//            设置跨度
            pre.setSpan(rank[0] + 1 - rank[i]);

//            设置target的span值 i代表层高
            target.getLevel()[i].setSpan(span > 0 ? (span - rank[0] + rank[i]) : 0);
//            设置target的forward指针指向temp
            target.getLevel()[i].setForward(temp);

//            设置后退指针
            if (temp == null) {
//                没有回退指针就直接退回header
                target.setBackword(header);
            } else {
                target.setBackword(temp.getBackword());
                temp.setBackword(target);
            }
        }

        if (tail.getLevel()[0].getForward() != null) {
            tail = target;
        }

//        更新长度
        length++;
        return target;
    }


    public static void main(String[] args) {


    }
}
