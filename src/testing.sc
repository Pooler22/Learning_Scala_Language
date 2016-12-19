//  object Password{
//    def isCorrectMinLen(password:String)(min_len:Integer):Boolean = password.length >= min_len
//    def isCorrectMaxLen(password:String)(max_len:Integer):Boolean = password.length <= max_len
//  }
//
//
//  Password.isCorrectMaxLen("asd")(4)
//
//"aAd".filter(_.isUpper).length
//
//val a: Boolean = Boolean =>  true



math.round("123.1".toFloat).toString

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









//implicit def listToBetterList[T](s: List[T]): BetterList[T] = new BetterList(s)
//
//class BetterList[T](val self: List[T]) {
//  def size: Integer = 0
//}
//
//object MyList extends BetterList
//
//val list = List(1, 2, 3, 5, 7, 11)
//val list2 = BetterList