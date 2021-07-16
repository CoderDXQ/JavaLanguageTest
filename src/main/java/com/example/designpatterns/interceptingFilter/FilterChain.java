package com.example.designpatterns.interceptingFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/17 12:13 上午
 */
//过滤器链
public class FilterChain {

    private List<Filter> filters = new ArrayList<Filter>();
    private Target target;

    public void setTarget(Target target) {
        this.target = target;
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    //    定义过滤器链的顺序结构
    public void execute(String request) {
        for (Filter filter : filters) {
            filter.execute(request);
        }
        target.execute(request);
    }

}
