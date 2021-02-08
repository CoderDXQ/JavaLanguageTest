package com.example.juc.newcharacterofjdk8.functioninterface;

import java.util.function.Supplier;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/9 12:39 上午
 */
public class SupplierTest {

    public static void main(String[] args) {

//        只有一个出参
        Supplier supplier = () -> {
            return 1024;
        };

        System.out.println(supplier.get());
    }
}
