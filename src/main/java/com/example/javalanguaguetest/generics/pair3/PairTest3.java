package com.example.javalanguaguetest.generics.pair3;


/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/16 4:35 下午
 */
public class PairTest3 {
    public static void main(String[] args) {
        Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
        Manager cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 18);
        Pair<Manager> buddies = new Pair<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);

        Manager[] managers = {ceo, cfo};

        Pair<Employee> result = new Pair<>();
        minmaxBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + ",second: " + result.getSecond().getName());
        maxminBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + ",second: " + result.getSecond().getName());
    }

    //？是通配符
    //？和Employee绑定，绑定的对象可以是类也可以是接口  限定Employee类和该类的子类
    public static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    //通配符的超类型限定
    //？和Manager的超类绑定，绑定的对象可以是类也可以是接口  限定为Manager的所有超类
    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
        if (a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus()) min = a[i];
            if (max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    //通配符的超类型限定
    //？和Manager的超类绑定，绑定的对象可以是类也可以是接口  限定为Manager的所有超类
    public static void maxminBonus(Manager[] a, Pair<? super Manager> result) {
        minmaxBonus(a, result);
        PairAlg.swapHelper(result);
    }
}

class PairAlg {

    //？是通配符
    //无限定通配符 非常脆弱
    public static boolean hasNulls(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p) {
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
