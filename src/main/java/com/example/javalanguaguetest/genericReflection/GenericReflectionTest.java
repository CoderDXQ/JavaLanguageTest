package com.example.javalanguaguetest.genericReflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/16 10:33 下午
 */
public class GenericReflectionTest {

    //可以输入com.example.javalanguaguetest.genericReflection.Pair或者java.util.Collections
    public static void main(String[] args) {
        String name;
        if (args.length > 0) name = args[0];
        else {
            try (Scanner in = new Scanner(System.in)) {
                System.out.println("Enter class name (e.g. java.util.Collections): ");
                name = in.next();
            }
        }

        try {
            //获取类
            Class<?> cl = Class.forName(name);
            printClass(cl);
            //遍历类里声明的方法 不管是不是public，只要声明了都可以（构造方法等方法除外）
            for (Method m : cl.getDeclaredMethods())
                printMethdod(m);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printClass(Class<?> cl) {
        System.out.print(cl);
        //获取泛型变量参数
        printTypes(cl.getTypeParameters(), "<", ", ", ">", true);
        //获取泛型继承超类
        Type sc = cl.getGenericSuperclass();
        if (sc != null) {
            System.out.print(" extends ");
            printType(sc, false);
        }
        //获取这个类型的接口的泛型类型
        printTypes(cl.getGenericInterfaces(), " implements ", ", ", "", false);
        System.out.println();
    }

    public static void printMethdod(Method m) {
        String name = m.getName();
        //打印方法的修饰符
        System.out.print(Modifier.toString(m.getModifiers()));
        System.out.print(" ");
        //打印方法的变量参数
        printTypes(m.getTypeParameters(), "<", ", ", ">", true);

        //获得泛型返回类型
        printType(m.getGenericReturnType(), false);
        System.out.print(" ");
        System.out.print(name);
        System.out.print("(");
        //获得泛型参数类型
        printTypes(m.getGenericParameterTypes(), "", ", ", "", false);
        System.out.println(")");
    }

    public static void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition) {
        if (pre.equals(" extends ") && Arrays.equals(types, new Type[]{Object.class}))
            return;
        if (types.length > 0) System.out.print(pre);

        for (int i = 0; i < types.length; i++) {
            if (i > 0) System.out.print(sep);
            printType(types[i], isDefinition);
        }
        if (types.length > 0) System.out.print(suf);
    }

    public static void printType(Type type, boolean isDefinition) {
        //判断参数类型然后输出
        if (type instanceof Class) {
            Class<?> t = (Class<?>) type;
            System.out.print(t.getName());
        } else if (type instanceof TypeVariable) {
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.print(t.getName());
            if (isDefinition)
                printTypes(t.getBounds(), " extends ", " & ", "", false);
        } else if (type instanceof WildcardType) {
            WildcardType t = (WildcardType) type;
            System.out.print("?");
            printTypes(t.getUpperBounds(), " extends ", " & ", "", false);
            printTypes(t.getLowerBounds(), " super ", " & ", "", false);

        } else if (type instanceof ParameterizedType) {
            ParameterizedType t = (ParameterizedType) type;
            Type owner = t.getOwnerType();
            if (owner != null) {
                printType(owner, false);
                System.out.print(".");
            }
            printType(t.getRawType(), false);
            printTypes(t.getActualTypeArguments(), "<", ", ", ">", false);

        } else if (type instanceof GenericArrayType) {
            GenericArrayType t = (GenericArrayType) type;
            System.out.print("");
            printType(t.getGenericComponentType(), isDefinition);
            System.out.print("[]");
        }
    }
}
