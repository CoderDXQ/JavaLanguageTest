package com.example.jdk8.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/7 12:35 上午
 */
//运行时注解
@Retention(RetentionPolicy.RUNTIME)
@interface Hints {
    Hint[] value();
}

//可重复注解
@Repeatable(Hints.class)
@interface Hint {
    String value();
}
