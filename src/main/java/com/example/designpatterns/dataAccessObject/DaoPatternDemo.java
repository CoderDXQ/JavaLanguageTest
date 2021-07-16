package com.example.designpatterns.dataAccessObject;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/16 10:22 下午
 */
//基本上就是数据库的模式
public class DaoPatternDemo {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();

//        输出所有学生
        for (Student stu : studentDao.getAllstudents()) {
            System.out.println("Student: [RollNo : "
                    + stu.getRollNo() + ", Name : " + stu.getName() + " ]");
        }

//        更新学生
        Student stu1 = studentDao.getAllstudents().get(0);
        stu1.setName("XXX");
        studentDao.updateStudent(stu1);

//        获取学生
        stu1 = studentDao.getStudent(0);
        System.out.println("Student: [RollNo : "
                + stu1.getRollNo() + ", Name : " + stu1.getName() + " ]");
    }
}
