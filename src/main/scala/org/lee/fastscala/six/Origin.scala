package org.lee.fastscala.six
import java.awt

/**
  * Created by liqiangpeng on 2017/7/14.
  */
object Origin extends java.awt.Point with App{

  override def getLocation: awt.Point = super.getLocation

  Origin.move(2,3)

  println(Origin.toString)

}
