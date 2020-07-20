package org.lee.algorithm.strategy.impl;

import org.lee.algorithm.strategy.PayStrategy;

/**
 * <p>
 * 银行卡支付
 * </p>
 *
 * @author liqp
 * @since 2020-07-08
 */
public class YinhangPayStrategy implements PayStrategy {
    /**
     * 银行卡支付
     *
     * @param amount 金额
     */
    @Override
    public void pay(int amount) {
        System.out.println("使用银行卡支付成功" + amount + "元");
    }
}
