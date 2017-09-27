package org.lee.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.junit.{Before, Test}

/**
  * rdd练习
  * ﻿在实际的计算里我们经常会不同的计算算法不停的转化RDD的数据类型，而使用scala开发spark程序时候，我发现scala和javascript很类似，
  * 我们不去指定返回值数据类型，scala编译器也会自动推算结果的数据类型，因此编码时候我们可以不指定具体数据类型。
  * 这个特点就会让我们在实际开发里碰到种种问题，因此我在示例代码里明确了RDD转化后的数据类型。
  *
  * 注：也是根据网上的资料搬过来的
  *
  *
  * Created by liqiangpeng on 2017/9/10.
  */
class RddTest {

  var sc: SparkContext = null;

  @Before
  def before(): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("WordCount")
    sc = new SparkContext(sparkConf)
  }

  /*=========================================RDD基础操作1===================================================*/

  @Test
  def _testBase1_map(): Unit = {
    val rdd01 = sc.makeRDD(List(1, 2, 3, 4, 5, 6))
    //将一个list封装为rdd
    val r01 = rdd01.map { x => x * x } //﻿参数是函数，函数应用于RDD每一个元素，返回值是新的RDD
    // 「类似于java中的函数式接口。（使用内部类的方式将接口的实现写在参数中）」
    println(">>>>>>>>>>>>>>>>>>>" + r01.collect().mkString(",") + ">>>>>>>>>>>>>>>")
    /**
      * collect:﻿返回RDD所有元素（集合） def collect(): Array[T] = withScope
      * mkString:返回String
      * 1、无参数：直接打印数据
      * 2、一个参数：分隔符
      * 3、三个参数：前，分隔符，后
      */

  }

  @Test
  def _testBase1_filter: Unit = {
    val rdd02 = sc.makeRDD(Array(1, 2, 3, 4, 5, 6))
    val r02 = rdd02.filter { x => x < 5 } //﻿参数是函数，函数会过滤掉不符合条件的元素，返回值是新的R
    println(">>>>>>>>>>>>>>>>>>>" + r02.collect().mkString(",") + ">>>>>>>>>>>>>>>")
  }

  @Test
  def _testBase1_parallelize: Unit = {
    val rdd03 = sc.parallelize(List(1, 2, 3, 4, 5, 6), 1)
    //第二个参数的作用？
    val r03 = rdd03.map { x => x + 1 }
    println(r03.collect().mkString(","))
  }

  @Test
  def _testBase1_textFile: Unit = {
    val rdd: RDD[String] = sc.textFile("file:///Users/liqiangpeng/Downloads/Hamlet.txt", 1)
    val r: RDD[String] = rdd.flatMap(x => x.split(","))
    println(r.collect().mkString(","))
  }

  /**
    * ﻿转化操作（transformation）
    * ﻿RDD执行转化操作时候，实际计算并没有被执行，只有当RDD执行行动操作时候才会促发计算任务提交，执行相应的计算操作
    */
  @Test
  def _testBase1_transformation: Unit = {
    val rddInt: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 2, 5, 1))
    val rddStr: RDD[String] = sc.parallelize(Array("a", "b", "c", "d", "b", "a"), 1)
    val rddFile: RDD[String] = sc.textFile("file:///Users/liqiangpeng/Downloads/Hamlet.txt", 1)

    val rdd01: RDD[Int] = sc.makeRDD(List(1, 3, 5, 3))
    val rdd02: RDD[Int] = sc.makeRDD(List(2, 4, 5, 1))

    /* map操作 */
    println("map>>>>>>>>>" + rddInt.map(x => x + 1).collect().mkString(",")) //对每个元素+1，map中的参数为一个函数


    /*  filter操作  */
    println("filter>>>>>>>>>" + rddInt.filter(x => x > 4).collect().mkString(","))

    /*  flatMap 操作   */
    println("flatMap>>>>>>>>>" + rddFile.flatMap(x => x.split(",")).first())

    /*distinct去重*/
    println("distinct>>>>>>>>>" + rddInt.distinct().collect().mkString(","))
    println("distinct>>>>>>>>>" + rddStr.distinct().collect().mkString(","))

    /*union操作*/
    println("union>>>>>>>>>" + rdd01.union(rdd02).collect().mkString(",")) //union将两个rdd合并

    /*intersection*/
    println("intersection>>>>>>>>>" + rdd01.intersection(rdd02).collect().mkString(",")) //﻿参数是RDD，求出两个RDD的共同元素

    /*subtract*/
    println("subtract>>>>>>>>>" + rdd01.subtract(rdd02).collect().mkString(",")) //﻿参数是RDD，将原RDD里和参数RDD里相同的元素去掉

    /*﻿cartesian*/
    println("cartesian>>>>>>>>>" + rdd01.cartesian(rdd02).collect().mkString(",")) //﻿参数是RDD，求两个RDD的笛卡儿积
  }

  /**
    * ﻿行动操作（action）
    * ﻿转化操作就是从一个RDD产生一个新的RDD操作，而行动操作就是进行实际的计算
    */
  @Test
  def _testBase1_action: Unit = {
    val rddInt: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 2, 5, 1))
    val rddStr: RDD[String] = sc.parallelize(Array("a", "b", "c", "d", "b", "a"), 1)

    /*count*/
    println("count>>>>>>>>>" + rddInt.count())

    /*countByValue*/
    println("countByValue>>>>>>>>" + rddInt.countByValue())

    /*reduce*/
    println("reduce>>>>>>>>" + rddInt.reduce((x, y) => x + y)) //﻿并行整合所有RDD数据，例如求和操作

    /*fold*/
    println("fold>>>>>>>>" + rddInt.fold(0)((x, y) => x + y)) //﻿和reduce功能一样，不过fold带有初始值

    /*aggregate*/
    val res: (Int, Int) = rddInt.aggregate((0, 0))((x, y) => (x._1 + x._2, y), (x, y) =>
      (x._1 + x._2, y._1 + y._2)) //﻿和reduce功能一样，但是返回的RDD数据类型和原RDD不一样
    println("aggregate>>>>>>>>" + res._1 + "," + res._2)

    /*foreach*/
    println("foreach>>>>>>>>" + rddStr.foreach { x => println(x) }) //foreach中的打印有值，而外面的println只会打印"()"。猜测是因为该action操作返回值为unit
  }


  /*=========================================RDD基础操作2 (﻿Pair RDD)===================================================*/

  /**
    * ﻿RDD任然是数组形式，只不过数组的元素是("k01",3)格式是scala里面特有的Tuple2及二元组，元组可以当作一个集合，这个集合可以是各种不同数据类型组合而成，二元组就是只包含两个元素的元组。
    *
    * 由此可见Pair RDD也是数组，只不过是一个元素为二元组的数组而已，上篇里对RDD的操作也是同样适用于Pair RDD的。
    */
  /**
    * ﻿Pair RDD的API讲解
    * ======================转化操作的API
    *
    * ﻿reduceByKey：合并具有相同键的值；
    * groupByKey：对具有相同键的值进行分组；
    * keys：返回一个仅包含键值的RDD；
    * values：返回一个仅包含值的RDD；
    * sortByKey：返回一个根据键值排序的RDD；
    * flatMapValues：针对Pair RDD中的每个值应用一个返回迭代器的函数，然后对返回的每个元素都生成一个对应原键的键值对记录；
    * mapValues：对Pair RDD里每一个值应用一个函数，但是不会对键值进行操作；
    * combineByKey：使用不同的返回类型合并具有相同键的值；
    * subtractByKey：操作的RDD我们命名为RDD1，参数RDD命名为参数RDD，剔除掉RDD1里和参数RDD中键相同的元素；
    * join：对两个RDD进行内连接；
    * rightOuterJoin：对两个RDD进行连接操作，第一个RDD的键必须存在，第二个RDD的键不再第一个RDD里面有那么就会被剔除掉，相同键的值会被合并；
    * leftOuterJoin：对两个RDD进行连接操作，第二个RDD的键必须存在，第一个RDD的键不再第二个RDD里面有那么就会被剔除掉，相同键的值会被合并；
    * cogroup：将两个RDD里相同键的数据分组在一起
    *
    *
    *
    * =====================行动操作的API
    *
    * ﻿countByKey：对每个键的元素进行分别计数；
    * collectAsMap：将结果变成一个map；
    * lookup：在RDD里使用键值查找数据
    *
    *
    * >>>>>>>>>>>>>>>>>>不是很常用的api
    * =====转化操作的：
    * sample:对RDD采样；
    * =====行动操作：
    * take(num):返回RDD里num个元素，随机的；
    * top(num):返回RDD里最前面的num个元素，这个方法实用性还比较高；
    * takeSample：从RDD里返回任意一些元素；
    * sample：对RDD里的数据采样；
    * takeOrdered：从RDD里按照提供的顺序返回最前面的num个元素
    */


  /**
    * 将文件数据转换为map格式的数据
    */
  @Test
  def _testBase2_fileToMap: Unit = {
    val rddFile: RDD[(String, String)] = sc.textFile("file:///Users/liqiangpeng/Downloads/sparkdata.txt", 1).map { x => (x.split(",")(0), x.split(",")(1) + "," + x.split(",")(2)) }
    /**
      * map { x => (x.split(",")(0), x.split(",")(1) + "," + x.split(",")(2)) }
      * x.split(",")(0) 该函数将文本的一行数据以","切割并获取切割后得到的数组的第一个下标的数据                    当作key
      * x.split(",")(1) + "," + x.split(",")(2) 同上，获取切割后数组的第二个和第三个下标的数据，以逗号","分割    当作value
      * ...
      *
      * 最终所得数据:(1,Role97,16),(2,Role42,30),(3,Role87,41),(4,Role59,21),(5,Role26,54),(6,Role27,32),(7,Role22,15),(8,Role64,31),(9,Role7,46),(10,Role50,37),(11,Role30,64),(12,Role27,54),(13,Role3,37),(14,Role84,66),(15,Role48,25),(16,Role92,29),(17,Role77,85),(18,Role67,85),(19,Role41,16),(20,Role0,42),(21,Role64,85),(22,Role27,85),(23,Role84,59),(24,Role26,52),(25,Role27,59),(26,Role52,56)
      */
    val rFile: RDD[String] = rddFile.keys //getAllKey
    println("fileToMap>>>>>>>>" + rddFile.collect().mkString(",")) //1,2,3,4 ...
  }

  /**
    * 将内存中的数据转换为map格式的数据
    */
  @Test
  def _testBase2_cacheToMap: Unit = {
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("k01", 3), ("k02", 6), ("k02", 3), ("k03", 2), ("k01", 26), ("k01", 1)))
    val r: RDD[(String, Int)] = rdd.reduceByKey((x, y) => x + y)
    /**
      * 这里两个参数（x，y）逻辑上让他分别代表同一个key的两个不同values
      * k01的value值为：3，26，1
      * 所以x+y就是：
      * 3+26
      * 29+1
      *
      */
    println("cacheToMap>>>>>>>>" + r.collect().mkString(",")) //(k02,6),(k01,29),(k03,2)

  }

  @Test
  def _testBase2_transformation: Unit = {
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("k01", 3), ("k02", 6), ("k03", 2), ("k01", 26)))
    val other: RDD[(String, Int)] = sc.parallelize(List(("k01", 29)), 1)

    // ========================转化操作===============================
    val rddReduce: RDD[(String, Int)] = rdd.reduceByKey((x, y) => x + y)
    println("reduceByKey>>>>>>>>>>>>>>>>>>>>>>:" + rddReduce.collect().mkString(","))
    // (k01,29),(k03,2),(k02,6)

    val rddGroup: RDD[(String, Iterable[Int])] = rdd.groupByKey()
    println("rddGroup>>>>>>>>>>>>>>>>>>>>>>:" + rddGroup.collect().mkString(","))

    val rddKeys: RDD[String] = rdd.keys
    println("rddKeys>>>>>>>>>>>>>>>>>>>>>>:" + rddKeys.collect().mkString(","))

    val rddValues = rdd.values
    println("rddValues>>>>>>>>>>>>>>>>>>>>>>:" + rddValues.collect().mkString(","))

    val rddSortAsc = rdd.sortByKey(true, 1)
    val rddSortDes = rdd.sortByKey(false, 1)
    println("rddSortAsc>>>>>>>>>>>>>>>>>>>>>>:" + rddSortAsc.collect().mkString(","))
    println("rddSortDes>>>>>>>>>>>>>>>>>>>>>>:" + rddSortDes.collect().mkString(","))

    val rddFmVal: RDD[(String, Int)] = rdd.flatMapValues { x => List(x + 10) } //传一个函数，用于操作value，返回原key与新value
    println("rddFmVal>>>>>>>>>>>>>>>>>>>>>>:" + rddFmVal.collect().mkString(",")) //(k01,13),(k02,16),(k03,12),(k01,36)

    val rddMapVal: RDD[(String, Int)] = rdd.mapValues { x => x + 10 }
    println("rddMapVal>>>>>>>>>>>>>>>>>>>>>>:" + rddMapVal.collect().mkString(",")) //(k01,13),(k02,16),(k03,12),(k01,36)

    //TODO 看不懂这个函数？？？？？？
    val rddCombine: RDD[(String, (Int, Int))] = rdd.combineByKey(x => (x, 1), (param: (Int, Int), x) => (param._1 + x, param._2 + 1), (p1: (Int, Int), p2: (Int, Int)) => (p1._1 + p2._1, p1._2 + p2._2))
    println("rddCombine>>>>>>>>>>>>>>>>>>>>>>:" + rddCombine.collect().mkString(","))

    val rddSubtract: RDD[(String, Int)] = rdd.subtractByKey(other)
    println("rddSubtract>>>>>>>>>>>>>>>>>>>>>>:" + rddSubtract.collect().mkString(","))
    // (k03,2),(k02,6)

    val rddJoin: RDD[(String, (Int, Int))] = rdd.join(other)
    println("rddJoin>>>>>>>>>>>>>>>>>>>>>>:" + rddJoin.collect().mkString(","))
    // (k01,(3,29)),(k01,(26,29))

    val rddRight: RDD[(String, (Option[Int], Int))] = rdd.rightOuterJoin(other)
    println("rddRight>>>>>>>>>>>>>>>>>>>>>>:" + rddRight.collect().mkString(","))
    // (k01,(Some(3),29)),(k01,(Some(26),29))

    val rddLeft: RDD[(String, (Int, Option[Int]))] = rdd.leftOuterJoin(other)
    println("rddLeft>>>>>>>>>>>>>>>>>>>>>>:" + rddLeft.collect().mkString(","))
    // (k01,(3,Some(29))),(k01,(26,Some(29))),(k03,(2,None)),(k02,(6,None))

    val rddCogroup: RDD[(String, (Iterable[Int], Iterable[Int]))] = rdd.cogroup(other)
    println("rddCogroup>>>>>>>>>>>>>>>>>>>>>>:" + rddCogroup.collect().mkString(",")) // (k01,(CompactBuffer(3, 26),CompactBuffer(29))),(k03,(CompactBuffer(2),CompactBuffer())),(k02,(CompactBuffer(6),CompactBuffer()))

  }

  @Test
  def _testBae2_actin: Unit = {
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("k01", 3), ("k02", 6), ("k03", 2), ("k01", 26)))
    val resCountByKey = rdd.countByKey()
    println("resCountByKey>>>>>>>>>>>>>>>>>>>>>>:" + resCountByKey)
    // Map(k01 -> 2, k03 -> 1, k02 -> 1)

    val resColMap = rdd.collectAsMap()
    println("resColMap>>>>>>>>>>>>>>>>>>>>>>:" + resColMap)
    //Map(k02 -> 6, k01 -> 26, k03 -> 2)如果RDD中同一个Key中存在多个Value，那么后面的Value将会把前面的Value覆盖，最终得到的结果就是Key唯一，而且对应一个Value。

    val resLookup = rdd.lookup("k01")
    println("resLookup>>>>>>>>>>>>>>>>>>>>>>:" + resLookup) // WrappedArray(3, 26)
  }


  /*=========================================RDD复杂操作1===================================================*/















}
