package org.lee.algorithm.strategy;

/**
 * <p>
 * 商品类
 * </p>
 *
 * @author liqp
 * @since 2020-07-08
 */
public class Item {

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


}
