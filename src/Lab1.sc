import scala.reflect.macros.ParseException

//import collection.immutable.ListMap

//Lab1.calculateExpression("-3 + 4 - 1 + 1 + 13 - 5 + 6".split(" ").toList)
//Lab1.calculateExpression("3 + 3".split(" ").toList)
//Lab1.calculateExpression("#Error".split(" ").toList)

//Lab1.isExcellentNumber(6)

//Vector[Int](6, 28, 496, 8128).foreach(x => println(Lab1.isExcellentNumber(x)))
//Vector[Int](5, 27, 495, 8127).foreach(x => println(Lab1.isExcellentNumber(x)))

//val n =6
//(1 to math.sqrt(n).toInt).reduce((x,y) => if(n%y == 0){ x+y + (if(y*y != n)  n / y else 0)} else x)

//Lab1.Deputy("Name", "Surname", 35, "PIS", "marszałek", List(Committee.Culture))
//
//var Deputies = List(
//  Lab1.Deputy("Name", "S", 35, "PIS", "szef klubu", List(Committee.Culture)),
//  Lab1.Deputy("Name", "K", 40, "PO", "wicemarszałek", List(Committee.Education, Committee.EU)),
//  Lab1.Deputy("Name", "D", 45, "PIS", "marszałek", List(Committee.Sports)),
//  Lab1.Deputy("Name", "F", 20, "PO", "szef klubu", List()),
//  Lab1.Deputy("Name", "S", 50, "PIS", "szef klubu", List(Committee.Culture, Committee.EU))
//)
//
////posłowie w wieku < 40 lat
//val age = 40
//val filter1: Lab1.Deputy => Boolean = _.Age > age
//Deputies.filter(filter1)
//  .foreach(println(_))
//
//// posłowie o nazwisku na literę z zakresu D..K,
//val regex = "[D-K].*".r
//val filter2: Lab1.Deputy => Boolean = (x) => {
//  regex.pattern.matcher(x.Surname).matches
//}
//Deputies.filter(filter2)
//  .foreach(println(_))
//
////todo: order?
//// posłowie uczestniczący w danej komisji
//Deputies.flatMap(_.Committees)
//  .map(y => y -> Deputies.filter(_.Committees.contains(y)))
//  .foreach(println)
//
//// posłowie uczestniczący w co najmniej 2 komisjach
//val commitionLimit = 2
//Deputies
//  .groupBy(_.Committees)
//  .filterKeys(_.length == commitionLimit)
//  .foreach(println(_))
//
////marszałek (sprawdź czy zwrócona kolekcja ma co najwyżej 1 element)
//val checkedDuty = "marszałek"
//val result = Deputies
//  .filter(_.Duty.equals(checkedDuty))
//  .foreach(println(_))
//
//
////exercise 4
//Lab1.exe1_extend(Vector())
//Lab1.exe1_extend(Vector("10"))
//Lab1.exe1_extend(Vector("10", "10"))
//Lab1.exe1_extend(Vector("10", "10", "10", "10"))
//Lab1.exe1_extend(Vector("10", "10", "10", "10", "10", "10"))
//

//todo tests + clean up code
//exercise 5
lazy val isCorrectLength: String => Boolean = _.length == 11
lazy val isAllDigits: String => Boolean = _ forall Character.isDigit

lazy val it = Iterator(1, 3, 7, 9, 1, 3, 7, 9, 1, 3)
lazy val isCorrectControlNumber: String => Boolean = s => s.substring(0, 10)
  .map(_.toString.toInt)
  .reduce(_ + _ * it.next()) % 10 ==
  s.substring(10).charAt(0).asDigit

lazy val getDate: String => String = (x) => {
  val year = x.substring(0, 2).toInt
  val month = x.substring(2, 4).toInt
  val day = x.substring(4, 6).toInt
  val century = month / 20 match {
    case 0 => 1900
    case 1 => 2000
    case 2 => 2100
    case 3 => 2200
    case 4 => 1800
  }
  day + "-" + (month % 20) + "-" + (century + year)
}

lazy val isCorrectDate: String => Boolean = (x)=>{
  val format = new java.text.SimpleDateFormat("dd-MM-yyyy")
  format.setLenient(false)
  try {
    format.parse(x)
    true
  }
  catch {
    case _: Throwable => false
  }
}

lazy val isWomen: String => Boolean = _.charAt(9) % 2 == 0

def getPESELData(x: String): String = {
  val date  = getDate(x)
  if(isCorrectLength(x)
    && isAllDigits(x)
    && isCorrectControlNumber(x)
    && isCorrectDate(date)
  ){
    "data urodzenia: " + date + " ,plec: " +
      (if (isWomen(x)) "kobieta" else "mezczyzna")
  }
  else{
    "PESEL nie jest poprawny"
  }
}

getPESELData("92100600550")
