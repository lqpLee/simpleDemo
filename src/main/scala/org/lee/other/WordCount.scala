package org.lee.other

import org.apache.spark.{SparkConf, SparkContext}


/**
  * 经典的spark计算
  *
  *使用yarn执行代码：
  * ./spark-submit --master yarn --class org.lee.simpleDemo.WordCount  /Library/workspace/simpleDemo/out/artifacts/simpleDemo_jar/simpleDemo.jar  local[1] hdfs:/lee/Hamlet.txt hdfs:/lee/WordCount2
  */
object WordCount {
  def main(args: Array[String]) {
    var masterUrl, inputPath, outputPath = ""
    if (args.length == 0) {
      masterUrl = "local[1]"
      inputPath = "hdfs://localhost:/lee/Hamlet.txt"
      outputPath = "hdfs://localhost:/lee/WordCount5"
    } else if (args.length == 3) {
      masterUrl = args(0)
      inputPath = args(1)
      outputPath = args(2)
    } else {
      println("====================  参数传入错误  ===================")
      return
    }
    println(s"masterUrl:${masterUrl}, inputPath: ${inputPath}, outputPath: ${outputPath}")

    val sparkConf = new SparkConf().setMaster(masterUrl).setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    val rowRdd = sc.textFile(inputPath)
    val resultRdd = rowRdd.flatMap(line => line.split("\\s+"))//与map类似，区别是原RDD中的元素经map处理后只能生成一个元素，而原RDD中的元素经flatmap处理后可生成多个元素来构建新RDD。
      .map(word => (word, 1))//对RDD中的每个元素都执行一个指定的函数来产生一个新的RDD。任何原RDD中的元素在新RDD中都有且只有一个元素与之对应。
      .reduceByKey(_ + _)//对元素为KV对的RDD中Key相同的元素的Value进行reduce

    resultRdd.take(20).foreach(println)
    resultRdd.saveAsTextFile(outputPath)
  }
}
