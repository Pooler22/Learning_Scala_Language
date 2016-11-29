package lab1

import scala.xml.XML

object Exe6 extends App {
  def saveToFile(fileName: String, students: scala.xml.NodeSeq): Any = {
    println(fileName)
    println(students)
    scala.xml.XML.save(fileName, <studenci>
      {students}
    </studenci>, "UTF-8", xmlDecl = true, null)
  }

  def getFileName(x: Int): String = x match {
    case i if i == 0 => "zero.xlm"
    case i if i == 1 => "one.xlm"
    case i if i == 2 => "two.xlm"
    case i if i == 3 => "three.xlm"
    case i if i > 3 => "many.xlm"
  }

  var pathFile = "C:\\Users\\pooler\\workspace\\jispdr_lab\\src\\lab1\\studenci.xml"
  (XML.load(pathFile) \ "student")
    .groupBy(x => (x \ "znajomy").length)
    .foreach(x =>
      saveToFile(
        getFileName(x._1),
        x._2.sortBy(y => y \ "student" \@ "ur").reverse))

}
