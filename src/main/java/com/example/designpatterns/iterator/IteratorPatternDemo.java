package com.example.designpatterns.iterator;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/11 11:52 下午
 */
public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        for (Iterator iter = nameRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}
