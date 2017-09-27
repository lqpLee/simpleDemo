package org.lee.fastscala.eight

/**
  * Created by liqiangpeng on 2017/7/14.
  */
abstract class Shape {
  def centerPoint()
}

class Rectangle(startX: Int, startY: Int, endX: Int, endY: Int) extends Shape {
  override def centerPoint() {}
}

class Circle(x: Int, y: Int, raduis: Double) extends Shape {
  override def centerPoint() {}
}
