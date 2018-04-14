package org.lee.reflex;

import java.lang.reflect.Constructor;

/**
 * 获取运行时期，一个类的字节码文件对象
 * 对象的描述类 java.lang.Class
 * <p>
 * 获取一个类的字节码文件对象有三种方式：
 * 第一种：使用对象获取
 * 使用对象的方法getClass获取
 * 第二种：使用类的静态属性class获取
 * 每一个类都有一个静态属性class 获取类的字节码文件对象  类名.class
 * 第三种：使用Class类的静态方法forName(字符串类名)
 * <p>
 * <p>
 * Created by liqiangpeng on 2017/6/13.
 */
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {

        Class c = Class.forName("org.lee.reflex.Person");
        Constructor[] cons = c.getConstructors();

        new Thread(() -> System.out.println(Thread.currentThread().getName() + "测试多线程使用lamdba实现！")).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("");
            }
        });

        for (Constructor con : cons) System.out.println(con);
    }


}


























