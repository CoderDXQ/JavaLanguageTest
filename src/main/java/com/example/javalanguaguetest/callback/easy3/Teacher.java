package com.example.javalanguaguetest.callback.easy3;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/30 9:35 下午
 */
public class Teacher implements CallBack {

    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void askQuestion(final String question) {
        System.out.println("Teacher ask a question:" + question);
//        回调student的方法，之所以能回调是因为在这个类里加载了student这个类的一个实例
//        这里的this是指Teacher这个类的一个实例 这个类里有重写的tellAnswer()方法  用CallBack这个类来接
        student.resolveQuestion(this, question);
        System.out.println("Teacher: do something else");
    }

    //    重写回调接口里定义的方法
    @Override
    public void tellAnswer(int answer) {
        System.out.println("your answer is: " + answer);
    }
}
