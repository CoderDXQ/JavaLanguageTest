package com.example.javalanguaguetest.collections.maptest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/29 9:10 下午
 */
public class MapTest {
    public static void main(String[] args) {
        //set就是key-value键值对
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        //二次取值遍历
        for (String key : map.keySet()) {//遍历key的集合
            System.out.println("key= " + key + " and value= " + map.get(key));//根据key拿value
        }

        System.out.println("\n");

        //使用迭代器
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        System.out.println("\n");
        //大容量
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        System.out.println("\n");

        //只遍历value
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }


    }


}
