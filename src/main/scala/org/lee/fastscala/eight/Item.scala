package org.lee.fastscala.eight

import scala.collection.mutable.ArrayBuffer

/**
  * Created by liqiangpeng on 2017/7/14.
  */
abstract class Item {

  def price(): Double

  def description(): String

  override def toString: String = {
    "description:" + description() + "  price:" + price()
  }

}

class SimpliItem(val price: Double, val description: String) extends Item {

}

class Bundle extends Item{

  val items = new ArrayBuffer[Item]()

  def addItem(item:Item): Unit ={
    items += item
  }

  def price(): Double = {
    var total = 0d
    items.foreach(total += _.price())
    total
  }

  override def description(): String = {
    items.mkString(" ")
  }
}