package org.lee.algorithm.array;

import org.junit.Before;
import org.junit.Test;

/**
 * 有序数组的java代码
 * <p>
 * Created by liqiangpeng on 2017/11/8.
 */
public class TestTwoFindArray {

    private long[] arr;//数组
    private int nElems;//数组数量

    /**
     * 初始化
     */
    @Before
    public void before() {
        arr = new long[100];
        //插入元素
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        arr[5] = 6;
        arr[6] = 7;
        arr[7] = 8;
        arr[8] = 9;
        arr[9] = 10;
        nElems = 10;
    }

    /**
     * 测试二分法查找
     */
    @Test
    public void testTwoFind() {
        int searchKey = 6;//search key
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curInt;
        while (true) {
            curInt = (lowerBound + upperBound) / 2;
            if (arr[curInt] == searchKey) {
                System.out.println(curInt);//找到了
                break;
            } else if (lowerBound > upperBound) {
                System.out.println(nElems);//找不到
                break;
            } else {
                if (arr[curInt] < searchKey)
                    lowerBound = curInt + 1;//太小。在大的那一部分
                else
                    upperBound = curInt - 1;//太大。在小的那一部分
            }
        }
    }
}
