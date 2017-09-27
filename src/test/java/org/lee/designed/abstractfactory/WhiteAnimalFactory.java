package org.lee.designed.abstractfactory;

/**
 * ConcreteFactory 实现创建具体产品对象的操作。
 * <p>
 * Created by liqiangpeng on 2017/9/25.
 */
public class WhiteAnimalFactory implements IAnimalFactory {
    @Override
    public ICat createCat() {
        return new WhiteCat();
    }

    @Override
    public IDog createDog() {
        return new WhiteDog();
    }
}
