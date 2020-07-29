package q1

class RationalNumber( x:Int, y:Int) {
  require(y>0, "Denominator must be positive")
  def numer = x;
  def denom = y;
  def neg = new RationalNumber(-this.numer,this.denom)   
  
  override def toString = this.numer + "/" + this.denom
}

object RationalNumber{
  
  def main(args: Array[String]){
    val num1 = new RationalNumber(1,2)
    println("Before : " + num1)
    println("After neg : " + num1.neg)

  }
}