package org.lee.designed.abstractfactory;

/**
 * ConcreteProduct 定义一个将被相应的具体工厂创建的产品对象。 实现abstractProduct 接口。
 * <p>
 * Created by liqiangpeng on 2017/9/25.
 */
public class BlackDog implements IDog {
    @Override
    public void eat() {
        System.out.println("the black dog is eating!");
    }
}
