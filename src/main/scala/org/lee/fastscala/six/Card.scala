package org.lee.fastscala.six

/**
  * Created by liqiangpeng on 2017/7/14.
  */
object Card extends Enumeration with App{
  val M = Value("♣")
  val F = Value("♦")
  val H = Value("♥")
  val T = Value("♠")

  def color(c:Card.Value): Unit ={
    if(c == Card.M || c == Card.T) println("Black")
    else println("Red")

  }

  color(Card.H)
}
