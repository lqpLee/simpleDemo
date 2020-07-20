package org.lee.algorithm.strategy;

import org.lee.algorithm.strategy.impl.HuabeiPaystrategy;
import org.lee.algorithm.strategy.impl.YinhangPayStrategy;

/**
 * <p>
 * 订单支付-策略模式 测试类
 * </p>
 *
 * @author liqp
 * @since 2020-07-08
 */
public class PayStrategyTest {

    public static void main(String[] args) {
        //新建购物车
        ShoppingCart shoppingCart = new ShoppingCart();
        //添加商品
        Item huaweiMobile = new Item("华为手机", 6488);
        Item xiaomiRouter = new Item("小米路由器", 249);
        shoppingCart.addItem(huaweiMobile);
        shoppingCart.addItem(xiaomiRouter);
        //选择支付方式
        shoppingCart.choosePayment(new YinhangPayStrategy());//面向接口编程
        //移除商品
        shoppingCart.rmItem(huaweiMobile);
        //支付
        shoppingCart.pay();
    }
}
