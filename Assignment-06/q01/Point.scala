package q01
import scala.math.pow
import scala.math.sqrt

case class Point(var x:Int,var y:Int) {
  
  def +(p:Point):Point = new Point(this.x+p.x , this.y+p.y);
  
  def move(dx:Int, dy:Int): Unit = {this.x +=dx; this.y +=dy;}
  
  def distance(p:Point):Double = sqrt(pow((this.x - p.x),2)+pow((this.y - p.y),2));
  
  def invert:Unit = {this.x +=this.y; this.y = this.x - this.y; this.x -=this.y}
  
}


object Main{
 
  def main(args:Array[String]){
    //define points
    val p1 = Point(2,2);
    println(s"P1 : $p1");
    val p2 = Point(3,8);   
    println(s"P2 : $p2");
    
    //add two points
    println(s"Add => P1 + P2 = ${p1+p2}");
    
    //move point
    p2.move(2, -2);
    println(s"Move P2  by (2,-2) : P2 = $p2");
    
    //get distance between two points
    println(s"Distance between P1 and P2 = ${p1.distance(p2)}");
    
    // Invert a point    
    p2.invert
    println(s"Invert of P2 = $p2");
  }
}