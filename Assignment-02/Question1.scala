

object Question1 {

  def normalWork(hours: Int): Double = hours * 150;

  def OT(hours: Int): Double = hours * 75;

  def income(normalH: Int, otH: Int): Double = {
    return normalWork(normalH) + OT(otH);
  }

  def tax(income: Double): Double = income * 0.1;

  def homeSalary(normalH: Int, otH: Int): Double = {
    return income(normalH, otH) - tax(income(normalH, otH));
  }

  printf("%.2f", homeSalary(40, 20))
}