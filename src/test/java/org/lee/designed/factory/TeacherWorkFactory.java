package org.lee.designed.factory;

/**
 * ConcreteCreator
 * 重定义工厂方法以返回一个 ConcreteProduct 实例。
 * <p>
 * Created by liqiangpeng on 2017/9/25.
 */
public class TeacherWorkFactory implements IWorkFactory {
    @Override
    public Work getWork() {
        return new TeacherWork();
    }
}
