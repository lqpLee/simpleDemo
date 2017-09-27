package org.lee.fastscala.six

/**
  * Created by liqiangpeng on 2017/7/14.
  */
class Point(x: Int, y: Int) {

  override def toString: String = "x= " + x + " y = " + y

}

object Point extends App {
  def apply(x: Int, y: Int): Point = {
    new Point(x, y)
  }
  val p = Point(1,2)
  println(p)
}
