package lab2

object Exe1 extends App  {
  class PasswordChecker{
    val isCorrectMinLen: String => Integer => Boolean = password => min_len => password.length >= min_len
    val isCorrectMaxLen: String => Integer => Boolean = password => max_len => password.length <= max_len
    val isCorrectUppercaseLetterCount:String => Integer => Boolean = password => count =>  password.filter(_.isUpper).length == count
    val isCorrectLowercaseLetterCount:String => Integer => Boolean = password => count =>  password.filter(_.isLower).length == count
    val isCorrectDigitCount: String => Integer => Boolean = password => count => password.filter(_.isDigit).length == count
  }

  abstract class PasswordCheckerBuilder{
    var pc = new PasswordChecker()
    var expressions:Map[String=> Integer => Boolean, Integer] = Map()

    def prepareConditions()
    def checkPassword(password:String):Boolean = expressions.dropWhile(x=> x._1(password)(x._2)).isEmpty
  }

  object SamplePasswordChecker extends PasswordCheckerBuilder{
    def prepareConditions(): Unit = {
      expressions = Map((pc.isCorrectMinLen,2),(pc.isCorrectMaxLen,10),(pc.isCorrectDigitCount,2))
    }
  }
  SamplePasswordChecker.prepareConditions()
  println(SamplePasswordChecker.checkPassword("asd12"))
  assert (SamplePasswordChecker.checkPassword("asd12") == true)

  SamplePasswordChecker.prepareConditions()
  println(SamplePasswordChecker.checkPassword("asd12"))
  assert (SamplePasswordChecker.checkPassword("error") == false)


  object Sample2PasswordChecker extends PasswordCheckerBuilder{
    def prepareConditions(): Unit = {
      expressions = Map((pc.isCorrectUppercaseLetterCount,2),(pc.isCorrectLowercaseLetterCount,2),(pc.isCorrectDigitCount,2))
    }
  }

  Sample2PasswordChecker.prepareConditions()
  println(Sample2PasswordChecker.checkPassword("AAbb11"))
  assert (Sample2PasswordChecker.checkPassword("AAbb11") == true)

  Sample2PasswordChecker.prepareConditions()
  println(Sample2PasswordChecker.checkPassword("error"))
  assert (Sample2PasswordChecker.checkPassword("error") == false)
}
