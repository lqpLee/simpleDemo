package org.lee.algorithm.array;

import org.junit.Before;
import org.junit.Test;

/**
 * 测试类
 * <p>
 * Created by liqiangpeng on 2017/11/10.
 */
public class TestClassDataArray {

    private ClassDataArray arr;

    @Before
    public void before() {
        int maxSize = 100;

        arr = new ClassDataArray(maxSize);

        arr.insert("qaz", "ads", 12);
        arr.insert("wsx", "zxc", 13);
        arr.insert("edc", "qwe", 14);
        arr.insert("rfv", "rty", 15);
        arr.insert("tgb", "fgh", 16);
        arr.insert("yhn", "vbn", 17);
        arr.insert("ujm", "yui", 18);
        arr.insert("iko", "hjk", 19);
        arr.insert("lpq", "nmk", 20);
        arr.insert("azw", "opl", 21);

        arr.dispalyA();
        System.out.println("=============before===========");
    }

    @Test
    public void testFind() {
        String searchKey = "azw";
        Person person = arr.find(searchKey);
        System.out.println(person);
    }

    @Test
    public void testDelete() {
        String searchKey1 = "wsx";
        String searchKey2 = "iko";
        boolean delete1 = arr.delete(searchKey1);
        boolean delete2 = arr.delete(searchKey2);
        System.out.println(delete1);
        System.out.println(delete2);
        arr.dispalyA();
    }
    
}
