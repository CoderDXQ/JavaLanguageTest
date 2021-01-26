package com.example.javalanguaguetest.reflection.classtest.forNameTest1;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/27 1:19 上午
 */
public class User {

    private String name;
    private Integer age;
    private String address;

    static {
        System.out.println("static ---");
    }

    public User() {
        System.out.println("name=" + name);
        name = "haha";
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
