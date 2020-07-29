package q3

class Account(private val nic: String, val accNumber: Int, private var balance: Double) {

  def this(nic: String, accNumber: Int) = this(nic, accNumber, 0.0)

  //withdraw money
  def withdraw(amount: Double) = {
    if (this.balance >= amount) {
      this.balance -= amount
      println(s"Succefully withdraw $amount from acc: ${this.accNumber}")
    } else {
      println("You don't have sufficient balance to do this transection.\n")
    }
  }

  // deposit money
  def deposit(amount: Double) = {this.balance += amount; println(s"Succefully deposit $amount to acc: ${this.accNumber}")}

  //find acc for money transaction
  def find(accNumber: Int, aList: List[Account]) = aList.filter(x => x.accNumber.equals(accNumber))

  //transfer money to given account
  def transfer(accNumber: Int, amount: Double, aList: List[Account]) = {
    val findAcc = this.find(accNumber, aList)
    if (this.balance >= amount) {
      if (findAcc.length == 1) {
        this.balance -= amount
        findAcc(0).deposit(amount)
        println(s"Succefully transfer $amount from ${this.accNumber} to ${findAcc(0).accNumber}\n")
      } else {
        println("Account not found.\n")
      }
    }else{
       println("You don't have sufficient balance to do this transection.\n")
    }
  }

  override def toString = s"Nic : $nic, AccNumber : $accNumber, Balanace : $balance"
}

object Bank {
  
  var bank: List[Account] = List()
  
  def createAcc(nic:String, n: Int, a:Double=0.0) ={
    val acc = new Account(nic, n,a)
    bank = bank ::: acc :: Nil
    println("Account creation successful.")
    acc
  }
  
  def main(args: Array[String]) {   

    val acc1 = createAcc("1",1)
    acc1.deposit(500)
    val acc2 = createAcc("2",2,1000)
    acc2.withdraw(100)
    acc2.transfer(1, 500, bank)
    println(acc1)
    println(acc2)
  }
}