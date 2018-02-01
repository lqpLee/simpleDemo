package org.lee.generic;

import org.junit.Test;

/**
 * Created by liqiangpeng on 2018/2/1.
 */
public class GenericTest {
    public <T> void printMsg( T... args){
        for(T t : args){
            System.out.println("泛型测试 t is " + t);
        }
    }

    @Test
    public void testMsg(){
        printMsg("111",222,"aaaa","2323.4",55.55);
    }
}
