package org.lee;

import org.junit.Test;

/**
 * Created by liqiangpeng on 2017/11/21.
 */
public class TestOther {

    @Test
    public void testOther1() {
        try {
            int i = 1 / 0;
            System.out.println("on exception keep running====");
        } catch (Exception e) {
            System.out.println("exception======");
            return;
        }
        System.out.println("out exception keep running=====");
    }

    @Test
    public void testOther2() {
        Integer i1 = 50;
        Integer i2 = 50;
        System.out.println(i1 == i2);
    }

    @Test
    public void testMath() {
        int a = 1, b = 2;
        a = a ^ b;
        b = b ^ a;
        a = b ^ a;
        System.out.println(a);
        System.out.println(b);
    }
}
