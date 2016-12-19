package lab2

object Exe2 extends App {
  val loadedData = io.Source.fromFile("C:\\Users\\pooler\\IdeaProjects\\jispdr\\src\\lab2\\jispdr-wydatki.csv")

  def roundStr: String => String = (x) => {math.round(x.toFloat).toString}

  def calculate(x: List[String]): String = x match {
    case x1 :: x2 :: x3 :: x4 :: Nil  => f"$x1 : ${roundStr(x2)} - ${roundStr(x3)} = ${roundStr(x4)}"
    case x1 :: x2 :: x3 :: x4 :: rest => f"$x1 : ${roundStr(x2)} - ${roundStr(x3)} = ${roundStr(x4)}, rest: ${rest mkString " "}"
    case x1 => x1.toString()
  }

  var data = loadedData.getLines.drop(1)
  data.foreach(x=>println(calculate(x.split(",").toList)))
  calculate(List("1","2","3","4","5"))
  calculate(List("test","errot"))

  loadedData.close
}
