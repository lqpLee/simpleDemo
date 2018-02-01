package org.lee.algorithm.sort.charu;


/**
 * 测试类
 * <p>
 * Created by liqiangpeng on 2018/1/4.
 */
public class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        InsertSort arr = new InsertSort(maxSize);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        System.out.println("数组长度为：" + arr.size());
        System.out.print("排序前：");
        arr.dispaly();
        arr.insertionSort();
        System.out.print("排序后：");
        arr.dispaly();
    }
}
