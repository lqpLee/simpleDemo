package org.lee.fastscala.eight

/**
  * Created by liqiangpeng on 2017/7/14.
  */
class SavingsAccount(initialBalance: Double) extends CheckingAccount(initialBalance) {

  private var num: Int = _

  def earnMonthluInterest() = {
    num = 3
    super.deposit(1)
  }

  override def deposit(amount: Double): Double = {
    num -= 1
    if(num<0) super.deposit(amount - 1) else super.deposit(amount)
  }

  override def withdraw(amount: Double): Double = {
    num -= 1
    if (num < 0) super.withdraw(amount + 1) else super.withdraw(amount)
  }

}
