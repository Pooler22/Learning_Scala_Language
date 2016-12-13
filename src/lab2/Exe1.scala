package lab2

object Exe1 extends App  {
  object Password{
    def isCorrectMinLen(password:String)(min_len:Integer):Boolean = password.length >= min_len
    def isCorrectMaxLen(password:String)(max_len:Integer):Boolean = password.length <= max_len
//    def isCorrectUppercaseLetterCount(password:String):Boolean =>
//    def isCorrectLowercaseLetterCount(password:String):Boolean =>

    def check(password:String,expressions => Boolean): Boolean ={

    }
  }

  Password.check()
}
