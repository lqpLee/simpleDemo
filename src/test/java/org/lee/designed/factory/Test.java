package org.lee.designed.factory;

/**
 * 定义一个用于创建对象的接口，让子类决定实例化哪一个类。FactoryMethod 使一个类的实例*延迟到其子类
 * <p>
 * 提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 * 适用性
 * 1.当一个类不知道它所必须创建的对象的类的时候。
 * 2.当一个类希望由它的子类来指定它所创建的对象的时候。
 * 3.当*将创建对象的职责委托给多个帮助*类中的某一个，并且*希望将哪一个 帮助子类是代理者这一信息局部化的时候。
 * <p>
 * <p>
 * Created by liqiangpeng on 2017/9/25.
 */
public class Test {

    public static void main(String[] args) {
        IWorkFactory studentWorkFactory = new StudentWorkFactory();
        studentWorkFactory.getWork().doWork();

        IWorkFactory teacherWorkFactory = new TeacherWorkFactory();
        teacherWorkFactory.getWork().doWork();
    }
}
