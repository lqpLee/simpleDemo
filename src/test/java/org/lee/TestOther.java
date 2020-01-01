package org.lee;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
        String s  = "asdfaaaaaabcd123";
        int n = s.length();
        int maxNum = 0, i = 0, j = 0 ;
        Set<Character> set = new HashSet<>();
        while(i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                maxNum = Math.max(maxNum, j - i);
                System.out.println(set);
            } else {
                set.remove(s.charAt(i++));
                System.out.println(set);
            }
        }
        System.out.println(maxNum);
    }
}
