package q2

class RationalNumber(x:Int, y:Int) {
  
  require(y>0, "Denominator must be positive")
  
  // find gcd for simplify
  def gcd(a:Int,b:Int):Int = {
    val c = {if (a <0) -a else a}
    if (b==0) a else this.gcd(b,c%b)
  }
  
  // simplify when constructing the RationalNumber object 
   val g = gcd(x,y)
   var numer = x/g;
   var denom = y/g;
  
  // return new RationalNumber object which contain negative of this
  def neg = new RationalNumber(-this.numer,this.denom)   
  
  def +(that:RationalNumber) = 
    new RationalNumber(this.numer * that.denom + this.denom * that.numer , this.denom * that.denom)
  
  //subtract two RationalNumbers
  def -(that:RationalNumber) = new RationalNumber(this.numer * that.denom - this.denom * that.numer , this.denom * that.denom)

  
  //return rational number
  override def toString = {this.numer + "/" + this.denom}
}

object RationalNumber{
  
  def main(args: Array[String]){
    val x = new RationalNumber(3,4)
    val y = new RationalNumber(5,8)
    val z = new RationalNumber(2,7)
    println(s"Subtract =>  (${x} - ${y} - ${z}) = ${(x-y-z)}")
  }
}