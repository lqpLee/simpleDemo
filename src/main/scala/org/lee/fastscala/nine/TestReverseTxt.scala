package org.lee.fastscala.nine

import java.io.PrintWriter

import scala.io.Source

/**
  * Created by liqiangpeng on 2017/7/14.
  */
object TestReverseTxt extends App {

  //第一题

  /*val path = "/Users/liqiangpeng/Downloads/Hamlet1.txt"

  val reader = Source.fromFile(path).getLines()

  val result = reader.toArray.reverse

  val pw = new PrintWriter(path)

  result.foreach(line => pw.write(line+"\n"))

  pw.close()*/
  //第二题
  /*val path = "/Users/liqiangpeng/Downloads/Hamlet1.txt"

  val reader = Source.fromFile(path).getLines()

  val result = for(t <- reader) yield t.replaceAll("\\t", "  ")

  val pw = new PrintWriter(path)

  result.foreach(line => pw.write(line+"\n"))

  pw.close*/


  //第三题
  /*Source.fromFile("/Users/liqiangpeng/Downloads/Hamlet1.txt").mkString.split("\\s+").foreach(arg =>
    if (arg.length > 12) println(arg))*/

  //第四题
  /*val nums = Source.fromFile("/Users/liqiangpeng/Downloads/Hamlet1.txt").mkString("\\s+")

  var total = 0d

  nums.foreach(total += _.toDouble)

  println(total)
  println(total/nums.length)
  println(nums.max)
  println(nums.min)*/

  //第五题
  /*val pw = new PrintWriter("/Users/liqiangpeng/Downloads/Hamlet2.txt")

  for(n<- 0 to 20){
    val t = BigDecimal(2).pow(n)
    pw.write(t.toString())
    pw.write("\t\t")
    pw.write((1/t).toString())
    pw.write("\n")
  }
  pw.close()*/

  //第六题
  val source = Source.fromFile("/Users/liqiangpeng/Downloads/Hamlet1.txt").mkString

  val pattern = "\\w+\\s+\"".r

  pattern.findAllIn(source).foreach(println)



}
