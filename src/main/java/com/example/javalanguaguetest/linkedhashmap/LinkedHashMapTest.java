package com.example.javalanguaguetest.linkedhashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/18 9:54 下午
 */
//LinkedHashMap可以记录数据插入的顺序
public class LinkedHashMapTest {


    public static void main(String[] args) {

//        LinkedHashMap是按照添加的顺序输出的  其内部维护一个双向链表来记录添加的顺序  同时在遍历的时候直接遍历这个双向链表
        System.out.println("**********LinkedHashMap的顺序**************");
        Map<Integer, String> map = new LinkedHashMap<Integer, String>();
        map.put(6, "apple");
        map.put(3, "banana");
        map.put(2, "pear");

        for (Iterator it = map.keySet().iterator(); it.hasNext(); ) {
            Object key = it.next();
            System.out.println(key + "=" + map.get(key));
        }
        System.out.println();

//        HashMap在遍历的时候是遍历每个bucket，然后在每个bucket上遍历链表或者红黑树
        System.out.println("**********HashMap的顺序**************");
        Map<Integer, String> hashmap = new HashMap<>();
        hashmap.put(6, "apple");
        hashmap.put(3, "banana");
        hashmap.put(2, "pear");
        for (Iterator it = hashmap.keySet().iterator(); it.hasNext(); ) {
            Object key = it.next();
            System.out.println(key + "=" + hashmap.get(key));
        }


    }

}
