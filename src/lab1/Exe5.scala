package lab1

object Exe5 extends App {
  def getPESELData(y: String): String = {
    lazy val isCorrectLength: String => Boolean = _.length == 11

    lazy val isAllDigits: String => Boolean = _ forall Character.isDigit

    lazy val it = Iterator(1, 3, 7, 9, 1, 3, 7, 9, 1, 3)
    lazy val isCorrectControlNumber: String => Boolean = s => s.substring(0, 10)
      .map(_.toString.toInt)
      .reduce(_ + _ * it.next()) % 10 == s.substring(10).charAt(0).asDigit

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

    lazy val isCorrectDate: String => Boolean = (x) => {
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

    val date = getDate(y)
    y match {
      case x if isCorrectLength(x) && isAllDigits(x) && isCorrectControlNumber(x) && isCorrectDate(date) =>
        "data urodzenia: " + date + " ,plec: " + (if (isWomen(x)) "kobieta" else "mezczyzna")
      case _ => "PESEL nie jest poprawny"
    }
  }

  println("94100630450: " + getPESELData("94100630450"))
  println("92100600550: " + getPESELData("92100600550"))
}
