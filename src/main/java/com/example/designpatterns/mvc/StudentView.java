package com.example.designpatterns.mvc;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/14 11:10 下午
 */
//view 一般用于数据可视化 也就是对数据进行处理
public class StudentView {
    //    假装进行复杂的数据处理和可视化
    public void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}
