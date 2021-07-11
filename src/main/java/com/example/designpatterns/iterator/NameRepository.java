package com.example.designpatterns.iterator;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/11 11:47 下午
 */
//实现一个容器 容器中包装一个指针(迭代器)
public class NameRepository implements Container {
    public String[] names = {"Robert", "John", "Julie", "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
//            调用自身的方法
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
