import java.lang.System
/**
  * Created by liqiangpeng on 2017/7/14.
  */
object TestSystem extends App{

  var password = Console.readLine()

  if(password equals "secret") System.out.println("Hello "+System.getProperty("user.name"))

  else System.err.println("password error!")

}
