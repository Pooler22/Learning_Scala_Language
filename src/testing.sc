import scala.xml.XML
val xml = XML.load("C:\\Users\\pooler\\workspace\\jispdr_lab\\src\\lab1\\studenci.xml")

//
//val cache = collection.mutable.Map[String, List[String]]()
//
//
//var a = ("1" -> List(List("asd") ++ cache.get("1").get))



//cache += ("1" ->List("asd") ++ cache("1"))
//cache.get("1")

//var mapResult:Map[String,String]
//var a = (xml \ "student").map{
//  case x if (x \ "znajomy").length == 0 => mapResult += ("zero.xlm" -> x)
//  case x if (x \ "znajomy").length == 1 => mapResult += ("one.xlm" -> x)
//  case x if (x \ "znajomy").length == 2 => mapResult += ("two.xlm" -> x)
//  case x if (x \ "znajomy").length == 3 => mapResult += ("three.xlm" -> x)
//  case x if (x \ "znajomy").length > 3 => mapResult += ("many.xlm" -> x)
//}
//
//mapResult.foreach(p => println("Plik:  " + p._1 + ",\nwartosci:\n\t" + (p._2 mkString "\n")))


//def saveToFile(fileName:String): Unit ={
//
//}

//(xml \ "student").foreach(e => println((e \ "znajomy").length))