package org.lee;

import org.junit.Test;

/**
 * Created by liqiangpeng on 2017/11/21.
 */
public class TestOther {

    @Test
    public void testOther() {
        try {
            int i = 1 / 0;
            System.out.println("on exception keep running====");
        } catch (Exception e) {
            System.out.println("exception======");
            return;
        }
        System.out.println("out exception keep running=====");
    }
}
