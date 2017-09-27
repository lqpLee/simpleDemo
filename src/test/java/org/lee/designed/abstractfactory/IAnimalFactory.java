package org.lee.designed.abstractfactory;

/**
 * .AbstractFactory 声明一个创建抽象产品对象的操作接口。
 * <p>
 * Created by liqiangpeng on 2017/9/25.
 */
public interface IAnimalFactory {

    ICat createCat();

    IDog createDog();
}
