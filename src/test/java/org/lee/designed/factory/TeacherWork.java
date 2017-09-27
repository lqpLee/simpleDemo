package org.lee.designed.factory;

/**
 * ConcreteProduct 实现 Product 接口。
 * <p>
 * Created by liqiangpeng on 2017/9/25.
 */
public class TeacherWork implements Work {
    @Override
    public void doWork() {
        System.out.println("老师审批作业!");
    }
}
