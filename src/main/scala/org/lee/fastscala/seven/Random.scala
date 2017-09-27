/**
  * Created by liqiangpeng on 2017/7/14.
  */
package random {

  package object Random {

    var seed: Int = _

    val a = BigDecimal(1664525)

    val b = BigDecimal(1013904223)

    val n = 32


    def nexInt(): Int = {
      val temp = (seed * a + b) % BigDecimal(2).pow(n)

      seed = temp.toInt

      seed
    }

    def nextDouble(): Double = {
      val temp = (seed * a + b) % BigDecimal(2).pow(n)

      seed = temp.toInt

      temp.toDouble
    }


  }

}

package test {

  import random.Random

  object Test extends App {

    Random.seed = 4

    println(Random.nextDouble())
    println(Random.nextDouble())
    println(Random.nextDouble())
    println(Random.nextDouble())

    println(Random.nexInt())
    println(Random.nexInt())
    println(Random.nexInt())
    println(Random.nexInt())
  }

}

