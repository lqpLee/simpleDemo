package org.lee.algorithm.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author liqp
 * @since 2020-07-08
 */
public class ShoppingCart {

    /**
     * 初始化商品列表
     */
    public ShoppingCart() {
        itemList = new ArrayList<>();
    }

    /**
     * 商品列表
     */
    private List<Item> itemList;

    /**
     * 支付方式
     */
    private PayStrategy payStrategy;

    /**
     * 添加商品
     *
     * @param item
     */
    public void addItem(Item item) {
        System.out.println("购物车添加商品 " + item.getName());
        itemList.add(item);
    }

    /**
     * 移除商品
     *
     * @param item
     */
    public void rmItem(Item item) {
        System.out.println("购物车移除商品" + item.getName());
        itemList.remove(item);
    }

    /**
     * 计算总金额
     *
     * @return
     */
    public int calTotal() {
        int amount = 0;
        for (Item item : itemList) {
            amount += item.getPrice();
        }
        return amount;
    }

    /**
     * 选择支付方式
     *
     * @param payStrategy
     */
    public void choosePayment(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    /**
     * 支付
     */
    public void pay() {
        int amount = calTotal();
        System.out.println("购物车计算总金额" + amount + "元");
        payStrategy.pay(amount);
    }


}
