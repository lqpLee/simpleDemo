package org.lee.designed.factory;

/**
 * Creator
 * 声明工厂方法，该方法返回一个 Product 类型的对象*
 * Creator 也可以定义一个工厂方法的缺省实现，它返回一个缺省的
 * ConcreteProduct 对象。 可以调用工厂方法以创建一个 Product 对象。
 * <p>
 * Created by liqiangpeng on 2017/9/25.
 */
public interface IWorkFactory {

    Work getWork();
}
