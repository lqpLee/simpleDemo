package org.lee.fastscala.seven

/**
  * Created by liqiangpeng on 2017/7/14.
  */
package org{
  class T1 {}

  package lee{
    class T2(t:T1)

    package fastscala{
      class T3(t1:T1,t2:T2){}
    }
  }

}
import org._
class T4(t1:T1)

