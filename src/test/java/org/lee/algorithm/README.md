# java数据结构与算法（随记）
> 具体内容摘录自本地书籍[Java数据结构和算法](file:/Library/开发资料/文档/JAVA开发资料书/Java数据结构和算法.pdf) 

##综述
###数据结构的概述
* 数组  
	
		缺点：查找慢，删除慢，大小固定
		优点：插入快，如果知道下标，可以非常快地存取
* 有序数组	

		优点：比无序数组查找快	
		缺点：删除和插入慢，大小固定	
* 栈 

		优点：提供后进先出方式的存取
		缺点：存取其他项很慢
* 队列

		优点：提供先进先出的方式的存取
		缺点：存取其他项很慢
* 链表

		优点：插入快，删除快
		缺点：查找慢
* 二叉树

		优点：查找、插入、删除都快（如果树保持平衡）
		缺点：删除算法复杂
* 红-黑树

		优点：查找、插入、删除都快。树总是平衡的
		缺点：算法复杂
* 2-3-4树

		优点：查找、插入、删除都快。树总是平衡的。类似的树对磁盘存储有用
		缺点：算法复杂
* 哈希表

		优点：如果关键字已知则存取极快。插入快
		缺点：删除慢，如果不知道关键字则存取很慢，对存储空间使用不充分
* 堆

		优点：插入、删除快，对最大数据项的存取很快
		缺点：对其他数据项存取慢
* 图

		优点：对现实世界建模
		缺点：有些算法慢且复杂

	 **除了数组之外都可以被认为是抽象数据结构（ADT）**
	 
###小结
* 数据结构是指数据在计算机内存空间中或磁盘中的组织形式。
* 正确选择数据结构会使程序的效率大大提高。
* 数据结构的例子有数组、栈和链表。
* 算法是完成特定任务的过程。
* 在Java中，算法经常通过类的方法实现。
* 本书介绍的大部分数据结构和算法经常被用来建造数据库。
* 一些数据结构的用途是作为程序员的工具：它们帮助执行算法。
* 其他数据结构可以模拟现实世界中的情况，例如城市之间的电话线网
* 数据库是指由许多类似的记录组成的数据存储的集合。
* 一条记录经常表示现实世界中的一个事物，例如一名雇员或一个汽车零件。
* 一条记录被分成字段。每个字段都存储量由这个记录所描述事物的一条特性。
* 一个关键字是一条记录中的一个字段，通过它可以对数据执行许多操作。例如，人事记录可以通过LastName字段进行排序。

##数组
###Array

```java
package org.lee.algorithm;

import org.junit.Test;

/**
 * 数组
 * <p>
 * Created by liqiangpeng on 2017/11/7.
 */
public class ArrayApplet {

    /**
     * 创建数组
     */
    @Test
    public void testCreateArray() {

        int[] intArray;
        intArray = new int[100];

        /**
         * 等价于
         *
         *int[] intArray = new int[100];
         *
         *int intArray [] = new int[100];
         */
        System.out.println(intArray.length);//数组一但创建，数组的大小便不可变
    }

    /**
     * 访问数组数据项
     * <p>
     * 通过使用中括号中的下标数来访问
     */
    @Test
    public void testQueryArray() {

        int[] intArray;
        intArray = new int[100];

        int temp = intArray[3];//获取指定下表的元素
        intArray[7] = 66;//给指定下标元素插入值
        System.out.println(temp);
        System.out.println(intArray[7]);
    }

    /**
     * 初始化Array
     * <p>
     * 如果数组类型是对象，则创建好之后默认为null
     * 基本类型则有默认值(int默认为0)
     */
    @Test
    public void testInitArray() {

        int[] intArray = {0, 3, 6, 9, 10, 13, 24, 25, 36, 46};//大括号中的数据被称为数据列表。数组的大小由列表中的数据项的个数决定的。
        for (int i = 0; i <= intArray.length - 1; i++) {
            System.out.println(intArray[i]);
        }
    }

    /**
     * 举个栗子
     */
    @Test
    public void testArrayExample() {

        long[] arr;
        arr = new long[100];
        int nElems = 0;
        int j;
        long searchKey;
        //----------------------------------------------------
        arr[0] = 77;
        arr[1] = 99;
        arr[2] = 44;
        arr[3] = 55;
        arr[4] = 22;
        arr[5] = 88;
        arr[6] = 11;
        arr[7] = 00;
        arr[8] = 66;
        arr[9] = 33;
        nElems = 10;
        //----------------------------------------------------
        for (j = 0; j < nElems; j++)
            System.out.println(arr[j] + " ");
        //----------------------------------------------------
        searchKey = 66;
        for (j = 0; j < nElems; j++)
            if (arr[j] == searchKey)
                break;
        if (j == nElems)
            System.out.println("找不到" + searchKey);
        else
            System.out.println("找到" + searchKey);
        //----------------------------------------------------
        searchKey = 55;
        for (j = 0; j < nElems; j++)
            if (arr[j] == searchKey)
                break;
        for (int k = j; k < nElems; k++)
            arr[k] = arr[k + 1];
        nElems--;
        //----------------------------------------------------
        for (j = 0; j < nElems; j++)
            System.out.println(arr[j] + " ");
    }
}

```

###Ordered专题applet
_之所以排序，就说为了方便使用二分法查找数据_
####排序查找方式
* 线性查找

		缺省情况是该查找方式
![线性查找](/Users/liqiangpeng/Documents/java数据结构与算法所需图片/QQ20171108-103733@2x.png)
* 二分查找

		二分查找能体现出有序数组的好处。相对于线性查找要快很多，尤其对于大数组来说更为显著。
![猜数](/Users/liqiangpeng/Documents/java数据结构与算法所需图片/QQ20171108-104247@2x.png)

###有序数组的java代码
* 二分法查找

```java
package org.lee.algorithm.array;

import org.junit.Before;
import org.junit.Test;

/**
 * 有序数组的java代码
 * <p>
 * Created by liqiangpeng on 2017/11/8.
 */
public class TwoFindArray {

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
```
* OrdArray完整类

```java
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

```
```java
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

```
* 有序数组的优点

		使用有序数组会有什么好处呢？查找速度比无序数组快多了。
		不好的方面是在插入操作中由于所有靠后的数据都需要移动以腾开空间，所以速度较慢。
		有序数组和无序数组中的删除操作都很慢，这是因为数据项必须向前移动来填补已删除数据项的洞。
		有序数组在查找的频繁的情况下十分有用，但若是插入与删除较为频繁时，则无法高效工作。例如，有序数组适合于公司雇员的数据库。雇佣和解雇雇员同读取一个已存在雇员的有关信息或更改薪水、住址等信息相比，前两者是不经常发生的。
		另一方面，零售商店的存活清单不适用有序数组来实现，这是由于与频繁的进货和出货相应的插入与删除操作都会执行的很慢。
二分查找所需的比较次数：![二分查找所需的比较次数](/Users/liqiangpeng/Documents/java数据结构与算法所需图片/二分查找所需的比较次数.png)

###对数
_不会_
###存储对象
_上代码:_

```java
package org.lee.algorithm.array;

/**
 * 目标对象
 * <p>
 * Created by liqiangpeng on 2017/11/10.
 */
public class Person {

    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
```
```java
package org.lee.algorithm.array;

/**
 * 对象数组
 * <p>
 * Created by liqiangpeng on 2017/11/10.
 */
public class ClassDataArray {
    private Person[] a;
    private int nElems;

    /**
     * @param max 数组长度
     */
    public ClassDataArray(int max) {
        a = new Person[max];
        nElems = 0;
    }

    /**
     * @param searchName 关键字
     * @return 类
     */
    public Person find(String searchName) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j].getLastName().equals(searchName))
                break;
        if (j == nElems)
            return null;
        else
            return a[j];
    }

    /**
     * @param lastName  lastName
     * @param firstName firstName
     * @param age       age
     */
    public void insert(String lastName, String firstName, int age) {
        a[nElems] = new Person(lastName, firstName, age);
        nElems++;
    }

    public boolean delete(String searchName) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j].getLastName().equals(searchName))
                break;
        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    public void dispalyA() {
        for (int j = 0; j < nElems; j++)
            System.out.println(a[j].toString());
    }
}
```
```java
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

```

	
