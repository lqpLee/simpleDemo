package org.lee.simpleDemo

import org.apache.spark.{SparkConf, SparkContext}


/**
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
    val resultRdd = rowRdd.flatMap(line => line.split("\\s+"))
      .map(word => (word, 1)).reduceByKey(_ + _)

    resultRdd.take(20).foreach(println)
    resultRdd.saveAsTextFile(outputPath)
  }
}
