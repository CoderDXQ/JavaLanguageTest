package com.example.datastructure.sort;


import java.util.Arrays;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/31 11:41 下午
 */
//自定义排序
public class CustomSort {

    //    或者用泛型
    static class Node implements Comparable {
        int abscha;
        int val;
        int index;

        public Node(int abscha, int val, int index) {
            this.abscha = abscha;
            this.val = val;
            this.index = index;
        }


        //升序
        @Override
        public int compareTo(Object o) {
            Node oo = (Node) o;
            if (this.abscha == oo.abscha) {
                return index - oo.index;
            } else {
                return abscha - oo.abscha;
            }
        }

    }

    public static void Cusstom(int[] nums, int k) {
        Node[] nodes = new Node[nums.length];

        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new Node(Math.abs(k - nums[i]), nums[i], i);
        }

//        在类里实现了比较器  大的放前面
        Arrays.sort(nodes);

        for (int i = 0; i < 5; i++) {
            System.out.println("value: " + nodes[i].val + " index: " + nodes[i].index + " abs: " + nodes[i].abscha);
        }

        System.out.println();

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 4, 5, 2, 7, 5, 6};
        int k = 4;
        Cusstom(nums, k);
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
