package q4

class Account(private val nic: String, val accNumber: Int,  var balance: Double) {

  def this(nic: String, accNumber: Int) = this(nic, accNumber, 0.0)

  //withdraw money
  def withdraw(amount: Double) = {
    if (this.balance >= amount) {
      this.balance -= amount
      println(s"ACCOUNT => Succefully withdraw $amount from acc: ${this.accNumber}")
    } else {
      println("You don't have sufficient balance to do this transection.\n")
    }
  }

  // deposit money
  def deposit(amount: Double) = { this.balance += amount; println(s"ACCOUNT => Succefully deposit $amount to acc: ${this.accNumber}") }

  //transfer money to given account
  def transfer(accNumber: Int, amount: Double) = {
    val findAcc = Bank.find(accNumber)
    if (this.balance >= amount) {
      if (findAcc.length == 1) {
        this.balance -= amount
        findAcc(0).deposit(amount)
        println(s"ACCOUNT => Succefully transfer $amount from account ${this.accNumber} to account ${findAcc(0).accNumber}\n")
      } else {
        println("BANK => Account not found.\n")
      }
    } else {
      println("ACCOUNT => You don't have sufficient balance to do this transection.\n")
    }
  }
  
  override def toString = s"ACCOUNT => (Nic -> $nic, AccNumber -> $accNumber, Balanace -> $balance)"
}

object Account {

  def main(args: Array[String]) {

    val acc1 = Bank.createAcc("1", 1)
    acc1.deposit(500)
    val acc2 = Bank.createAcc("2", 2, 1000)
    acc2.withdraw(100)
    acc2.transfer(1, 500)
    println(acc1)
    println(acc2)
    Bank.totalBalance
    Bank.overdraft
    Bank.applyInterest
    println("\n--------------After aplly interest------------")
    println(acc1)
    println(acc2)
  }
}