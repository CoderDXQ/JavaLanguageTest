package com.example.javalanguaguetest.generics.pair3;


/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/12 8:15 下午
 */
public class Manager extends Employee {
    private double bonus;

    //不能使用IDEA自动生成的 重写一个
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getBonus() {
        return bonus;
    }

    //重写父类方法
    public double getSalary() {
        //调用父类方法
        double baseSalary = super.getSalary();
        return bonus + baseSalary;
    }

    //不能使用IDEA自动生成的 重写一个
    public void setBonus(double b) {
        bonus = b;
    }

    public int hashCode() {
        //相比于父类增加了一个字段 所有重写父类的哈希方法
        return super.hashCode() + 17 * new Double(bonus).hashCode();
    }

    public String toString() {
        //重写父类方法  在重写过程中调用父类方法
        return super.toString() + "[bonus=" + bonus + "]";
    }

}
