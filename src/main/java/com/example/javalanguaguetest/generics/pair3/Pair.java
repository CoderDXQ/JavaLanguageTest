package com.example.javalanguaguetest.generics.pair3;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/16 3:59 下午
 */

//泛型类
public class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
