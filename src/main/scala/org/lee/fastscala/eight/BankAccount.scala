package org.lee.fastscala.eight

/**
  * Created by liqiangpeng on 2017/7/14.
  */
class BankAccount(initialBalance: Double) {

  private var balance = initialBalance

  def deposit(amount: Double) = {
    balance += amount
    balance
  }

  def withdraw(amount: Double) = {
    balance -= amount
    balance
  }

}
