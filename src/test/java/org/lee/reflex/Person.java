package org.lee.reflex;

/**
 * 类元素加载顺序
 * <p>
 * Created by liqiangpeng on 2017/6/13.
 */
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(int age) {
    }

    static {
        System.out.println("静态代码块儿");
    }


    public void show() {
    }

    public void show(int x, double b, String s) {
    }

    private void function() {
    }
}
