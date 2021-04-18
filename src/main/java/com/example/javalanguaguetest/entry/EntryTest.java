package com.example.javalanguaguetest.entry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/18 9:34 下午
 */
//Entry的用法
public class EntryTest {

    static class Ele implements Map.Entry {

        String key;
        String value;

        public Ele(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            this.value = (String) value;
            return null;
        }
    }


    public static void main(String[] args) {
//        存放的不是键值对
        Set<Map.Entry<String, String>> set = new HashSet<>();

        set.add(new Ele("sf", "fg"));
        set.add(new Ele("sf", "f4g"));
        set.add(new Ele("sef", "fg"));
        set.add(new Ele("sf", "fg"));

        for (Map.Entry entry : set) {
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }
        System.out.println();

//        存放的是键值对 同一个key只能有一个值 后来的会覆盖前面的
        HashMap<String, String> sset = new HashMap<>();
        sset.put("sf", "fg");
        sset.put("sf", "f4g");
        sset.put("sef", "fg");
        sset.put("sf", "f8g");

//        只有遍历的时候可以用Entry
        for (Map.Entry entry : sset.entrySet()) {
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }

    }

}
