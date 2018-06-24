package org.lee.algorithm.array;

import org.junit.Test;

/**
 * Created by liqiangpeng on 2017/11/8.
 */
public class TestOrdArray {

    @Test
    public void testFunction() {
        int maxSize = 100;
        OrdArray arr = new OrdArray(maxSize);
        arr.insert(2);
        arr.insert(1);
        arr.insert(3);
        arr.insert(5);
        arr.insert(4);
        arr.insert(6);
        arr.insert(7);
        arr.insert(8);
        arr.insert(9); 
        arr.insert(10);

        System.out.println();

        int searchKey = 6;
        if (arr.find(searchKey) != arr.size())
            System.out.println("找到" + searchKey);
        else
            System.out.println("找不到" + searchKey);
        arr.display();
        System.out.println("------------------------------");
        arr.delete(3);
        arr.display();
    }
}
