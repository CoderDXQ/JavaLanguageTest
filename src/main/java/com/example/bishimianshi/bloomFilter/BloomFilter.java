package com.example.bishimianshi.bloomFilter;

import java.util.BitSet;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/6 10:04 下午
 */
//布隆过滤器
public class BloomFilter {

    private static final int DEFAULT_SIZE = 2 << 24;

    private static final int[] SEEDS = new int[]{3, 13, 46, 71, 91, 134};

    private BitSet bits = new BitSet(DEFAULT_SIZE);

    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    //    在构造方法中获取hash方法组
    public BloomFilter() {
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    //    布隆过滤器中添加元素
    public void add(Object value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);
        }
    }

    //    判断指定的元素是否在布隆过滤器中 有一定误判的可能
    public boolean contains(Object value) {
        boolean ret = true;
        for (SimpleHash f : func) {
            ret = ret && bits.get(f.hash(value));
            if (ret == false) {
                break;
            }
        }
        return ret;
    }

    //    哈希公式类
    public static class SimpleHash {
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        //        计算哈希值
        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode())) ^ (h >>> 16));
        }

    }


    //    测试
    public static void main(String[] args) {

        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";

        BloomFilter bloomFilter = new BloomFilter();

        System.out.println(bloomFilter.contains(value1));
        System.out.println(bloomFilter.contains(value2));

        bloomFilter.add(value1);
        bloomFilter.add(value2);

        System.out.println(bloomFilter.contains(value1));
        System.out.println(bloomFilter.contains(value2));

    }


}
