package org.lee.algorithm.array;

import org.junit.Test;

/**
 * 数组
 * <p>
 * Created by liqiangpeng on 2017/11/7.
 */
public class TestArrayApplet {

    /**
     * 创建数组
     */
    @Test
    public void testCreateArray() {

        int[] intArray;
        intArray = new int[100];

        /**
         * 等价于
         *
         *
         *int[] intArray = new int[100];
         *
         *int intArray [] = new int[100];
         */
        System.out.println(intArray.length);//数组一但创建，数组的大小便不可变
    }


    /**
     * 访问数组数据项
     * <p>
     * 通过使用中括号中的下标数来访问
     */
    @Test
    public void testQueryArray() {

        int[] intArray;
        intArray = new int[100];

        int temp = intArray[3];//获取指定下表的元素
        intArray[7] = 66;//给指定下标元素插入值
        System.out.println(temp);
        System.out.println(intArray[7]);
    }

    /**
     * 初始化Array
     * <p>
     * 如果数组类型是对象，则创建好之后默认为null
     * 基本类型则有默认值(int默认为0)
     */
    @Test
    public void testInitArray() {

        int[] intArray = {0, 3, 6, 9, 10, 13, 24, 25, 36, 46};//大括号中的数据被称为数据列表。数组的大小由列表中的数据项的个数决定的。
        for (int i = 0; i <= intArray.length - 1; i++) {
            System.out.println(intArray[i]);
        }
    }

    /**
     * 举个栗子
     * <p>
     * 注：该程序为正常的数组操作，在多个语言中具有相似性。
     * 但是在java中一些数据（字段或者成员变量）都会隐藏到具体的对象中，并对外提供访问接口（方法）
     * 根据低耦合高内聚的原则，应该对具体的 创建、初始化、插入、删除、访问 等交由对象来管理。
     * 而使用者不需要关心具体的实现甚至数据结构。
     */
    @Test
    public void testArrayExample() {

        long[] arr;
        arr = new long[100];
        int nElems = 0;
        int j;
        long searchKey;
        //----------------------------------------------------
        //插入元素
        arr[0] = 77;
        arr[1] = 99;
        arr[2] = 44;
        arr[3] = 55;
        arr[4] = 22;
        arr[5] = 88;
        arr[6] = 11;
        arr[7] = 00;
        arr[8] = 66;
        arr[9] = 33;
        nElems = 10;
        //----------------------------------------------------
        for (j = 0; j < nElems; j++)
            System.out.println(arr[j] + " ");
        //----------------------------------------------------
        searchKey = 66;//查找该元素
        for (j = 0; j < nElems; j++)
            if (arr[j] == searchKey)
                break;
        if (j == nElems)
            System.out.println("找不到" + searchKey);
        else
            System.out.println("找到" + searchKey);
        //----------------------------------------------------
        searchKey = 55;//移除该元素
        for (j = 0; j < nElems; j++)
            if (arr[j] == searchKey)
                break;
        for (int k = j; k < nElems; k++)
            arr[k] = arr[k + 1];
        nElems--;
        //----------------------------------------------------
        for (j = 0; j < nElems; j++)
            System.out.println(arr[j] + " ");
    }
}
