package com.example.javalanguaguetest.clone;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/15 8:41 下午
 */
public class CloneTest {
    public static void main(String[] args) {

        try {

            Employee original = new Employee("John Q.Public", 50000);
            System.out.println("original=" + original);
            original.setHireday(2000, 1, 1);
            System.out.println("original=" + original);
            System.out.println();

            Employee copy = original.clone();
            System.out.println();
            System.out.println("copy=" + copy);

            //对copy进行修改
            copy.raiseSalary(10);
            copy.setHireday(2002, 12, 31);

            System.out.println();
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);

            System.out.println();
            System.out.println(original.hashCode());
            System.out.println(copy.hashCode());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
