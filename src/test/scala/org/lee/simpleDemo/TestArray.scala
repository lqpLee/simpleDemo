package org.lee.simpleDemo

import org.junit.Test
import org.lee.digui.DiguiDemo

import scala.collection.mutable.ArrayBuffer

/**
  * Created by liqiangpeng on 2017/6/20.
  */
class TestArray {


  @Test
  def testArray():Unit= {
    val nums = new Array[Int](10)
    val s = Array("Hello","Scala")
    s(0) = "hey!"
    val b = ArrayBuffer[Int]()
    b += 1 //ArrayBuffer(1) 追加元素
    b += (1,2,3,5)//ArrayBuffer(1,1,2,3,5) 在末尾追加多个元素
    b ++= Array(8,13,21)//ArrayBuffer(1,1,2,3,5,8,13,21) 追加集合
    b.trimEnd(5)//ArrayBuffer(1,1,2) 移除最后5个元素
    b.insert(2,6)//ArrayBuffer(1,1,6,2) 在下标2之前插入
    b.insert(2,7,8,9)//ArrayBuffer(1,1,7,8,9,6,2) 在下标2之前插入任意多的元素
    b.remove(2)//ArrayBuffer(1,1,8,9,6,2)
    b.remove(2,3)//ArrayBuffer(1,1,2) 移除下标2之后的三个元素
    b.toArray
    for (i<- b.indices)
      println("test0  index"+i+": "+b(i))
    val a = Array(4,6,2,3,5,7,11)

    scala.util.Sorting.quickSort(a);//排序 Array(2,3,4,5,6,7,11)
    //val string = a.mkString(" and ")//生成String: 2 and 3 and 4 and 5 and 6 and 7 and 11
    //val string = a.mkString("<",",",">")//<2,3,4,5,6,7,11>

   /* val result = for(elem <- a) yield 2 * elem //元素*2
    for (i<- 0 until result.length)
      println("test1  index"+i+": "+result(i));

    val result2 = for(elem <- a if elem % 2 == 0) yield 2 * elem  // 过滤偶数 元素*2
    for (i<- 0 until result2.length)
      println("test2  index"+i+": "+result2(i));

    val result3 = a.filter(_ % 2 == 0).map(2 * _)//同上 过滤偶数 元素*2
    for (i<- 0 until result3.length)
      println("test3  index"+i+": "+result3(i));*/

  }

  /**
    * 调用java程序
    */
  @Test
  def testDoJava(): Unit ={
    val i = DiguiDemo.getRabbitAsArray(12)
    print(i)
  }

}
