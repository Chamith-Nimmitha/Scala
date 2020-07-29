package q3

object Banks {
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
  
}