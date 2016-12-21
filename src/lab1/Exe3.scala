package lab1

object Exe3 extends App {

  object Committee extends Enumeration {
    val Education, Culture, Sports, EU = Value

    override def toString() =
      this match {
        case Education => "Education"
        case Culture => "Culture"
        case Sports => "Sports"
        case EU => "EU"
      }
  }

  case class Deputy(name: String, surname: String, age: Int, party: String, duty: String, committees: List[Committee.Value]) {
    var Name: String = name
    var Surname: String = surname
    var Age: Int = age
    var Party: String = party
    var Duty: String = duty
    var Committees: List[Committee.Value] = committees

    override def toString = "" + Name + "\t" + Surname + "\t" + Age + "\t" + Party + "\t" + Duty + "\t" + (Committees mkString ",")
  }

  var DeputiesData = List(
    Deputy("A", "S", 35, "PIS", "szef klubu", List(Committee.Culture)),
    Deputy("B", "K", 40, "PO", "wicemarszałek", List(Committee.Education, Committee.EU)),
    Deputy("C", "D", 45, "PIS", "marszałek", List(Committee.Sports)),
    Deputy("D", "F", 20, "PO", "szef klubu", List()),
    Deputy("E", "S", 50, "PIS", "szef klubu", List(Committee.Culture, Committee.EU))
  )

  println("posłowie w wieku < 40 lat")
  val age = 40
  val filter1: Deputy => Boolean = _.Age < age
  DeputiesData
    .filter(filter1)
    .foreach(println(_))
  println()

  println("posłowie o nazwisku na literę z zakresu D..K,")
  val regex = "[D-K].*".r
  val filter2: Deputy => Boolean = (x) => {
    regex.pattern.matcher(x.Surname).matches
  }
  DeputiesData
    .filter(filter2)
    .foreach(println(_))
  println()

  println("posłowie uczestniczący w danej komisji")
  DeputiesData
    .flatMap(_.Committees)
    .map(y => y -> DeputiesData.filter(_.Committees.contains(y)))
    .foreach(p => println("Komisja:  " + p._1 + ",\nPosłowie:\n\t" + (p._2 mkString ",\n")))
  println()

  println("posłowie uczestniczący w co najmniej 2 komisjach")
  val commitionLimit = 2
  DeputiesData
    .groupBy(_.Committees)
    .filterKeys(_.length >= commitionLimit)
    .foreach(p => println("Komisje:  " + (p._1 mkString ", ") + ",\nPosłowie:\n\t" + (p._2 mkString ",\n")))
  println()

  println("marszałek (sprawdź czy zwrócona kolekcja ma co najwyżej 1 element)")
  val checkedDuty = "marszałek"
  DeputiesData
    .filter(_.Duty.equals(checkedDuty))
    .foreach(println(_))
  println()

}