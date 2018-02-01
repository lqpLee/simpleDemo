# java数据结构与算法（随记）
> 具体内容摘录自本地书籍[Java数据结构和算法](file:/Library/开发资料/文档/文档_java语言相关/Java数据结构和算法.pdf) 

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
###为什么不用数组表示一切？
		我们已经见到了许多关于数组的缺点。在一个无序数组中可以很快进行插入（O(1)时间），但是查找却要花费较慢的O(N)时间。在一个有序数组中可以查找的很快，用O(LogN)的时间，但插入却花费了O(N)的时间。对于这种数组而言，由于平均半数的数据项为了填补“空洞”必须移动，所以删除操作平均需要O(N)时间。
		如果有一种数据结构进行如何插入、删除和查找的操作都很快(理想的O(1)或者是O(LogN)时间)，那就好了。
		数组的另一个问题便是它们被new创建以后，大小就被固定住了。但通常在开始设计程序时并不知道会有多少数据将被放入数组中，所以需要猜它大小。如果猜的数过大，会使数组中的某些单元永远不会被填充而浪费空间。如果猜的过小，会发生数组益处，最好的情况下会向程序的用户发出警告信息，最坏的情况则会导致程序奔溃。
		java中有一个被称作向量(vector)类，使用起来很像数组，但是它可以扩展。这些附加功能是以效率作为代价的。当类用户使用类中的内部数组将要溢出时，插入算法创建一个大一点的数组，把旧数组中的内容复制到新数组中，然后插入新数据项。整个过程对于用户来说是不可见的。
###小结
* java中数组是对象，由new操作符创建。
* 无序数组可以提供快速的插入，但查找和删除较慢
* 将数组封装到类中可以保护数组不被随意更改。
* 类的接口由类用户可访问的方法（有时还有字段）组成。
* 类的接口被设计成使类用户的操作更加简单。
* 有序数组可以使用二分查找。
* 以B为底A的对数（大概）是在小于1之前用B除A的次数。
* 线性查找需要的时间与数组中数据项的个数成正比。
* 二分查找需要的时间与数组中数据项的个数的对数成正比。
* 大O表示法为比较算法的速度提供一种方便的方法。
* O(1)级时间的算法是最好的，O(logN)次之，O(N)为一般，O(N^2)最差。

##简单排序
###如何排序
	计算机程序无法像人一样通览所有数据。它只能根据计算机的“比较”操作原理，在同一时间内对两条数据进行比对。
	算法的这种“管视“将是一个反复出现的问题。[]()
	本章中的三个算法都包括如下两个步骤，这两步循环执行，直到全部数据有序为止：
		1.比较两个数据项。
		2.交换两个数据项，或复制其中一项。	
		但是每种算法具体实现的细节有所不同。	
###冒泡排序
	冒泡排序算法运行起来非常慢，但在概念上它是排序算法中最简单的。
* 冒泡排序java代码

_数组类：ArrayBub.java_

```java
package org.lee.algorithm.sort.maopao;

/**
 * 对象化
 * <p>
 * Created by liqiangpeng on 2018/1/4.
 */
public class ArrayBub {
    private long[] a;
    private int nElems;

    /**
     * 构造方法初始化
     *
     * @param max 数组最大长度
     */
    public ArrayBub(int max) {
        a = new long[max];
        nElems = 0;
    }

    /**
     * 给数组中添加值
     *
     * @param value
     */
    public void insert(long value) {
        a[nElems] = value;//将值插入到当前数组长度中
        nElems++;//长度+1
    }

    /**
     * 打印
     */
    public void dispaly() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    /**
     * 排序
     */
    public void bubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 1; out--)
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1])
                    swap(in, in + 1);
                //将以下注释打开可查看每次比对情况
                /*System.out.print("out===== " + out);
                System.out.print("     in===== " + in);
                System.out.println("   开始比较第" + in + "和第" + (in + 1) + "下标的值");
                dispaly();*/
            }
    }

    /**
     * 交换位置 [将交换独立出来不一定好，因为方法会增加额外的消耗，出入棧？]
     *
     * @param one val1
     * @param two val2
     */
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    /**
     * 数组长度
     *
     * @return 数组长度
     */
    public int size() {
        return nElems;
    }
}
```
_测试类：BubbleSortApp.java_

```java
package org.lee.algorithm.sort.maopao;

/**
 * 测试类
 * <p>
 * Created by liqiangpeng on 2018/1/4.
 */
public class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub arr;
        arr = new ArrayBub(maxSize);
        arr.insert(7);
        arr.insert(9);
        arr.insert(4);
        arr.insert(5);
        arr.insert(2);
        arr.insert(8);
        arr.insert(1);
        arr.insert(0);
        arr.insert(6);
        arr.insert(3);
        System.out.println("数组长度为：" + arr.size());
        arr.dispaly();
        arr.bubbleSort();
        arr.dispaly();
    }
}
```
_运行结果：_
		
	数组长度为：10
	排序前：7 9 4 5 2 8 1 0 6 3 
	out===== 9     in===== 0   开始比较第0和第1下标的值
	7 9 4 5 2 8 1 0 6 3 
	out===== 9     in===== 1   开始比较第1和第2下标的值
	7 4 9 5 2 8 1 0 6 3 
	out===== 9     in===== 2   开始比较第2和第3下标的值
	7 4 5 9 2 8 1 0 6 3 
	out===== 9     in===== 3   开始比较第3和第4下标的值
	7 4 5 2 9 8 1 0 6 3 
	out===== 9     in===== 4   开始比较第4和第5下标的值
	7 4 5 2 8 9 1 0 6 3 
	out===== 9     in===== 5   开始比较第5和第6下标的值
	7 4 5 2 8 1 9 0 6 3 
	out===== 9     in===== 6   开始比较第6和第7下标的值
	7 4 5 2 8 1 0 9 6 3 
	out===== 9     in===== 7   开始比较第7和第8下标的值
	7 4 5 2 8 1 0 6 9 3 
	out===== 9     in===== 8   开始比较第8和第9下标的值
	7 4 5 2 8 1 0 6 3 9 
	out===== 8     in===== 0   开始比较第0和第1下标的值
	4 7 5 2 8 1 0 6 3 9 
	out===== 8     in===== 1   开始比较第1和第2下标的值
	4 5 7 2 8 1 0 6 3 9 
	out===== 8     in===== 2   开始比较第2和第3下标的值
	4 5 2 7 8 1 0 6 3 9 
	out===== 8     in===== 3   开始比较第3和第4下标的值
	4 5 2 7 8 1 0 6 3 9 
	out===== 8     in===== 4   开始比较第4和第5下标的值
	4 5 2 7 1 8 0 6 3 9 
	out===== 8     in===== 5   开始比较第5和第6下标的值
	4 5 2 7 1 0 8 6 3 9 
	out===== 8     in===== 6   开始比较第6和第7下标的值
	4 5 2 7 1 0 6 8 3 9 
	out===== 8     in===== 7   开始比较第7和第8下标的值
	4 5 2 7 1 0 6 3 8 9 
	out===== 7     in===== 0   开始比较第0和第1下标的值
	4 5 2 7 1 0 6 3 8 9 
	out===== 7     in===== 1   开始比较第1和第2下标的值
	4 2 5 7 1 0 6 3 8 9 
	out===== 7     in===== 2   开始比较第2和第3下标的值
	4 2 5 7 1 0 6 3 8 9 
	out===== 7     in===== 3   开始比较第3和第4下标的值
	4 2 5 1 7 0 6 3 8 9 
	out===== 7     in===== 4   开始比较第4和第5下标的值
	4 2 5 1 0 7 6 3 8 9 
	out===== 7     in===== 5   开始比较第5和第6下标的值
	4 2 5 1 0 6 7 3 8 9 
	out===== 7     in===== 6   开始比较第6和第7下标的值
	4 2 5 1 0 6 3 7 8 9 
	out===== 6     in===== 0   开始比较第0和第1下标的值
	2 4 5 1 0 6 3 7 8 9 
	out===== 6     in===== 1   开始比较第1和第2下标的值
	2 4 5 1 0 6 3 7 8 9 
	out===== 6     in===== 2   开始比较第2和第3下标的值
	2 4 1 5 0 6 3 7 8 9 
	out===== 6     in===== 3   开始比较第3和第4下标的值
	2 4 1 0 5 6 3 7 8 9 
	out===== 6     in===== 4   开始比较第4和第5下标的值
	2 4 1 0 5 6 3 7 8 9 
	out===== 6     in===== 5   开始比较第5和第6下标的值
	2 4 1 0 5 3 6 7 8 9 
	out===== 5     in===== 0   开始比较第0和第1下标的值
	2 4 1 0 5 3 6 7 8 9 
	out===== 5     in===== 1   开始比较第1和第2下标的值
	2 1 4 0 5 3 6 7 8 9 
	out===== 5     in===== 2   开始比较第2和第3下标的值
	2 1 0 4 5 3 6 7 8 9 
	out===== 5     in===== 3   开始比较第3和第4下标的值
	2 1 0 4 5 3 6 7 8 9 
	out===== 5     in===== 4   开始比较第4和第5下标的值
	2 1 0 4 3 5 6 7 8 9 
	out===== 4     in===== 0   开始比较第0和第1下标的值
	1 2 0 4 3 5 6 7 8 9 
	out===== 4     in===== 1   开始比较第1和第2下标的值
	1 0 2 4 3 5 6 7 8 9 
	out===== 4     in===== 2   开始比较第2和第3下标的值
	1 0 2 4 3 5 6 7 8 9 
	out===== 4     in===== 3   开始比较第3和第4下标的值
	1 0 2 3 4 5 6 7 8 9 
	out===== 3     in===== 0   开始比较第0和第1下标的值
	0 1 2 3 4 5 6 7 8 9 
	out===== 3     in===== 1   开始比较第1和第2下标的值
	0 1 2 3 4 5 6 7 8 9 
	out===== 3     in===== 2   开始比较第2和第3下标的值
	0 1 2 3 4 5 6 7 8 9 
	out===== 2     in===== 0   开始比较第0和第1下标的值
	0 1 2 3 4 5 6 7 8 9 
	out===== 2     in===== 1   开始比较第1和第2下标的值
	0 1 2 3 4 5 6 7 8 9 
	排序后：0 1 2 3 4 5 6 7 8 9 
		
* 不变性

		在许多算法中，有些条件在算法执行时是不变的。这些条件被称为不变性。
		在bubbleSort.java中，不变性是指out右边的所有数据项为有序（在循环过程中，每次外围for循环结束一次即out--，out所在下标的右边都是有序的；也就是说排序是把最大的放到最后，再把第二大的放到倒数第二，以此类推）。在算法的整个运行过程这个条件始终为真。

* 冒泡排序的效率

		第一趟排序进行了9次比较，第二趟进行了8次，如此类推，直到最后一趟进行了一次比较。
		对于十个数据项，就是9+8+7+6+5+4+3+2+1=45
		一般来说，数组中有N个数据项，则第一趟排序中有N-1次比较，第二趟中有N-2次，如此类推。这种序列的求和公式：(N-1)+(N-2)+(N-3)+...+1=N*(N-1)/2
		当N为10时，10*9/2=45
		这样，算法约做了N^2/2次比较（忽略减1，不会有很大差别，特别是N很大的时候）
		因为有判断【前一个数据大于后一个数据】时才交换，所以交换的次数少于比较的次数。如果数据是随机的，那么大概有一半的数据需要交换，则交换的次数为N^2/4。（在最坏的情况下，即数据逆序时，每次比较都需要交换）。

###选择排序
	冒泡排序，有序的数据都从右边开始，而选择排序从左边开始。
* 详细描述

		从最左边开始。先记录最左端的数据，并记录下标（一般存储在内存）。于是开始用下一条数据和记录的数据进行比较。如果这条数据更小，则将记录改为这条数据下标。继续走下去，每条数据都和记录中的数据进行比较，发现有更小的数据时，更新记录。
		当做完这些事时，记录中就会是最小的数据，将这条数据与最左边的数据进行交换。
		现在，已经对第一条数据排好序了，期间做了N-1次比较，但是只进行了一次交换。
		在接下来的排序中，所做的事情是一摸一样的，只是需要忽略最左边的数据，因为它已经排好序了。因此算法的第二趟排序从1位置开始。每排完一次序，就多一个有序数据，并被安排在左边，下次在找新的最小值时就可以少考虑一条数据。
		
* 选择排序的java代码

_数组类：ArraySel.java_

```java
package org.lee.algorithm.sort.xuanze;

/**
 * Created by liqiangpeng on 2018/1/4.
 */
public class ArraySel {
    private long[] a;
    private int nElems;

    /**
     * 构造方法初始化
     *
     * @param max 数组最大长度
     */
    public ArraySel(int max) {
        a = new long[max];
        nElems = 0;
    }

    /**
     * 给数组中添加值
     *
     * @param value
     */
    public void insert(long value) {
        a[nElems] = value;//将值插入到当前数组长度中
        nElems++;//长度+1
    }

    /**
     * 打印
     */
    public void dispaly() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    /**
     * 排序
     */
    public void selectionSort() {
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) {
            min = out;//当每次循环结束时，已经确定了out所在右边已经排好序，记录最小数，下次循环从out+1开始，忽略前面已排好序的数据
            for (in = out + 1; in < nElems; in++)//从out右边开始
                if (a[in] < a[min])
                    min = in;//只要发现最小的数据，记录下来
            swap(out, min);//跟out交换
            //将以下注释打开可查看详细交换信息
            /*System.out.print("out=====" + out);
            System.out.print("  in======" + in);
            System.out.println("  min======" + min);
            dispaly();*/
        }
    }

    /**
     * 交换位置 [将交换独立出来不一定好，因为方法会增加额外的消耗，出入棧？]
     *
     * @param one val1
     * @param two val2
     */
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    /**
     * 数组长度
     *
     * @return 数组长度
     */
    public int size() {
        return nElems;
    }
}

```
_测试类:SelectSortApp.java_

```java
package org.lee.algorithm.sort.xuanze;

/**
 * 测试类
 * <p>
 * Created by liqiangpeng on 2018/1/4.
 */
public class SelectSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArraySel arr = new ArraySel(maxSize);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        System.out.println("数组长度为：" + arr.size());
        System.out.print("排序前：");
        arr.dispaly();
        arr.selectionSort();
        System.out.print("排序后：");
        arr.dispaly();
    }
}
```
_执行结果:_
	
	数组长度为：10
	排序前：77 99 44 55 22 88 11 0 66 33 
	out=====0  in======10  min======7
	0 99 44 55 22 88 11 77 66 33 
	out=====1  in======10  min======6
	0 11 44 55 22 88 99 77 66 33 
	out=====2  in======10  min======4
	0 11 22 55 44 88 99 77 66 33 
	out=====3  in======10  min======9
	0 11 22 33 44 88 99 77 66 55 
	out=====4  in======10  min======4
	0 11 22 33 44 88 99 77 66 55 
	out=====5  in======10  min======9
	0 11 22 33 44 55 99 77 66 88 
	out=====6  in======10  min======8
	0 11 22 33 44 55 66 77 99 88 
	out=====7  in======10  min======7
	0 11 22 33 44 55 66 77 99 88 
	out=====8  in======10  min======9
	0 11 22 33 44 55 66 77 88 99 
	排序后：0 11 22 33 44 55 66 77 88 99

* 不变性
		
		在selectSort.java程序中，小标小于out的位置的数据总是有序的。
* 选择排序的效率

		选择排序和冒泡排序执行了相同次数的比较：N*(N-1)/2。对于10个数据项，需要45次比较。
		然而，10个数据项只需要少于10次交换。对于100个数据项，需要4950次比较，但只进行了不到100次的交换。N值很大时，比较的次数是主要的。

###插入排序

	﻿$$ r=2^s $$