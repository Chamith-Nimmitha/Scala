

object Question2 {

  def attendance(ticket_price: Int): Int = 120 + (15 - ticket_price) / 5 * 20;

  def income(ticket_price: Int): Int = attendance(ticket_price) * ticket_price;

  def cost(ticket_price: Int): Int = 500 + attendance(ticket_price) * 3;

  def profit(ticket_price: Int): Int = {
    return income(ticket_price) - cost(ticket_price);
  }

  var result: Int = 0;
  var tmp: Int = 0;

  for (i: Int <- 1 to 8) {
    if (tmp < profit(i * 5)) {
      tmp = profit(i * 5);
      result = i * 5;
    }
  }
  print(result)

}