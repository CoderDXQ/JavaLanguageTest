package com.example.writtenexaminationandinterview.gongsibishi.xiecheng;

import com.example.brushalgorithmproblem.leetcodehot100.ListNode;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/15 7:47 下午
 */

//包的依赖分析
//https://blog.csdn.net/qq_38993096/article/details/115742708
public class t1 {


    //    以输入"EOF"结束
    //    类似于倒排索引的思想
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String start = in.nextLine();
//        倒排索引表 将依赖关系转化为影响关系
        HashMap<String, List<String>> hashMap = new HashMap<>();
        while (in.hasNext()) {
//            读入的时候顺便分组
            String[] nums = in.nextLine().split(",");

            if (nums[0].equals("EOF")) {
                break;
            }

            for (int i = 1; i < nums.length; i++) {
                if (hashMap.containsKey(nums[i])) {
                    List<String> l = hashMap.get(nums[i]);
                    l.add(nums[0]);
                    hashMap.put(nums[i], l);
                } else {
                    List<String> l = new ArrayList<>();
                    l.add(nums[0]);
                    hashMap.put(nums[i], l);
                }
            }
        }

//        计算会影响哪些
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
//        去重
        Set<String> set = new HashSet<>();
        set.contains(start);

        int sum = 0;

        while (!queue.isEmpty()) {
            String s = queue.poll();

            List<String> l = hashMap.get(s);

            if (l == null) {
                break;
            }

            for (String ss : l) {
                if (!set.contains(ss)) {
                    queue.add(ss);
                    set.add(ss);
                    sum += Integer.valueOf(ss);
                }
            }

        }

        System.out.println(sum);

    }

}

//4
//1,2
//3,4,5,6
//2,3
//6,4,2
//8,9
//10
//EOF