package lab1

object Exe1 extends App {
  def calculateExpression(x: List[String]): Int = x match {
    case x1 :: "+" :: x2 :: rest => calculateExpression((x1.toInt + x2.toInt).toString :: rest)
    case x1 :: "-" :: x2 :: rest => calculateExpression((x1.toInt - x2.toInt).toString :: rest)
    case x1 :: Nil => x1.toInt
    case _ => throw new NumberFormatException("allowed int numbers and + - operators")
  }

  calculateExpression("-3 + 4 - 1 + 1 + 13 - 5 + 6".split(" ").toList)
  calculateExpression("3 + 3".split(" ").toList)
  calculateExpression("#Error".split(" ").toList)
}
