package org.lee.algorithm.sort.maopao;

/**
 * 测试类
 * <p>
 * Created by liqiangpeng on 2018/1/4.
 */
public class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub arr;
        arr = new ArrayBub(maxSize);
        arr.insert(7);
        arr.insert(9);
        arr.insert(4);
        arr.insert(5);
        arr.insert(2);
        arr.insert(8);
        arr.insert(1);
        arr.insert(0);
        arr.insert(6);
        arr.insert(3);
        System.out.println("数组长度为：" + arr.size());
        System.out.print("排序前：");
        arr.dispaly();
        arr.bubbleSort();
        System.out.print("排序后：");
        arr.dispaly();
    }
}
