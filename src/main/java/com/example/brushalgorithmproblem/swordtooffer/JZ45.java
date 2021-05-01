package com.example.brushalgorithmproblem.swordtooffer;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/12 11:51 下午
 */
//扑克牌顺子
public class JZ45 {

    public static boolean IsContinuous(int[] numbers) {
        if (numbers.length < 5) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : numbers) {
            if (map.containsKey(num)) {
                map.replace(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

//        HashMap的遍历方法
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            设置false规则 存在重复的牌且重复的牌不是大小王
            if (entry.getValue() > 1 && entry.getKey() != 0) {
                return false;
            }
            if (min > entry.getKey() && entry.getKey() != 0) {
                min = entry.getKey();
            }
            if (max < entry.getKey()) {
                max = entry.getKey();
            }
        }
//        设置false规则
        if (max - min > 4) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{0, 3, 2, 6, 4};

//        true
        System.out.println(IsContinuous(numbers));

    }
}
