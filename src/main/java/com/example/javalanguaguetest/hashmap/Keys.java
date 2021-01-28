package com.example.javalanguaguetest.hashmap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/28 8:21 下午
 */
public class Keys {
    public static final int MAX_KEY = 10000000;
    private static final PerformanceOfHashMap.Key[] KEYS_CACHE = new PerformanceOfHashMap.Key[MAX_KEY];

    static {
        for (int i = 0; i < MAX_KEY; i++) {
            KEYS_CACHE[i] = new PerformanceOfHashMap.Key(i);
        }
    }

    public static PerformanceOfHashMap.Key of(int value) {
        return KEYS_CACHE[value];
    }
}
