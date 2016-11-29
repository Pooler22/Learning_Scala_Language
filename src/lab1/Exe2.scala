package lab1

object Exe2 extends App {
  //Version 1
  def isExcellentNumber_v1(n: Int): Boolean = {
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

  //Version 2
  def isExcellentNumber_v2(n: Int): Boolean = {
    n == (1 to math.sqrt(n).toInt).reduce((x, y) => if (n % y == 0) {
      x + y + (if (y * y != n) n / y else 0)
    } else x)
  }

  val vector1 = Vector[Int](6, 28, 496, 8128)
  println("vector:" + vector1 + " ,result:")
  vector1.foreach(x => println("Is Excellent: " + isExcellentNumber_v2(x)))

  val vector2 = Vector[Int](5, 34, 324, 2346)
  println("vector:" + vector2 + " ,result:")
  vector2.foreach(x => println("Is Excellent: " + isExcellentNumber_v2(x)))
}
