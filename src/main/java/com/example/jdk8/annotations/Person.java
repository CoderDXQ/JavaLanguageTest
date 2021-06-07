package com.example.jdk8.annotations;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/7 12:37 上午
 */
@Hint("hint1")
@Hint("hint2")
class Person {

    public static void main(String[] args) {

        Hint hint = Person.class.getAnnotation(Hint.class);
        System.out.println(hint);

        System.out.println();

        Hints hints = Person.class.getAnnotation(Hints.class);
        System.out.println(hints);
        System.out.println(hints.value().length);
        System.out.println();

        Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);

    }

}
