package com.example.designpatterns.dataAccessObject;

import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/16 10:19 下午
 */
//数据访问对象接口
public interface StudentDao {
    public List<Student> getAllstudents();

    public Student getStudent(int rollNo);

    public void updateStudent(Student student);

    public void deleteStudent(Student student);
}
