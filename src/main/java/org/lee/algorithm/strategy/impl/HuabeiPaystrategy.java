package org.lee.algorithm.strategy.impl;

import org.lee.algorithm.strategy.PayStrategy;

/**
 * <p>
 * 花呗支付
 * </p>
 *
 * @author liqp
 * @since 2020-07-08
 */
public class HuabeiPaystrategy implements PayStrategy {
    /**
     * 支付
     *
     * @param amount 金额
     */
    @Override
    public void pay(int amount) {
        System.out.println("使用花呗支付成功" + amount + "元");
    }
}
