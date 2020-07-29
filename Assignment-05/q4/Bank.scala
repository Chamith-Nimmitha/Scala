package q4

object Bank {
  // List of all account
  var accList: List[Account] = List()
  
  // create new account
  def createAcc(nic: String, n: Int, a: Double = 0.0) = {
    val acc = new Account(nic, n, a)
    accList = accList ::: acc :: Nil
    println(s"BANK => Account(nic:$nic, accNumber:$n, Balance:$a) creation successful.")
    acc
  }
  
  //find acc for money transaction
  def find(accNumber: Int) = accList.filter(x => x.accNumber.equals(accNumber))
  
  // find overdraft acc
   def overdraft = println(s"BANK => Overdraft accounts :  ${accList.filter(acc => acc.balance <0)} ")
  
//  def totalBalance(bank: List[Account]) = bank.reduceLeft((x,y) => {new Account("9999999",9999999,x.balance + y.balance); })
  def totalBalance =  println(s"BANK => Total balance :  ${accList.foldLeft(0.0)((x,y) => x + y.balance)}")
  
  def applyInterest = {accList.foreach( x => {if (x.balance>0) x.balance*=1.05 else x.balance * 0.9}); println("BANK => Interest applied..")}
}