
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

  //Exercise 3
  //Commitiee enum in Committee.scala file
  case class Deputy(name: String, surname: String, age: Int, party: String, duty: String, committees: List[Committee.Value]) {
    var Name: String = name
    var Surname: String = surname
    var Age: Int = age
    var Party: String = party
    var Duty: String = duty
    var Committees: List[Committee.Value] = committees

  }

};



