package com.example.writtenexaminationandinterview.localcache;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/14 1:04 上午
 */
//Cache类 包含创建时间等 可以帮助实现算法
@Getter
@Setter
public class Cache implements Comparable<Cache> {

    //    键
    private Object key;
    //    缓存值
    private Object value;
    //    最后一次访问时间
    private long accessTime;
    //    创建时间
    private long writeTime;
    //    存活时间
    private long expireTime;
    //    命中次数
    private Integer hitCount;

    //    自定义比较器
    @Override
    public int compareTo(Cache o) {
        return hitCount.compareTo(o.hitCount);
    }

}
