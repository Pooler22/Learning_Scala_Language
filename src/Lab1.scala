object Lab1 extends App {

  //Exercise 1
  def calculateExpression(x: List[String]): Int = x match {
    case x1 :: "+" :: x2 :: rest => calculateExpression((x1.toInt + x2.toInt).toString :: rest)
    case x1 :: "-" :: x2 :: rest => calculateExpression((x1.toInt - x2.toInt).toString :: rest)
    case x1 :: Nil => x1.toInt
    case _ => throw new NumberFormatException("allowed int numbers and + - operators")
  }

  //Exercise 2
  def isExcellentNumber(n:Int): Boolean ={
    var sum = 1
    for(x <- 2 to math.sqrt(n).toInt){
      if(n % x == 0){
        sum += x
        if(x*x != n){
          sum += n / x
        }
      }
    }
    sum == n
  }
};
