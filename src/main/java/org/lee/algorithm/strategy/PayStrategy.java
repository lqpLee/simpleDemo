package org.lee.algorithm.strategy;

/**
 * 支付的接口
 */
public interface PayStrategy {
    /**
     * 支付
     *
     * @param amount 金额
     */
    void pay(int amount);
}
