package com.example.writtenexaminationandinterview.proxy.staticproxy;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 2:04 下午
 */
public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }


    @Override
    public void save() {
//        扩展了额外的功能
        System.out.println("开启事务");
        target.save();
        System.out.println("提交事务");
    }
}
