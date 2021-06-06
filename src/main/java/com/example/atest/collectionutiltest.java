package com.example.atest;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duanxiangqing <duanxiangqing@kuaishou.com>
 * Created on 2021-06-06
 */
public class collectionutiltest {

    public static void main(String[] args) {

        List<Integer> a = null;
        System.out.println(CollectionUtils.isEmpty(a));

        a = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(a));

        a.add(6);
        System.out.println(CollectionUtils.isEmpty(a));

    }

}
