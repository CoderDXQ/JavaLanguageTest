package com.example.designpatterns.filter;

import java.util.List;
//交运算
public class AndCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
//        过滤第一次
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
//        过滤第二次
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
