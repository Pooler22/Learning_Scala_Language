package lab2

object Exe2 extends App {
  class CSVFileFormatter(path:String){
    var maxList = List(0,0,0,0)

    def roundStr: String => String = x => math.round(x.toFloat).toString

    def toLeftStr: String => String = x => x + "%-" + 8 + "s"
    def toRightStr: String => String = x => x + "%" + 8 + "s"

    def calculate(x: List[String]): String = x match {
      case x1 :: x2 :: x3 :: x4 :: rest => f"${formatStr(x1).format(x1)} : ${roundStr(x2)}%5s - ${roundStr(x3)}%5s = ${roundStr(x4)}%4s ${rest mkString " "}"
      case x => x mkString " "
    }

    def getLargestNumber(a:Int, b:Int): Int = if (a > b) a else b

    def getLargestNumbers(a:List[Int], b:List[Int]):List[Int] = a.zip(b).map(x => getLargestNumber(x._1,x._2))

    def getFormatedData():String ={
      val loadedData = io.Source.fromFile(path)
      val data = loadedData.getLines.drop(1).map(_.split(",").map(x => x.trim()).toList).toList

      data.foreach { case (x1 :: x2 :: x3 :: x4 :: Nil) =>
        maxList = getLargestNumbers(maxList, List(x1.length,roundStr(x2).length, roundStr(x3).length, roundStr(x4).length)) }
      var result = data.map(calculate(_)+"\n")

      loadedData.close

      result mkString ""
    }
  }


  val path = "C:\\Users\\pooler\\IdeaProjects\\jispdr\\src\\lab2\\jispdr-wydatki.csv"
  var data = new CSVFileFormatter(path)
  printf(data.getFormatedData())

//  a.calculate(List("1", "2", "3", "4", "5"))
//  a.calculate(List("test", "errot"))
}
