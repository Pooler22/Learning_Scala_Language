package lab1

object Exe4 extends App {
  lazy val exe: List[String] => String = {
    case x1 :: x2 :: Nil => x1 + " i " + x2
    case x1 :: rest => x1 + " , " + exe(rest)
    case x1 :: Nil => x1
    case _ => ""
  }

  lazy val exeAddBrackets: Vector[String] => String = x => "{" + exe(x.toList) + "}"


  println(exeAddBrackets(Vector()))
  println(exeAddBrackets(Vector("10")))
  println(exeAddBrackets(Vector("10", "10")))
  println(exeAddBrackets(Vector("10", "10", "10", "10")))
  println(exeAddBrackets(Vector("10", "10", "10", "10", "10", "10")))
}
