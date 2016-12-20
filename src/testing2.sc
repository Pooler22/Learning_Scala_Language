var maxList = List(0,0,0)



def roundStr: String => String = x => math.round(x.toFloat).toString

def calculate(x: List[String]): String = x match {
  case x1 :: x2 :: x3 :: x4 :: rest => f"$x1 : ${roundStr(x2)} - ${roundStr(x3)} = ${roundStr(x4)} ${rest mkString " "}"
  case x => x mkString " "
}

def getLargestNumber(a:Int, b:Int): Int = if (a > b) a else b

def getLargestNumbers(a:List[Int], b:List[Int]):List[Int] = a.zip(b).map(x => getLargestNumber(x._1,x._2))


val path = "C:\\Users\\pooler\\IdeaProjects\\jispdr\\src\\lab2\\jispdr-wydatki.csv"
val loadedData = io.Source.fromFile(path)
loadedData.getLines.drop(1).foreach(println(_))
val data = loadedData.getLines.drop(1).map(_.split(",").toList)

//  data.foreach { case (x1 :: x2 :: x3 :: x4 :: Nil) => maxList = getLargestNumbers(maxList, List(x2.length, x3.length, x4.length)) }
var result = data.foreach(calculate(_) + "\n").toString
loadedData.close
result

calculate(List("1", "2", "3", "4", "5"))
calculate(List("test", "errot"))