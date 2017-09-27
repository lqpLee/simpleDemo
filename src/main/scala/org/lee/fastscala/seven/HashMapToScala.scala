/**
  * Created by liqiangpeng on 2017/7/14.
  */
object HashMapToScala extends App {

  //java 中的hashMap
  import java.util.{HashMap => JavaHashMap}

  val map = new JavaHashMap[String, String]()

  map.put("1", "a")

  map.put("2", "b")

  map.put("3", "c")

  //Scala中的hashMap
  import scala.collection.mutable.HashMap

  val smap = new HashMap[String, String]()

  for (key <- map.keySet().toArray) {
    smap += (key.toString -> map.get(key))
  }

  println(smap.mkString)

}
