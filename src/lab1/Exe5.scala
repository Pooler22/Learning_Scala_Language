package lab1

object Exe5 extends App {
  def getPESELData(y: String): String = {
    val isCorrectLength: String => Boolean = _.length == 11

    val isAllDigits: String => Boolean = _ forall Character.isDigit

    val it = Iterator(1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1)
    val isCorrectControlNumber: String => Boolean = s => "0".concat(s)
      .map(_.toString.toInt)
      .reduce(_ + _ * it.next()) % 10 == 0

    val getDate: String => String = (x) => {
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

    val isCorrectDate: String => Boolean = (x) => {
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

    val isWomen: String => Boolean = _.charAt(9) % 2 == 0

    val date = getDate(y)
    y match {
      case x if isCorrectLength(x) && isAllDigits(x) && isCorrectControlNumber(x) && isCorrectDate(date) =>
        "data urodzenia: " + date + " ,plec: " + (if (isWomen(x)) "kobieta" else "mezczyzna")
      case _ => "PESEL nie jest poprawny"
    }
  }

  println("Correct: 92100600055: " + getPESELData("92100600055"))
  println("Error: 94100630450: " + getPESELData("94100630450"))
}
