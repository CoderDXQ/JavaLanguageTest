package com.example.brushalgorithmproblem.swordtooffer;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 11:33 下午
 */
public class JZ63 {
    //    默认是小顶堆 弹出最小值 存放后半截
    public static PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    //    设置为大顶堆 弹出最大值 存放前半截
    public static PriorityQueue<Integer> maxQueue = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));

    //    对顶堆
    public static int cnt = 0;

    public static void Insert(Integer num) {
        cnt++;
        if (cnt % 2 == 1) {
//            奇数的话先插入小顶堆，然后从小顶堆拿出最小值插入大顶堆 所以最后是大顶堆数量多
            minQueue.offer(num);
            num = minQueue.poll();
            maxQueue.offer(num);
        } else {
//            偶数的话先插入大顶堆，然后从大顶堆拿出最大值插入小顶堆
            maxQueue.offer(num);
            num = maxQueue.poll();
            minQueue.offer(num);
        }
    }

    public static Double GetMedian() {
        return maxQueue.size() > minQueue.size() ? Double.valueOf(maxQueue.peek()) : (Double.valueOf(minQueue.peek()) + Double.valueOf(maxQueue.peek())) / 2;
    }


    public static List<Integer> list = new LinkedList<>();
    //插入排序  使用二分法查找插入位置
    public static void Insert1(Integer num) {
        if (list.size() == 0) {
            list.add(num);
//            不在继续向下运行 直接返回
            return;
        }
        int left = 0, right = list.size() - 1, mid=0;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (list.get(mid) < num) {
                left = mid + 1;
            } else if (list.get(mid) > num) {
                right = mid - 1;
            } else {
                break;
            }
        }
        list.add(mid, num);
    }

    public static Double GetMedian1() {
        return list.size() % 2 == 1 ? Double.valueOf(list.get(list.size() >> 1)) : (Double.valueOf(list.get(list.size() >> 1)) + Double.valueOf(list.get((list.size() - 1) >> 1))) / 2;
    }


    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 3, 4, 1, 6, 7, 0, 8};
        //5.00 3.50 3.00 3.50 3.00 3.50 4.00 3.50 4.00
        for (int i = 0; i < array.length; i++) {
            Insert(array[i]);
            System.out.print(GetMedian() + " ");
        }
        System.out.println();

        //5.00 3.50 3.00 3.50 3.00 3.50 4.00 3.50 4.00
        for (int i = 0; i < array.length; i++) {
            Insert1(array[i]);
            System.out.print(GetMedian1() + " ");
        }
        System.out.println();
    }
}
