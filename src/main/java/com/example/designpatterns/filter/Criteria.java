package com.example.designpatterns.filter;

import java.util.List;

//定义过滤器接口 这个接口的实现类都是不同功能的过滤器
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
