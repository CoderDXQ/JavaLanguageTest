package com.example.javalanguaguetest.reflection.objectanalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/13 3:11 下午
 */
//类分析器 查看传进来的类的所有的非静态成员变量，无论是可见的还是不可见的 同时查看类的继承关系
public class ObjectAnalyzer {
    //构造方法会把squares的值赋进来
    private ArrayList<Object> visited = new ArrayList<>();

    //重写toString()方法 这个方法最终会返回一个字符串 这个方法会被手动实现的额递归调用
    public String toString(Object obj) {
        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);

        //获得传入的变量的具体类型
        Class cl = obj.getClass();
        //String变量不需要重写toString()方法
        if (cl == String.class) return (String) obj;

        //判断cl是否是ArrayList的元素
        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) r += ",";
                Object val = Array.get(obj, i);

                //getComponentType()返回数组的组件类型 如果该类不表示数组返回null isPrimitive()判断是否是原始类型 原始类型没有toString()方法
                if (cl.getComponentType().isPrimitive()) r += val;
                //进行递归调用 Object类不是原始类型
                else r += toString(val);
            }
            return r + "}";
        }

        String r = cl.getName();
        do {
            r += "[";
            //获取cl所有的字段
            Field[] fields = cl.getDeclaredFields();
            //设置变量的可达性 允许访问该字段
            AccessibleObject.setAccessible(fields, true);

            //访问某个变量的所有字段
            for (Field f : fields) {
                //判断字段的修饰符是否是非静态 只有值字段是非静态的 其他字段一般都是静态的
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.endsWith("[")) r += ",";
                    //获得字段的名字
                    r += f.getName() + "=";

                    try {
                        //获取变量类型
                        Class t = f.getType();
                        //获取值
                        Object val = f.get(obj);
                        if (t.isPrimitive()) r += val;
                        //进行递归调用
                        else r += toString(val);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            //令该类赋值为父类类型 Object类的父类就是null
            // ArrayList->int->Number->Object->null
            //ArrayList的父类是AbstractList,ArrayList只是实现类
            cl = cl.getSuperclass();
        } while (cl != null);

        return r;
    }
}
