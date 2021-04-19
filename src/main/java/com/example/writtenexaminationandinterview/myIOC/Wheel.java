package com.example.writtenexaminationandinterview.myIOC;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/19 10:30 下午
 */
//定义实体类
public class Wheel {

    private String brand;
    private String specification;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "brand='" + brand + '\'' +
                ", specification='" + specification + '\'' +
                '}';
    }

}
