package com.example.writtenexaminationandinterview.huawei;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 7:01 下午
 */
//复杂大模拟
public class t2 {

    public static void main(String[] args) {

        Set<Integer> hasDone = new HashSet<>();
        HashMap<Integer, List<Integer>> relation = new HashMap<>();

//        读入数据并处理
        Scanner in = new Scanner(System.in);
        String[] teke = in.nextLine().split(",");
        int[] times = new int[teke.length];
        for (int i = 0; i < teke.length; i++) {
            times[i] = Integer.valueOf(teke[i]);
        }
        String[] take1 = in.nextLine().split(",");
        for (int i = 0; i < take1.length; i++) {
            String[] nums = take1[i].split("->");
            int num11 = Integer.valueOf(nums[0]);
            int num12 = Integer.valueOf(nums[1]);
            if (relation.containsKey(num11)) {
                List<Integer> l = relation.get(num11);
                l.add(num12);
                relation.put(num11, l);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(num12);
                relation.put(num11, l);
            }
        }

//        System.out.println();
        int[] jisu = new int[teke.length];
        int curtime = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < teke.length; i++) {
            queue.offer(i);
        }

//        执行
        while (!queue.isEmpty()) {
            int k = queue.poll();
            if (relation.containsKey(k)) {
                List<Integer> l = relation.get(k);
//                处理依赖中完成的元素
                for (int i = 0; i < l.size(); i++) {
                    if (hasDone.contains(l.get(i))) {
                        l.remove(i);
                    }
                }
                if (l.isEmpty()) {
                    relation.remove(k);
                    curtime += times[k];
                    jisu[k] = curtime;
                    hasDone.add(k);
                } else {
//                    更新依赖
                    relation.put(k, l);
//                    返回队列重新排队
                    queue.offer(k);
                }
            } else {
                curtime += times[k];
                jisu[k] = curtime;
                hasDone.add(k);
            }
        }

        for (int i = 0; i < teke.length; i++) {
            System.out.print(jisu[i]);
            if (i < teke.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();

    }

}
