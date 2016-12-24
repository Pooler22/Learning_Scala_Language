package lab3

object Exe1and2 extends App {

  implicit class MyHelper[S](list: List[S]) {
    def my_map[R](f: S => R): List[R] = {
      list match {
        case head :: tail => f(head) :: tail.my_map(f)
        case _ => Nil
      }
    }

    def my_filter(f: S => Boolean): List[S] = {
      list match {
        case head :: tail => if (f(head)) head :: tail.my_filter(f) else tail.my_filter(f)
        case _ => Nil
      }
    }

    def my_forall(f: S => Boolean): Boolean = {
      list match {
        case head :: tail => if (f(head)) tail.my_forall(f) else false
        case _ => true
      }
    }

    def my_exists(f: S => Boolean): Boolean = {
      list match {
        case head :: tail => if (f(head)) true else tail.my_exists(f)
        case _ => false
      }
    }
  }

  var list: List[Integer] = List(1, 2, 3, 4, 5, 6) //> list  : List[Integer] = List(1, 2, 3, 4, 5, 6)

  var expressionMap: Integer => Integer = x => x * 2
  list.map(expressionMap).foreach(println(_)) //> 24681012
  list.my_map(expressionMap).foreach(println(_)) //> 24681012
  assert(list.map(expressionMap) == list.my_map(expressionMap)) //> 24681012

  var expressionFilter: Integer => Boolean = x => x <= 2
  list.filter(expressionFilter).foreach(println(_)) //> 24681012
  list.my_filter(expressionFilter).foreach(println(_)) //> 24681012
  assert(list.my_filter(expressionFilter) == list.filter(expressionFilter)) //> res0: List[Integer] = List(1, 3, 4, 5, 6)

  var expressionForall: Integer => Boolean = x => x <= 2
  println(list.forall(expressionForall)) //> 24681012
  println(list.forall(expressionForall)) //> 24681012
  assert(list.forall(expressionForall) == list.my_forall(expressionForall))

  var expressionExist: Integer => Boolean = x => x <= 2
  println(list.exists(expressionForall)) //> 24681012
  println(list.my_exists(expressionForall)) //> 24681012
  assert(list.exists(expressionForall) == list.my_exists(expressionForall))
}