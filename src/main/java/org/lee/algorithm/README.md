java数据结构与算法（随记）

> 具体内容摘录自书籍[Java数据结构和算法](../../../../../../data/Java数据结构和算法.pdf) 

> 代码[git地址](https://github.com/lqpLee/simpleDemo.git)

[TOC]

## 综述

### 数据结构的概述

- 数组  

  缺点：查找慢，删除慢，大小固定

  ```
  优点：插入快，如果知道下标，可以非常快地存取
  ```

  - 有序数组

    优点：比无序数组查找快	
    缺点：删除和插入慢，大小固定	

- 栈 

  优点：提供后进先出方式的存取

  ```
  缺点：存取其他项很慢
  ```

- 队列

  优点：提供先进先出的方式的存取

  ```
  缺点：存取其他项很慢
  ```

- 链表

  优点：插入快，删除快

  ```
  缺点：查找慢
  ```

- 二叉树

  优点：查找、插入、删除都快（如果树保持平衡）

  ```
  缺点：删除算法复杂
  ```

- 红-黑树

  优点：查找、插入、删除都快。树总是平衡的

  ```
  缺点：算法复杂
  ```

- 2-3-4树

  优点：查找、插入、删除都快。树总是平衡的。类似的树对磁盘存储有用

  ```
  缺点：算法复杂
  ```

- 哈希表

  优点：如果关键字已知则存取极快。插入快

  ```
  缺点：删除慢，如果不知道关键字则存取很慢，对存储空间使用不充分
  ```

- 堆

  优点：插入、删除快，对最大数据项的存取很快

  ```
  缺点：对其他数据项存取慢
  ```

- 图

  优点：对现实世界建模

  ```
  缺点：有些算法慢且复杂
  ```

   **除了数组之外都可以被认为是抽象数据结构（ADT）**

### 小结

- 数据结构是指数据在计算机内存空间中或磁盘中的组织形式。
- 正确选择数据结构会使程序的效率大大提高。
- 数据结构的例子有数组、栈和链表。
- 算法是完成特定任务的过程。
- 在Java中，算法经常通过类的方法实现。
- 本书介绍的大部分数据结构和算法经常被用来建造数据库。
- 一些数据结构的用途是作为程序员的工具：它们帮助执行算法。
- 其他数据结构可以模拟现实世界中的情况，例如城市之间的电话线网
- 数据库是指由许多类似的记录组成的数据存储的集合。
- 一条记录经常表示现实世界中的一个事物，例如一名雇员或一个汽车零件。
- 一条记录被分成字段。每个字段都存储量由这个记录所描述事物的一条特性。
- 一个关键字是一条记录中的一个字段，通过它可以对数据执行许多操作。例如，人事记录可以通过LastName字段进行排序。

## 数组

### Array

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

### Ordered专题applet

_之所以排序，就说为了方便使用二分法查找数据_

### 排序查找方式

- 线性查找

  缺省情况是该查找方式
  ![线性查找](/Users/liqiangpeng/Documents/java数据结构与算法所需图片/QQ20171108-103733@2x.png)

- 二分查找

  二分查找能体现出有序数组的好处。相对于线性查找要快很多，尤其对于大数组来说更为显著。
  ![猜数](../../../../../../data/png/QQ20171108-104247@2x.png)

### 有序数组的java代码

- 二分法查找

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

- OrdArray完整类

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

- 有序数组的优点

  使用有序数组会有什么好处呢？查找速度比无序数组快多了。

  ```
  不好的方面是在插入操作中由于所有靠后的数据都需要移动以腾开空间，所以速度较慢。
  有序数组和无序数组中的删除操作都很慢，这是因为数据项必须向前移动来填补已删除数据项的洞。
  有序数组在查找的频繁的情况下十分有用，但若是插入与删除较为频繁时，则无法高效工作。例如，有序数组适合于公司雇员的数据库。雇佣和解雇雇员同读取一个已存在雇员的有关信息或更改薪水、住址等信息相比，前两者是不经常发生的。
  另一方面，零售商店的存活清单不适用有序数组来实现，这是由于与频繁的进货和出货相应的插入与删除操作都会执行的很慢。
  ```

  二分查找所需的比较次数：![二分查找所需的比较次数](../../../../../../data/png/二分查找所需的比较次数.png)

### 对数

- 方程

  通过不断的将范围除以2来求出比较次数是一种算术的方法。
  图 _二分查找所需的比较次数_ 中的数字省掉了有趣的数据。这些数字不能回答某些问题，例如，在五步之内可以查找的最大范围是多少？为回答次问题首先需要建立一个类似的表：
  二分查找比较次数方程图：![二分查找比较次数方程图](../../../../../../data/png/二分查找比较次数方程图.png)
  每次对范围加倍可以创建出一个数列，它是2的幂，与 _二分查找比较次数方程图_ 中第三列一样。设s表示步数(乘2的次数，即2的幂)，r表示范围，则有下列方程：

   r=2^s  r=2^s 

- 2的指数函数的反函数

  我们最初的问题同上面的相反：已知范围，求出完成搜索的步骤，即已知的是r，求s。
  某叔的指数函数的反函数被称作对数。下面为我们所需要的方程：

  $$ s=\log_2(r) $$

  这个方程说明步数（比较次数）等于以2为底数的范围的对数。什么是对数？以2为底r的对数是为了得到r重复乘以2的次数。在上表中，第一列显示的数字s便等于$$ \log_2(r) $$ 
  。

### 存储对象

> _上代码:_

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

### 大O表示法

```
在算法的世界，常说的“算法a比算法b快两倍”这样的说法并没有多大的意义，由于当数据项个数变化时，对应的比列也会发生根本变化。我们所需一个可以描述算法的速度是如何与数据项的个数相联系的比较。
```

- 无序数组的插入：常数

  无序数组的插入是到目前为止所见过的算法中唯一一个与数组项个数无关的算法。数据项总是被放在下一个有空的地方，a[nElems]，然后nElems增加。无论数组中的数据项个数N有多大，一次插入总是用相同的时间。我们可以说向一个无序数组中插入一个数据项的时间T是一个常数K：T = K

  ```
  在现实情况中，插入所需的实际时间与以下因素有关：微处理器，编译程序生成程序代码的效率，等等。上面等式中K包含了所有这些因素。在现实情况中要得到K的值，需要测量一次插入所话费的时间。K就等于这个世界。
  ```

- 线性查找：与N成正比

  在数据项的线性查找中，我们已发现寻找特定数据项所需的比较次数平均为数据项总数的一半。因此N为数据项总数，搜索时间T与N成正比： T=K*N/2

  ```
  同插入一样，若要得到方程中K的值，首选需要对某个N值的查找进行计时，然后用T来计算K。当得到K后便可对任意N的值来计算T。
  将2并入K可以得到一个更方便的公式。新K值等于原先的K除以2。新公式为：T=K*N
  这个方程说明平均线性查找时间与数组的大小成正比。即如果一个数组增大两倍，则所话费的时间也会相应地增长两倍。
  ```

- 二分查找：与log(N)成正比
  ​	
  同样，二分查找制定的一个与T和N有关的公式：

$$ T=K*\log_2(N) $$
​		

```
正如前面所提到的，时间T与以2为底N的对数成正比。实际上，由于所有的对数和其他对数成正比（从底数为2转换到底数为10需乘以3.322），我们可以将这个为常数的底数也并入K。由此可不必指定底数
```

$$ T=K*log(N) $$

- 不要用常数

  大O表示法同上面公式类似，但它省去了常数K。当比较算法时，并不在具体的微处理器芯片或者编译器；真正需要比较的是对应不同的N值，T是如何变化的，而不是具体的数字。因此不需要常数。

  ```
  大O表示法使用大写字母O，可以认为其含义是“order of”（大约是）。我们可以用大O表示法来描述线性查找使用了O(N)级时间，二分查找使用了O(log N)即时间。向一个无序数组中的插入使用了O(1),或者常数级时间。
  ```

_常用算法的运行时间:_

![常用算法的运行时间](../../../../../../data/png/常用算法的运行时间.png)
_大O的时间图：_
![大O的时间图](../../../../../../data/png/大O的时间图.png)

### 为什么不用数组表示一切？

```
	我们已经见到了许多关于数组的缺点。在一个无序数组中可以很快进行插入（O(1)时间），但是查找却要花费较慢的O(N)时间。在一个有序数组中可以查找的很快，用O(LogN)的时间，但插入却花费了O(N)的时间。对于这种数组而言，由于平均半数的数据项为了填补“空洞”必须移动，所以删除操作平均需要O(N)时间。
	如果有一种数据结构进行如何插入、删除和查找的操作都很快(理想的O(1)或者是O(LogN)时间)，那就好了。
	数组的另一个问题便是它们被new创建以后，大小就被固定住了。但通常在开始设计程序时并不知道会有多少数据将被放入数组中，所以需要猜它大小。如果猜的数过大，会使数组中的某些单元永远不会被填充而浪费空间。如果猜的过小，会发生数组益处，最好的情况下会向程序的用户发出警告信息，最坏的情况则会导致程序奔溃。
	java中有一个被称作向量(vector)类，使用起来很像数组，但是它可以扩展。这些附加功能是以效率作为代价的。当类用户使用类中的内部数组将要溢出时，插入算法创建一个大一点的数组，把旧数组中的内容复制到新数组中，然后插入新数据项。整个过程对于用户来说是不可见的。
```

### 小结

- java中数组是对象，由new操作符创建。
- 无序数组可以提供快速的插入，但查找和删除较慢
- 将数组封装到类中可以保护数组不被随意更改。
- 类的接口由类用户可访问的方法（有时还有字段）组成。
- 类的接口被设计成使类用户的操作更加简单。
- 有序数组可以使用二分查找。
- 以B为底A的对数（大概）是在小于1之前用B除A的次数。
- 线性查找需要的时间与数组中数据项的个数成正比。
- 二分查找需要的时间与数组中数据项的个数的对数成正比。
- 大O表示法为比较算法的速度提供一种方便的方法。
- O(1)级时间的算法是最好的，O(logN)次之，O(N)为一般，O(N^2)最差。

## 简单排序

### 如何排序

```
计算机程序无法像人一样通览所有数据。它只能根据计算机的“比较”操作原理，在同一时间内对两条数据进行比对。
算法的这种“管视“将是一个反复出现的问题。[]()
本章中的三个算法都包括如下两个步骤，这两步循环执行，直到全部数据有序为止：
	1.比较两个数据项。
	2.交换两个数据项，或复制其中一项。	
	但是每种算法具体实现的细节有所不同。	
```

### 冒泡排序

```
冒泡排序算法运行起来非常慢，但在概念上它是排序算法中最简单的。
```

- 冒泡排序java代码

> _数组类：ArrayBub.java_

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

> _测试类：BubbleSortApp.java_

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

> _运行结果：_

```
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
```

- 不变性

  在许多算法中，有些条件在算法执行时是不变的。这些条件被称为不变性。

  ```
  在bubbleSort.java中，不变性是指out右边的所有数据项为有序（在循环过程中，每次外围for循环结束一次即out--，out所在下标的右边都是有序的；也就是说排序是把最大的放到最后，再把第二大的放到倒数第二，以此类推）。在算法的整个运行过程这个条件始终为真。
  ```

- 冒泡排序的效率

  第一趟排序进行了9次比较，第二趟进行了8次，如此类推，直到最后一趟进行了一次比较。

  ```
  对于十个数据项，就是9+8+7+6+5+4+3+2+1=45
  一般来说，数组中有N个数据项，则第一趟排序中有N-1次比较，第二趟中有N-2次，如此类推。这种序列的求和公式：(N-1)+(N-2)+(N-3)+...+1=N*(N-1)/2
  当N为10时，10*9/2=45
  这样，算法约做了N^2/2次比较（忽略减1，不会有很大差别，特别是N很大的时候）
  因为有判断【前一个数据大于后一个数据】时才交换，所以交换的次数少于比较的次数。如果数据是随机的，那么大概有一半的数据需要交换，则交换的次数为N^2/4。（在最坏的情况下，即数据逆序时，每次比较都需要交换）。

  ```

### 选择排序

```
冒泡排序，有序的数据都从右边开始，而选择排序从左边开始。

```

- 详细描述

  从最左边开始。先记录最左端的数据，并记录下标（一般存储在内存）。于是开始用下一条数据和记录的数据进行比较。如果这条数据更小，则将记录改为这条数据下标。继续走下去，每条数据都和记录中的数据进行比较，发现有更小的数据时，更新记录。

  ```
  当做完这些事时，记录中就会是最小的数据，将这条数据与最左边的数据进行交换。
  现在，已经对第一条数据排好序了，期间做了N-1次比较，但是只进行了一次交换。
  在接下来的排序中，所做的事情是一摸一样的，只是需要忽略最左边的数据，因为它已经排好序了。因此算法的第二趟排序从1位置开始。每排完一次序，就多一个有序数据，并被安排在左边，下次在找新的最小值时就可以少考虑一条数据。

  ```

- 选择排序的java代码

> _数组类：ArraySel.java_

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

> _测试类:SelectSortApp.java_

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

> _执行结果:_

```
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

```

- 不变性
  ​	
  在selectSort.java程序中，小标小于out的位置的数据总是有序的。

- 选择排序的效率

  选择排序和冒泡排序执行了相同次数的比较：N*(N-1)/2。对于10个数据项，需要45次比较。

  ```
  然而，10个数据项只需要少于10次交换。对于100个数据项，需要4950次比较，但只进行了不到100次的交换。N值很大时，比较的次数是主要的。

  ```

### 插入排序

- 插入排序java代码

> _数组类：InsertSort.java_

```java
package org.lee.algorithm.sort.charu;

/**
 * Created by liqiangpeng on 2018/1/4.
 */
public class InsertSort {
    private long[] a;
    private int nElems;

    /**
     * 构造方法初始化
     *
     * @param max 数组最大长度
     */
    public InsertSort(int max) {
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
    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] > temp) {
                a[in] = a[in - 1];
                --in;
                //将以下注释打开查看详细交换情况
                /*System.out.print("out=====" + out);
                System.out.print("    temp====" + temp);
                System.out.println("    in=====" + in);
                dispaly();*/
            }
            a[in] = temp;
            /*System.out.print("第" + out + "次外循环交换后： ");
            dispaly();*/
        }
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

> _测试类：InsertSortApp.java_

```java
package org.lee.algorithm.sort.charu;


/**
 * 测试类
 * <p>
 * Created by liqiangpeng on 2018/1/4.
 */
public class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        InsertSort arr = new InsertSort(maxSize);
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
        arr.insertionSort();
        System.out.print("排序后：");
        arr.dispaly();
    }
}
```

> _运行结果：_

```
数组长度为：10
排序前：77 99 44 55 22 88 11 0 66 33 
第1次外循环交换后： 77 99 44 55 22 88 11 0 66 33 
out=====2    temp====44    in=====1
77 99 99 55 22 88 11 0 66 33 
out=====2    temp====44    in=====0
77 77 99 55 22 88 11 0 66 33 
第2次外循环交换后： 44 77 99 55 22 88 11 0 66 33 
out=====3    temp====55    in=====2
44 77 99 99 22 88 11 0 66 33 
out=====3    temp====55    in=====1
44 77 77 99 22 88 11 0 66 33 
第3次外循环交换后： 44 55 77 99 22 88 11 0 66 33 
out=====4    temp====22    in=====3
44 55 77 99 99 88 11 0 66 33 
out=====4    temp====22    in=====2
44 55 77 77 99 88 11 0 66 33 
out=====4    temp====22    in=====1
44 55 55 77 99 88 11 0 66 33 
out=====4    temp====22    in=====0
44 44 55 77 99 88 11 0 66 33 
第4次外循环交换后： 22 44 55 77 99 88 11 0 66 33 
out=====5    temp====88    in=====4
22 44 55 77 99 99 11 0 66 33 
第5次外循环交换后： 22 44 55 77 88 99 11 0 66 33 
out=====6    temp====11    in=====5
22 44 55 77 88 99 99 0 66 33 
out=====6    temp====11    in=====4
22 44 55 77 88 88 99 0 66 33 
out=====6    temp====11    in=====3
22 44 55 77 77 88 99 0 66 33 
out=====6    temp====11    in=====2
22 44 55 55 77 88 99 0 66 33 
out=====6    temp====11    in=====1
22 44 44 55 77 88 99 0 66 33 
out=====6    temp====11    in=====0
22 22 44 55 77 88 99 0 66 33 
第6次外循环交换后： 11 22 44 55 77 88 99 0 66 33 
out=====7    temp====0    in=====6
11 22 44 55 77 88 99 99 66 33 
out=====7    temp====0    in=====5
11 22 44 55 77 88 88 99 66 33 
out=====7    temp====0    in=====4
11 22 44 55 77 77 88 99 66 33 
out=====7    temp====0    in=====3
11 22 44 55 55 77 88 99 66 33 
out=====7    temp====0    in=====2
11 22 44 44 55 77 88 99 66 33 
out=====7    temp====0    in=====1
11 22 22 44 55 77 88 99 66 33 
out=====7    temp====0    in=====0
11 11 22 44 55 77 88 99 66 33 
第7次外循环交换后： 0 11 22 44 55 77 88 99 66 33 
out=====8    temp====66    in=====7
0 11 22 44 55 77 88 99 99 33 
out=====8    temp====66    in=====6
0 11 22 44 55 77 88 88 99 33 
out=====8    temp====66    in=====5
0 11 22 44 55 77 77 88 99 33 
第8次外循环交换后： 0 11 22 44 55 66 77 88 99 33 
out=====9    temp====33    in=====8
0 11 22 44 55 66 77 88 99 99 
out=====9    temp====33    in=====7
0 11 22 44 55 66 77 88 88 99 
out=====9    temp====33    in=====6
0 11 22 44 55 66 77 77 88 99 
out=====9    temp====33    in=====5
0 11 22 44 55 66 66 77 88 99 
out=====9    temp====33    in=====4
0 11 22 44 55 55 66 77 88 99 
out=====9    temp====33    in=====3
0 11 22 44 44 55 66 77 88 99 
第9次外循环交换后： 0 11 22 33 44 55 66 77 88 99 
排序后：0 11 22 33 44 55 66 77 88 99 

```

- 插入排序中的不变性

  在每趟结束后，在将temp位置的项插入后，比out变量下标号小的数据项都是局部有序的。

- 插入排序的效率

  在第一趟排序中，它最多比较一次，第二趟最多比较两次，以此类推。最后一趟最多，比较N-1次。

  ```
  因此有：1+2+3+...+N-1=N*(N-1)/2
  然而，因为在每一趟排序发现插入点之前。平均只有全体数据项的一半真的进行了比较所以得到
  N*(N-1)/4

  ```

### 对象排序

```
为简单起见，前面应用排序算法时都是使用的基本数据类型。但是在实际应用中更多的使用的是对象类型。

```

- 对象排序的java代码

> _对象类：Person.java_

```java
package org.lee.algorithm.sort.object;

/**
 * Created by liqiangpeng on 2018/1/4.
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

> _数组对象类：ArrayInOb.java_

```java
package org.lee.algorithm.sort.object;

/**
 * Created by liqiangpeng on 2018/1/4.
 */
public class ArrayInOb {
    private Person[] a;
    private int nElems;

    public ArrayInOb(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public void insert(String last, String first, int age) {
        a[nElems] = new Person(last, first, age);
        nElems++;
    }

    public void dispaly() {
        for (int j = 0; j < nElems; j++) {
            System.out.println(a[j]);
        }
    }

    /**
     * 根据lastName排序
     */
    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            Person temp = a[out];
            in = out;
            while (in > 0 && a[in - 1].getLastName().compareTo(temp.getLastName()) > 0) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }
}
```

> _测试类：ObjectSortApp.java_

```java
package org.lee.algorithm.sort.object;

/**
 * Created by liqiangpeng on 2018/1/4.
 */
public class ObjectSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayInOb arr = new ArrayInOb(maxSize);

        arr.insert("Evans","Patty",24);
        arr.insert("Smith","Doc",59);
        arr.insert("Smith","Lorraine",37);
        arr.insert("Smith","Paul",37);
        arr.insert("Yee","Tom",43);
        arr.insert("Hashimoto","Sato",21);
        arr.insert("Stimson","Henry",29);
        arr.insert("Velasquez","Jose",72);
        arr.insert("Vang","Minh",22);
        arr.insert("Creswell","Luvinda",18);

        System.out.println("排序前：");
        arr.dispaly();
        arr.insertionSort();
        System.out.println("排序后：");
        arr.dispaly();

    }
}
```

> _运行结果：_

```
排序前：
Person{lastName='Evans', firstName='Patty', age=24}
Person{lastName='Smith', firstName='Doc', age=59}
Person{lastName='Smith', firstName='Lorraine', age=37}
Person{lastName='Smith', firstName='Paul', age=37}
Person{lastName='Yee', firstName='Tom', age=43}
Person{lastName='Hashimoto', firstName='Sato', age=21}
Person{lastName='Stimson', firstName='Henry', age=29}
Person{lastName='Velasquez', firstName='Jose', age=72}
Person{lastName='Vang', firstName='Minh', age=22}
Person{lastName='Creswell', firstName='Luvinda', age=18}
排序后：
Person{lastName='Creswell', firstName='Luvinda', age=18}
Person{lastName='Evans', firstName='Patty', age=24}
Person{lastName='Hashimoto', firstName='Sato', age=21}
Person{lastName='Smith', firstName='Doc', age=59}
Person{lastName='Smith', firstName='Lorraine', age=37}
Person{lastName='Smith', firstName='Paul', age=37}
Person{lastName='Stimson', firstName='Henry', age=29}
Person{lastName='Vang', firstName='Minh', age=22}
Person{lastName='Velasquez', firstName='Jose', age=72}
Person{lastName='Yee', firstName='Tom', age=43}

```

- 单词排序

  ArrayInOb.java程序中的insertSort()和InsertSort.java中的insertionSort()类似。只是比较的不再是基本数据类型，而是对象类型中的lastName属性。

  ```
    表达式:a[in - 1].getLastName().compareTo(temp.getLastName())
  compareTo()方法根据两个String的字典顺序返回给调用者不同的整数值，这两个String一个是方法的调用者，一个是这个方法的参数，如下表格：		

  ```

  | s2.compareTo(s1) | 返回值  |
  | :--------------- | :--: |
  | s1>s2            | 小于0  |
  | s1=s2            | 等于0  |
  | s1>s2            | 大于0  |

- 稳定性

  有些时候要考虑数据项拥有相同关键字的情况。例如，雇员数据按雇员的姓的字典序排序，先走又想按邮政编码排序，并希望具有相同邮政编码的数据仍然按照姓排序。这种情况下，则只需要算法对需要排序的数据进行排序，让不需要排序的数据保持原来的顺序。某些算法满足这样的要求，它们就可以称为稳定的算法。

  ```
  本章中所有的算法都是稳定的。例如，ObjectSortApp.java中的输出，有三个人的姓都是Smith。开始顺序为Doc Smith、Lorraine Smith和Paul Smith。排序后，这个顺序依然存在。	

  ```

### 几种排序算法的比较

```
一般情况几乎不太使用冒泡排序算法，过于简单。然而数据量小的时候它会有些应用价值。
选择排序虽然把交换次数降到最低，但比较的次数仍然很大。当数据量很小，并且交换数据相对于比较数据更加耗时的情况下，可以应用选择排序。
大多数情况下，假设数据量比较小或基本有序时，插入排序算法是三种简单排序中最好的选择。

```

## 栈和队列

### 栈

```
栈只允许访问一个数据项：即最后插入的数据项，移除(出栈)该数据项才能访问第二个数据项。

```

- 数组模拟栈

> _StackX.java_

```java
package org.lee.algorithm.stackAndQueue.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 栈
 */
public class StackX {
    private int maxSize;
    private char[] stackArray;
    private int top;

    /**
     * 初始化
     *
     * @param s 长度
     */
    public StackX(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    /**
     * 压栈
     *
     * @param j
     */
    public void push(char j) {
        stackArray[++top] = j;
    }

    /**
     * 出栈
     *
     * @return
     */
    public char pop() {
        return stackArray[top--];
    }

    /**
     * 查看
     *
     * @return
     */
    public char peek() {
        return stackArray[top];
    }

    /**
     * 非空判断
     *
     * @return
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * 数组是否满
     *
     * @return
     */
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

/**
 * 测试栈
 */
class StackApp {
    public static void main(String[] args) {
        StackX stackX = new StackX(10);
        stackX.push('l');
        stackX.push('e');
        stackX.push('e');
        stackX.push('s');

        while (!stackX.isEmpty()) {
            System.out.println("查看到 " + stackX.peek());
            char value = stackX.pop();
            System.out.println(value + " 已出栈");
            System.out.println("==========");

        }
    }
}

/**
 * 输入工具
 */
class InputUtils {
    public static String getString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
```

> _运行结果_

```
查看到 s
s 已出栈
==========
查看到 e
e 已出栈
==========
查看到 e
e 已出栈
==========
查看到 l
l 已出栈
==========

```

- 单词逆序

> _Reverser.java_

```java
package org.lee.algorithm.stackAndQueue.stack;

import java.io.IOException;

/**
 * 单词反转
 * <p>
 * Created by liqiangpeng on 2018/1/18.
 */
public class Reverser {

    private String input;
    private String output;

    public Reverser(String in) {
        input = in;
    }

    public String doRev() {
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            theStack.push(ch);
        }
        output = "";
        while (!theStack.isEmpty()) {
            char ch = theStack.pop();
            output = output + ch;
        }
        return output;
    }
}

/**
 * 测试单词反转
 */
class ReverseApp {

    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.println("输入字符串：");
            System.out.flush();
            input = InputUtils.getString();
            if (input.equals(""))
                break;
            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev();
            System.out.println("字符串反转后：" + output);

        }
    }


}
```

> _运行结果_

```
输入字符串：
fasdjgasfasjiewruo
字符串反转后：ourweijsafsagjdsaf
输入字符串：

```

- 分隔符匹配

  ```
  例如编译一段代码（不一定是java代码），它同样需要java程序一样的分隔符，分隔符包括大括号"{"和"}"，中括号"["和"]"，小括号"("和")"。每个左分隔符都需要和右分隔符匹配。

  ```

  ```
  分隔符匹配程序从输入的字符串中不断读取，碰到左分隔符就压入栈，碰到右分隔符从栈顶弹出与右分隔符匹配。

  ```

> _BracketChecker.java_

```java
package org.lee.algorithm.stackAndQueue.stack;

import java.io.IOException;

/**
 * 栈模拟编译器中的分隔符匹配
 * <p>
 * Created by liqiangpeng on 2018/1/18.
 */
public class BracketChecker {
    private String input;

    public BracketChecker(String in) {
        input = in;
    }

    public void check() {
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);//将作分割符的数据压栈
                    break;
                case '}':
                case ']':
                case ')':
                    if (!theStack.isEmpty()) {//说明栈中已有左分隔符的数据，弹出栈顶的数据，与右分隔符比较
                        char chx = theStack.pop();
                        if ((ch == '}' && chx != '{') ||
                                (ch == ']' && chx != '[') ||
                                (ch == ')' && chx != '('))
                            System.out.println("Error :" + ch + " at " + j);
                    } else
                        System.out.println("Error: " + ch + " at " + j);
                    break;
                default:
                    break;
            }
        }
        if (!theStack.isEmpty())//不等于空，说明没有完全出栈,分隔符数量不匹配
            System.out.println("Error: missing right delimiter");
    }
}

/**
 * 测试分隔符匹配
 */
class BracketsApp {
    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            System.out.println("输入分隔符字符串：");
            System.out.flush();
            input = InputUtils.getString();
            if (input.equals(""))
                break;
            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check();
        }
    }
}
```

> _运行结果_

```
输入分隔符字符串：
{fsafa[fad]
Error: missing right delimiter
输入分隔符字符串：
{adsfafs[fasdfa]fads)
Error :) at 20
输入分隔符字符串：

```

- 栈的效率

  ```
  StackX类中实现的栈，数据项入栈和出栈的时间复杂度都为常数O(1)。这也就是说，栈操作所耗的时间不依赖于栈中数据项的个数，因此操作时间很短。栈不需要比较和移动操作。

  ```

### 队列

```
先进先出
```

- 数组模拟队列

  > _Queue.java_

  ```java
  public class Queue {

      private int maxSize;
      private long[] queArray;
      private int front;//队头
      private int rear;//队尾
      private int nItems;

      public Queue(int s) {
          maxSize = s;
          queArray = new long[maxSize];
          front = 0;
          rear = -1;
          nItems = 0;
      }

      public void insert(long j) {
          if (rear == maxSize - 1)
              rear = -1;
          queArray[++rear] = j;
          nItems++;
      }

      public long remove() {
          long temp = queArray[front++];
          if (front == maxSize)
              front = 0;
          nItems--;
          return temp;
      }

      public long peekFront() {
          return queArray[front];
      }

      public boolean isEmpty() {
          return (nItems == 0);
      }

      public boolean isFull() {
          return (nItems == maxSize);
      }

      public int size() {
          return nItems;
      }

  }
  ```

  > _QueueApp.java_

  ```java
  class QueueApp {
      public static void main(String[] args) {
          Queue queue = new Queue(5);
          queue.insert(10);
          queue.insert(20);
          queue.insert(30);
          queue.insert(40);

          queue.remove();
          queue.remove();
          queue.remove();

          queue.insert(50);
          queue.insert(60);
          queue.insert(70);
          queue.insert(80);

          while (!queue.isEmpty()) {
              long n = queue.remove();
              System.out.println(n);
          }
      }
  }
  ```

  > _运行结果_

  ```
  40
  50
  60
  70
  80

  Process finished with exit code 0

  ```

## 链表

### 链结点

```
在链表中，每个数据项都被包含在“链结点”中。一个链结点是某个类的对象，这个类可以叫做Link。
因为一个链表中有许多类似的链结点，所以有必要用一个不同于链表的类来表达链结点。
每个Link对象中都包含一个对下一个链结点引用的字段(next)。但是链表本身的对象中有一个字段指向对第一个链结点的引用。

```

### 单链表

> _Link.java_		

```java
package org.lee.algorithm.link.singleend;

/**
 * 链结点
 * <p>
 * Created by liqiangpeng on 2018/6/25.
 */
public class Link {
    public int iData;   //数据项

    public double dData;  //数据项

    public Link next;   //指向下一个链接点,引用reference

    /**
     * 数据项字段较多，一般使用对象来表示
     *
     * @param id 数据项
     * @param dd 数据项
     */
    public Link(int id, double dd) {
        iData = id;
        dData = dd;
    }

    public void disPlayLink() {
        System.out.print("{" + iData + "," + dData + "}");
    }

}

```

> _LinkList.java_

```java
package org.lee.algorithm.link.singleend;

/**
 * 单链表
 * <p>
 * Created by liqiangpeng on 2018/6/24.
 */
public class LinkList {

    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 在插入操作时，先将新引用的下一个链结点(newLink.next)赋值为第一个链结点(first)
     * 在将第一个链结点赋值为新的引用即可
     *
     * @param id 数据项
     * @param dd 数据项
     */
    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    /**
     * 被称为current的变量开始时指向first
     * 然后通过b不断地把自己赋值为first.next,沿着链表向前移动。
     * 在每个链结点处，find()检查链结点的关键值是否与它寻找的相同
     * 如果找到了，返回对该链结点的引用。
     * 如果find()到达链结点的尾处都没找到，返回null。
     *
     * @param key iData
     * @return target
     */
    public Link find(int key) {
        Link current = first;
        while (current.iData != key) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    /**
     * 和find（）方法类似
     * 它先搜索要删除的链结点。
     * 然而它需要掌握的不仅是指向当前链结点(current)的引用，还有指向当前链结点的前一个(previous)链结点的引用。
     * 这是因为，如果要删除当前链结点，必须把前一个链结点和后一个链结点连在一起。
     *
     * @param key iData
     * @return target
     */
    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.iData != key) {
            if (current.next == null)
                return null;
            else {
                /*
                    在while语句的每一次论循环中，每当current变量赋值为current.next之前
                    先把previous变量赋值为current。
                    这保证了它总是指向current所指链结点的前一个链结点
                 */
                previous = current;
                current = current.next;
            }
        }
        /*
        一旦发现当前链结点是要被删除的链结点，就把前一个链结点的next字段赋值为当前链结点的下一个链结点。
        如果当前链结点是第一个链结点，这是一种特殊情况，因为这是由LinkList对象的first域指向的链结点，而不是别的链结点的next字段所指的。
        这种情况下，使first字段指向first.next就可以删除第一个链结点。
         */
        if (current == first)
            first = first.next;
        else
            previous.next = current.next;
        return current;

    }


    /**
     * 在删除操作时，temp变量赋值为第一个链结点
     * 将第一个链结点(first)赋值为下一个链结点first.next即可
     *
     * @return 被删除的元素
     */
    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }


    public void dispalyList() {
        System.out.print("List (first --> last): ");
        Link current = first;
        while (current != null) {
            current.disPlayLink();
            current = current.next;
        }
        System.out.println("");
    }
}


class LinkApp {
    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.dispalyList();

        Link f = theList.find(44);
        if (f != null)
            System.out.println("found Link " + f.iData);
        else
            System.out.println("can not found link");

        Link d = theList.delete(66);
        if (d != null)
            System.out.println("delete link with key " + d.iData);
        else
            System.out.println("can not delete link");

        theList.dispalyList();

        while (!theList.isEmpty()) {
            Link aLink = theList.deleteFirst();
            System.out.print("Deleted ");
            aLink.disPlayLink();
            System.out.println("");
        }
        theList.dispalyList();
    }
}

```



> 输出结果_

```
List (first --> last): {88,8.99}{66,6.99}{44,4.99}{22,2.99}
found Link 44
delete link with key 66
List (first --> last): {88,8.99}{44,4.99}{22,2.99}
Deleted {88,8.99}
Deleted {44,4.99}
Deleted {22,2.99}
List (first --> last): 

Process finished with exit code 0

```

### 双链表（双链表 != 双向链表）

```
双端链表与单链表相似，但是多了一个特性：对最后一个链结点的引用，就像对第一个链结点的引用一样。
对最后一个链结点的引用允许像在表头一样，在表尾直接插入一个链结点。当然，仍然可以在普通的单链表的尾表插入一个链结点，方法是遍历整个链表直到表尾，但效率很低。

```

> _FirstLastLinkList.java_

```java
package org.lee.algorithm.link.doubleend;


/**
 * 双端链表
 * Created by liqiangpeng on 2018/6/25.
 */
public class FirstLastLinkList {
    private Link first;

    private Link last;

    public FirstLastLinkList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 如果链表为空，则表头和表尾都是newLink
     *
     * @param dd data
     */
    public void insertFirst(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;
    }

    /**
     * 如果链表为空，则表头表尾都为newLink，否则表尾的next为newLink
     * 将表尾设置为newLink
     *
     * @param dd
     */
    public void insertLast(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    /**
     * 如果表头的下一个为空，说明链表只有一个链结点，表尾设为空
     * 将表头的链结点设为链结点的下一个
     *
     * @return delete data
     */
    public long deleteFirst() {
        long temp = first.dData;
        if (first.next == null)
            last = null;
        first = first.next;
        return temp;
    }

    public void dispalyList() {
        System.out.print("List (first --> last): ");
        Link current = first;
        while (current != null) {
            current.disPlayLink();
            current = current.next;
        }
        System.out.println("");
    }

}

class Link {

    public long dData;  //数据项

    public Link next;   //指向下一个链接点,引用reference

    /**
     * 数据项字段较多，一般使用对象来表示
     *
     * @param dd 数据项
     */
    public Link(long dd) {
        dData = dd;
    }

    public void disPlayLink() {
        System.out.print("{" + dData + "}");
    }

}

class FirstLastApp {
    public static void main(String[] args) {
        FirstLastLinkList theList = new FirstLastLinkList();
        theList.insertFirst(22L);
        theList.insertFirst(44L);
        theList.insertFirst(66L);
        theList.insertFirst(88L);
        
        theList.insertLast(99L);

        theList.dispalyList();

        theList.deleteFirst();
        theList.deleteFirst();
        theList.deleteFirst();

        theList.dispalyList();
    }
}

```

> _运行结果_

```
List (first --> last): {88}{66}{44}{22}{99}
List (first --> last): {22}{99}

Process finished with exit code 0

```

> _说明_

```
双端链表无法删除最后一个链结点，因为没有一个引用指向倒数第二个链结点。
如果最后一个链结点被删除，倒数第二个链结点的next字段应该变成null值。
为了方便删除最后一个链结点，需要一个双向链表。（当然，也可以遍历整个链表找到最后一个链结点，但是效率不是很高）

```

### 链表的效率

```
在表头的插入和删除仅需改变一两个引用值，花费O(1)的时间。
而在查找、删除和指定链结点后面插入都需要平均搜索链表中一半的链结点，需花费O(N)次比较。
在数组中执行这写操作也需要O(N)次比较，但链表会快一些，因为插入和删除链结点时，链表不需要移动任何东西。
链表相较于数组优越的另外一个重要方面是链表需要多少内存就可以用多少内存，并且可以扩展到可用内存。数组的大小在它创建的时间就固定了；

```

### 使用链表实现栈和队列

#### 栈

```
基于以上单链表

```

> _LinkStack.java_

```java
package org.lee.algorithm.link.stackqueue;

import org.lee.algorithm.link.singleend.LinkList;

/**
 * 使用链表实现棧
 * Created by liqiangpeng on 2018/6/25.
 */
public class LinkStack {

    private LinkList theList;

    public LinkStack() {
        theList = new LinkList();
    }

    public void push(int id, double dd) {
        theList.insertFirst(id, dd);
    }

    public int pop() {
        return theList.deleteFirst().iData;
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void displayStack() {
        theList.dispalyList();
    }
}

class LinkStackApp {
    public static void main(String[] args) {
        LinkStack theStack = new LinkStack();
        theStack.push(22, 2.99);
        theStack.push(44, 4.99);
        theStack.push(66, 6.99);
        theStack.push(88, 8.99);

        theStack.displayStack();

        theStack.pop();
        theStack.pop();
        theStack.pop();

        theStack.displayStack();
    }
}

```

> _运行结果_

```
List (first --> last): {88,8.99}{66,6.99}{44,4.99}{22,2.99}
List (first --> last): {22,2.99}

Process finished with exit code 0

```

#### 队列

```java
基于以上双链表
```

> _LinkQueue.java_

```java
package org.lee.algorithm.link.stackqueue;

import org.lee.algorithm.link.doubleend.FirstLastLinkList;

/**
 * 用链表实现队列
 * 先进先出
 * <p>
 * Created by liqiangpeng on 2018/6/30.
 */
public class LinkQueue {

    private FirstLastLinkList theList;

    public LinkQueue() {
        theList = new FirstLastLinkList();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void insert(long j) {
        theList.insertLast(j);
    }

    public long remove() {
        return theList.deleteFirst();
    }

    public void displayQueue() {
        System.out.print("Queue (front --> rear): ");
        theList.dispalyList();
    }
}


class LinkQueueApp {

    public static void main(String[] args) {
        LinkQueue theQueue = new LinkQueue();
        theQueue.insert(20);
        theQueue.insert(40);

        theQueue.displayQueue();

        theQueue.insert(60);
        theQueue.insert(80);

        theQueue.displayQueue();

        theQueue.remove();
        theQueue.remove();

        theQueue.displayQueue();
    }
}
```

> _运行结果_

```
Queue (front --> rear): List (first --> last): {20}{40}
Queue (front --> rear): List (first --> last): {20}{40}{60}{80}
Queue (front --> rear): List (first --> last): {60}{80}

Process finished with exit code 0

```

