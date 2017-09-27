package org.lee.simpleDemo

import org.junit.Test

import math._
import scala.collection.mutable.ArrayBuffer

/**
  * Created by liqiangpeng on 2017/6/2.
  * 数学运算符操作
  * 在scala中，运算符也是属于方法  a+b   ==》  a.+(b)
  */

class TestMath {



  @Test
  def testMath(): Unit = {
    println(operator(4, 8))
  }

  def operator(a: Integer, b: Integer): Integer = {
    var sum: Integer = 0
    sum = a.+(b)
    return sum
  }

  @Test
  def simpleTest(): Unit = {
    val x: BigDecimal = 23142444
    println(x * x)
    println(sqrt(2))
    println(pow(2, 4))
    println(Pi)
    println(BigInt.probablePrime(100, scala.util.Random))
    println("Hello".distinct)
  }

  @Test
  def signumTest(): Unit={
    println(signum(21331))
  }

  /**
    * 判断数字正负0
    * @param arg
    * @return
    */
  def signum(arg:Integer):Integer = {
      if(arg>0)
        1
      else if(arg ==  0)
        0
      else
        -1
  }


}
