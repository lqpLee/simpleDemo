package org.lee.algorithm.array;

import org.junit.Test;

/**
 * 完整数组操作
 * <p>
 * Created by liqiangpeng on 2017/11/8.
 */
public class OrdArray {

    private long[] a;
    private int nElems;

    /**
     * 创建空数组
     *
     * @param max 数组最大长度
     */
    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    /**
     * 长度
     *
     * @return 长度
     */
    public int size() {
        return nElems;
    }

    /**
     * 查找
     *
     * @param searchKey 查找key
     * @return 下标
     */
    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curInt;
        while (true) {
            curInt = (lowerBound + upperBound) / 2;
            if (a[curInt] == searchKey) {
                return curInt;
            } else if (lowerBound > upperBound) {
                return nElems;
            } else {
                if (a[curInt] < searchKey)
                    lowerBound = curInt + 1;//太小。在大的那一部分
                else
                    upperBound = curInt - 1;//太大。在小的那一部分
            }
        }
    }

    /**
     * 插入
     *
     * @param value 值
     */
    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] > value)
                break;
        for (int k = nElems; k > j; k--)
            a[k] = a[k - 1];
        a[j] = value;
        nElems++;
    }

    /**
     * 移除
     *
     * @param value 值
     * @return 成功与否
     */
    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    /**
     * 遍历
     */
    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.println(a[j] + " ");
    }



}
