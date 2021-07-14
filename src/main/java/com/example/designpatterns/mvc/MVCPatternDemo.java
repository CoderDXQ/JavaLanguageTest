package com.example.designpatterns.mvc;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/14 11:19 下午
 */
public class MVCPatternDemo {
    public static void main(String[] args) {
//        假装从数据库获取学生记录
        Student model = retrieveStudentFromDatabase();
//        创建视图 把学生的详细信息输出到控制台
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

//        更新模型数据
        controller.setStudentName("John");

        controller.updateView();

    }

    //    模拟数据库
    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}
