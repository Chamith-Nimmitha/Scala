package q3

class Account(private val nic: String, val accNumber: Int,  var balance: Double) {

  def this(nic: String, accNumber: Int) = this(nic, accNumber, 0.0)

  //withdraw money
  def withdraw(amount: Double) = {
      this.balance -= amount;
      println(s"ACCOUNT ${this.accNumber} => Succefully withdraw $amount from acc: ${this.accNumber}")
  }

  // deposit money
  def deposit(amount: Double) = { this.balance += amount; println(s"ACCOUNT ${this.accNumber} => Succefully deposit $amount to acc: ${this.accNumber}") }

  //transfer money to given account
  def transfer(accNumber: Int, amount: Double) = {
    val findAcc = Banks.find(accNumber)
    if (findAcc.length == 1) {
      this.balance -= amount
      findAcc(0).deposit(amount)
      println(s"ACCOUNT ${this.accNumber} => Succefully transfer $amount from account ${this.accNumber} to account ${findAcc(0).accNumber}\n")
    } else {
      println("BANK => Account not found.\n")
    }
  }
  
  override def toString = s"ACCOUNT ${this.accNumber} => (Nic -> $nic, AccNumber -> $accNumber, Balanace -> $balance)"
}

object Account {

  def main(args: Array[String]) {

    val acc1 = Banks.createAcc("1", 1)
    acc1.deposit(500)
    val acc2 = Banks.createAcc("2", 2, 1000)
    acc2.withdraw(100)
    println("\n--------------Before transfer money------------")
    println(acc1)
    println(acc2)
    acc2.transfer(1, 500)

    println("\n--------------After transfer money------------")
    println(acc1)
    println(acc2)
  }
}