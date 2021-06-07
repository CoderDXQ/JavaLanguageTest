package com.example.jdk8.methodreferences.factory;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/6 10:44 下午
 */
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    String firstName;
    String lastName;

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
