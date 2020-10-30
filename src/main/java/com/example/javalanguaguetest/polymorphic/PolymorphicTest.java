package com.example.javalanguaguetest.polymorphic;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/30 11:38 上午
 */
class Employee {
    private String name;
    private String address;
    private int number;

    public Employee(String name, String address, int number) {
        System.out.println("Employee的构造函数");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public void mailcheck() {
        System.out.println("邮寄支票给：" + this.name + " " + this.address);
    }

    public String toString() {
        return name + " " + address + " " + number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        address = newAddress;
    }

    public int getNumber() {
        return number;
    }
}

class Salary extends Employee {//继承父类 拥有父类的变量和方法
    private double salary;

    public Salary(String name, String address, int number, double salary) {
        super(name, address, number);//调用父类的构造方法
        setSalary(salary);
    }

    public void mailcheck() {//重写的方法
        System.out.println("Salary类的mailCheck方法");
        System.out.println("邮寄支票给： " + getName() + " ,工资为： " + salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        if (newSalary >= 0.0) {
            salary = newSalary;
        }
    }

    public double computerPay() {
        System.out.println("计算工资，付给：" + getName() + ": " + salary);
        return salary;
    }
}


public class PolymorphicTest {
    public static void main(String[] args) {
        Salary s = new Salary("员工A", "北京", 3, 3600.00);
        //子类可以转换成父类 转换之后不能使用父类的对象调用子类独有的方法
        Employee e = new Salary("员工B", "上海", 2, 2400);
        //父类不能转换成子类
        //Salary e = new Employee("员工B", "上海", 2);

/*        实例中，实例化了两个 Salary 对象：一个使用 Salary 引用 s，另一个使用 Employee 引用 e。
        当调用 s.mailCheck() 时，编译器在编译时会在 Salary 类中找到 mailCheck()，执行过程 JVM 就调用 Salary 类的 mailCheck()。
        因为 e 是 Employee 的引用，所以调用 e 的 mailCheck() 方法时，编译器会去 Employee 类查找 mailCheck() 方法 。
        在编译的时候，编译器使用 Employee 类中的 mailCheck() 方法验证该语句， 但是在运行的时候，Java虚拟机(JVM)调用的是 Salary 类中的 mailCheck() 方法。
        以上整个过程被称为虚拟方法调用，该方法被称为虚拟方法。

        Java中所有的方法都能以这种方式表现，因此，重写的方法能在运行时调用，不管编译的时候源代码中引用变量是什么数据类型。*/

        System.out.println("使用Salary的引用调用mailCheck方法");
        s.mailcheck();
        System.out.println("\n");
        System.out.println("使用Salary的引用调用computerPay方法");
        s.computerPay();
        System.out.println("\n");

        System.out.println("使用Employee的引用调用mailCheck方法");
        e.mailcheck();

//        System.out.println("\n");
//        System.out.println("使用Employee的引用调用computerPay方法");
        //Employee没有computerPay方法
        //e.computerPay();
//        System.out.println("\n");
    }
}
