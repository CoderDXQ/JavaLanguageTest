package com.example.writtenexaminationandinterview.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义线程不安全的注解
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/17 11:19 下午
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotThreadSafe {
    String value();
}
