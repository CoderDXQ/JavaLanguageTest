package com.example.designpatterns.interceptingFilter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/17 12:16 上午
 */
public class FilterManager {
    FilterChain filterChain;

    public FilterManager(Target target) {
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }

    public void setFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request) {
        filterChain.execute(request);
    }
}
