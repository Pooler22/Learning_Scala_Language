package lab2

object Exe1 extends App  {
  object Password{
    def isCorrectMinLen(password:String)(min_len:Integer):Boolean = password.length >= min_len
    def isCorrectMaxLen(password:String)(max_len:Integer):Boolean = password.length <= max_len
    def isCorrectUppercaseLetterCount(password:String)(count:Integer):Boolean = { password.filter(_.isUpper).length == count}
    def isCorrectLowercaseLetterCount(password:String)(count:Integer):Boolean = { password.filter(_.isLower).length == count}

//    def check(password:String,listExpressions List[a=>Boolean]]):Boolean ={
//      true
//    }
  }

  Password.isCorrectMaxLen("asd")(4)
}
