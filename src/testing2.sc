object HelloWorld {
  import scala.collection.mutable.ArrayBuffer
  def main(args: Array[String]) {
    val test4:Array[String]=Array("styczen","2.4","232","0.5","23","1","122")
    formatline(test4)
  }

  def formatline(line: Array[String]): String =
  {
    var result:String=""
    line match
    {
      case Array(a,b,c) => result+=(a+"+"+b+"="+c);
      case Array(a,_*)  => result+=(a+"+"+formatline(line.tail));
      case _            => ""
    }
    result
  }
  def roundline(line: Array[String]): ArrayBuffer[String] =
  {
    import scala.collection.mutable.ArrayBuffer
    var result1 = new java.util.ArrayList[Double]
    var result2 = ArrayBuffer[String]()

    1 until line.lengthforeach{ i=>

      result1.add(line(i).toDouble)
      //println(line(i).toDouble)
    }

    println(result1)
    0 until result1.sizeforeach{ i=>

      result2+=BigDecimal(result1.get(i)).setScale(0, BigDecimal.RoundingMode.HALF_UP).toString
      //println(line(i).toDouble)
    }
    result2.prepend(line(0))
    println(result2)

    return result2
  }


  val test4:Array[String]=Array("styczen","2.4","232","0.5","23","1","122")
  formatline(test4)

}