package com.example.atest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duanxiangqing <duanxiangqing@kuaishou.com>
 * Created on 2021-06-08
 */
public class nullTest {

    public static void main(String[] args) {

//        key和value都可以是null
        Map<Long, Long> userFansCountMap1 = new HashMap<>();
        userFansCountMap1.put(1L, null);
        userFansCountMap1.put(null, 1L);
        userFansCountMap1.put(null, 2L);

    }

}
