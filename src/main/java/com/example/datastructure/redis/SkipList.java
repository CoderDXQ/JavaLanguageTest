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
//跳表本质上还是一个一维链表 只不过因为索引层的存在使它可以快速跳转到另外的结点而不是一个一个遍历过去
public class SkipList<T extends Comparable<? super T>> implements RedisObj {
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
    public SkipList() {
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
//        levelHeight不能为0
        Random random = new Random();
        int i = 1;
        for (; i < 32; ++i) {
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
            for (; i >= maxLevelHeight; --i) {
                update[i] = header;
                rank[i] = 0;
            }
            maxLevelHeight = levelHeight;
        }

//        收集需要更新的结点（针对低一点的索引层）i就是层高  下载在同一层上进行跳转
        for (; i >= 0; --i) {
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
        for (i = update.length - 1; i >= levelHeight; --i) {
//            没有forward指针
            if (update[i].getLevel()[i].getForward() == null) {
                continue;
            }
//             有前进指针的索引+1
            int span = update[i].getLevel()[i].getSpan();

            update[i].getLevel()[i].setSpan(++span);
        }

//        继续遍历update[] 进行插入和更新操作 在这些高度的结点（ 高度<levelHeight）既需要更新span值 又需要更新forward指针
        for (; i >= 0; --i) {
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

    /**
     * 删除结点
     *
     * @param score
     * @param obj
     * @return
     */
    public SkipListNode zslDelete(double score, T obj) {
//        存放删除后需要更新的结点
        SkipListNode[] update = new SkipListNode[maxLevelHeight];
        SkipListNode<T> node = header;

//        遍历查找删除后需要更新的结点 i是高度
        for (int i = maxLevelHeight - 1; i >= 0; i--) {
            SkipListNode<T> next = node.getLevel()[i].getForward();
//            遍历得到与target最接近的结点
            while (next != null && (score > next.getScore() || score == next.getScore() && next.getObj().compareTo(obj) < 0)) {
                node = next;
                next = node.getLevel()[i].getForward();
            }
            update[i] = node;
        }

//        待删除的目标节点
        SkipListNode<T> target = update[0].getLevel()[0].getForward();
        if (target == null) {
            return null;
        }

//        删除后的更新操作 更新span和forward
        for (int i = maxLevelHeight - 1; i >= 0; i--) {
            SkipListLevel current = update[i].getLevel()[i];
            SkipListNode<T> next = current.getForward();
            if (next == null) {
                continue;
            }
            if (next != target) {
//                跨度减一 因为少了一个结点
                current.modifySpan(-1);
                continue;
            }
//            next==target的情况
            current.setForward(target.getLevel()[i].getForward());
            if (current.getForward() != null) {
//                更新跨度 跨度减少 少了target的跨度
                current.modifySpan(target.getLevel()[i].getSpan() - 1);
            } else {
//                没有forward所以跨度为0
                current.setSpan(0);
            }
        }

        length--;
//        删除了高度最大的结点
        while (header.getLevel()[maxLevelHeight - 1].getSpan() == 0) {
            maxLevelHeight--;
        }
        return target;
    }

    /**
     * 判断是否有结点的分值在某个范围中
     *
     * @param fromScore
     * @param toScore
     * @return
     */
    public boolean zslIsInRange(double fromScore, double toScore) {
//        结点的分值是按从大到小来的
        if (header.getScore() > toScore || tail.getScore() < fromScore) {
            return false;
        }
        return true;
    }


    /**
     * 根据分值范围 返回第一个符合范围的结点
     *
     * @param fromScore 分值区间左值
     * @param toScore   分值区间右值
     * @param node      表示从哪个结点开始访问
     * @param k         表示从哪个索引层开始访问
     * @return
     */
//    搜索过程先向右后向下
    public SkipListNode<T> zslFirstInRange(double fromScore, double toScore, SkipListNode<T> node, int k) {
//        判断区间合理性
        if (!zslIsInRange(fromScore, toScore)) {
            return null;
        }

//        同层的下一个结点
        SkipListNode<T> next = node.getLevel()[k].getForward();

//        同层走到最后一个结点
        if (next == null || next.getScore() >= fromScore) {
//            最底层
            if (k == 0) {
//                最底层最右边的结点
                return next != null && next.getScore() > toScore ? null : next;
            }
//            同层走到最后一个结点后向(索引层)下一高度搜索
            return zslFirstInRange(fromScore, toScore, node, k - 1);
        }
//        同高度横向搜索
        return zslFirstInRange(fromScore, toScore, next, k);
    }


    /**
     * 根据分值范围 返回最后一个符合范围的结点
     *
     * @param fromScore
     * @param toScore
     * @param node
     * @param k
     * @return
     */
    public SkipListNode<T> zslLastInRange(double fromScore, double toScore, SkipListNode<T> node, int k) {
//        判断区间合理性
        if (!zslIsInRange(fromScore, toScore)) {
            return null;
        }

        SkipListNode<T> next = node.getLevel()[k].getForward();

//        同层走到头或者同层结点不符合范围要求
        if (next == null || next.getScore() > toScore) {
            if (k == 0) {
                return next != null && next.getScore() < fromScore ? null : node;
            }
//            向下一层搜索
            return zslLastInRange(fromScore, toScore, node, k - 1);
        }

        return zslLastInRange(fromScore, toScore, next, k);
    }

    /**
     * 搜索某个分值的结点是否存在
     *
     * @param score
     * @param node
     * @param k
     * @return
     */
    public SkipListNode<T> searchByScore(double score, SkipListNode<T> node, int k) {
        return zslFirstInRange(score, score, node, k);
    }


    public SkipListNode<T> getHeader() {
        return header;
    }

    public void setHeader(SkipListNode<T> header) {
        this.header = header;
    }

    public SkipListNode<T> getTail() {
        return tail;
    }

    public void setTail(SkipListNode<T> tail) {
        this.tail = tail;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public int getMaxLevelHeight() {
        return maxLevelHeight;
    }

    public void setMaxLevelHeight(int maxLevelHeight) {
        this.maxLevelHeight = maxLevelHeight;
    }

    /**
     * 输出整个跳表
     *
     * @param skipList
     */
    public static void printSkipList(SkipList<?> skipList) {
        System.out.println("length:" + skipList.length);
        System.out.println("maxLevel:" + skipList.maxLevelHeight);
        SkipListNode<?> temp = skipList.header;
        while (temp != null) {
            printNode(temp);
            temp = temp.getLevel()[0].getForward();
        }
        System.out.println();
    }

    /**
     * 输出结点信息
     *
     * @param node
     */
    public static void printNode(SkipListNode<?> node) {
        System.out.println();
        System.out.print(" score:" + node.getScore());
        System.out.print(" data:" + node.getObj());
        System.out.print(" LEVELS:");
        for (int i = 0; i < node.getLevel().length; i++) {
            System.out.print(" level" + i + ":" + node.getLevel()[i].getSpan());
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {

        SkipList<Integer> skipList = new SkipList<>();
//        测试添加结点
        System.out.println("测试插入结点");
        skipList.zslInsert(1.2, 32);
        skipList.zslInsert(1.6, 30);
        skipList.zslInsert(1.4, 36);
        skipList.zslInsert(1.4, 30);
        skipList.zslInsert(2.6, 56);
        skipList.zslInsert(3.6, 119);
        skipList.zslInsert(3.6, 119);
//        每次的跳表都是不同的  因为索引层的层数是随机的
        printSkipList(skipList);
        System.out.println();

//        测试搜索结点
        System.out.println("测试搜索结点");
        SkipListNode<Integer> temp = skipList.searchByScore(3.6, skipList.header, skipList.maxLevelHeight - 1);
        printNode(temp);
        System.out.println();

        SkipListNode<Integer> tempFirst = skipList.zslFirstInRange(1.2, 2.7, skipList.header, skipList.maxLevelHeight - 1);
        printNode(tempFirst);
        System.out.println();
        SkipListNode<Integer> tempLats = skipList.zslLastInRange(1.36, 1.6, skipList.header, skipList.maxLevelHeight - 1);
        printNode(tempLats);
        System.out.println();

//        测试删除结点
        System.out.println("测试删除结点");
        skipList.zslDelete(3.6, 119);
        printSkipList(skipList);
        System.out.println();

        skipList.zslDelete(3.6, 119);
        printSkipList(skipList);
    }
}
