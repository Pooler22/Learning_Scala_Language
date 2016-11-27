object Lab1 extends App {

  //Exercise 1
  def calculateExpression(x: List[String]): Int = x match {
    case x1 :: "+" :: x2 :: rest => calculateExpression((x1.toInt + x2.toInt).toString :: rest)
    case x1 :: "-" :: x2 :: rest => calculateExpression((x1.toInt - x2.toInt).toString :: rest)
    case x1 :: Nil => x1.toInt
    case _ => throw new NumberFormatException("allowed int numbers and + - operators")
  }

  //Exercise 2  version 1
  def isExcellentNumber(n: Int): Boolean = {
    var sum = 1
    for (x <- 2 to math.sqrt(n).toInt) {
      if (n % x == 0) {
        sum += x
        if (x * x != n) {
          sum += n / x
        }
      }
    }
    sum == n
  }

  //Exercise 2 version 2
  def isExcellentNumber_v2(n: Int): Boolean = {
    n == (1 to math.sqrt(n).toInt).reduce((x, y) => if (n % y == 0) {
      x + y + (if (y * y != n) n / y else 0)
    } else x)
  }
};
