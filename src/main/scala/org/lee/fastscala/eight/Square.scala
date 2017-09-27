import java.awt.{Point, Rectangle}

/**
  * Created by liqiangpeng on 2017/7/14.
  */
class Square(point: Point, width: Int) extends java.awt.Rectangle(point.x, point.y, width, width) {

  def this() {
    this(new Point(0, 0), 0)
  }

  def this(width:Int){
    this(new Point(0,0),width)
  }

}
