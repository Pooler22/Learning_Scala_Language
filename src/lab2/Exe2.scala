package lab2

import java.io.FileNotFoundException

object Exe2 extends App {
  class CSVFileFormatter(path: String) {

    def roundStr(x: String): String = math.round(x.toFloat).toString

    def toLeftStr(x: String, move: Int): String = "%-" + move + "s"

    def toRightStr(x: String, move: Int): String = "%" + move + "s"

    def getLargestNumber(a: Int, b: Int): Int = if (a > b) a else b

    def getLargestNumbers(a: List[Int], b: List[Int]): List[Int] = a.zip(b).map(x => getLargestNumber(x._1, x._2))

    def getFormatedData: String = {
      var maxWidthColList = List(0, 0, 0, 0)
      var result: List[String] = Nil

      try {

        val loadedData = io.Source.fromFile(path)
        val data = loadedData.getLines.drop(1).map(_.split(",").map(_.trim()).toList).toList

        data.foreach {
          case (x1 :: x2 :: x3 :: x4 :: Nil) =>
            maxWidthColList = getLargestNumbers(maxWidthColList, List(x1.length, roundStr(x2).length, roundStr(x3).length, roundStr(x4).length))
        }

        result = data.map {
          case x1 :: x2 :: x3 :: x4 :: rest =>
            f"${toLeftStr(x1, maxWidthColList.head).format(x1)} : ${toRightStr(x1, maxWidthColList(1)).format(roundStr(x2))} - ${toRightStr(x1, maxWidthColList(2)).format(roundStr(x3))} = ${toRightStr(x1, maxWidthColList(3)).format(roundStr(x4))} ${rest mkString " "}" + "\n"
          case undefined => undefined mkString " "
        }

        loadedData.close
      } catch {
        case _: FileNotFoundException => Iterator("File does not exist")
        case _ => Iterator("An unexpected error has occurred")
      }
      result mkString ""
    }
  }

  val path = "C:\\Users\\pooler\\IdeaProjects\\jispdr\\src\\lab2\\jispdr-wydatki.csv"
  var data = new CSVFileFormatter(path)
  print(data.getFormatedData)
}
