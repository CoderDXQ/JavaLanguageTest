package com.example.javalanguaguetest.hashmap;

import java.util.HashMap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/28 7:54 下午
 */
public class PerformanceOfHashMap {
    static class Key implements Comparable<Key> {
        private final int value;

        Key(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Key o) {
            return Integer.compare(this.value, o.value);
        }

        //        重写hashCode() 分布均衡的情况
//        @Override
//        public int hashCode() {
//            return value;
//        }

        //        重写hashCode() 分布不均衡的情况
        @Override
        public int hashCode() {
            return 1;
        }

        //        重写equals()
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Key key = (Key) obj;
            return key.value == value;
        }
    }

    static void test(int mapSize) {
        HashMap<Key, Integer> map = new HashMap<Key, Integer>(mapSize);
        for (int i = 0; i < mapSize; i++) {
            map.put(Keys.of(i), i);
        }

        long beginTime = System.nanoTime();
        for (int i = 0; i < mapSize; i++) {
            map.get(Keys.of(i));
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - beginTime);
    }

    public static void main(String[] args) {
        for (int i = 10; i < 10000000; i *= 10) {
            test(i);
        }
    }

}
