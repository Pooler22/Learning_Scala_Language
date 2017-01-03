package lab3

object Exe3 extends App{
  implicit class MyHelper[S](list: List[S]) {

    def processList[R](f1: S => R)(f2: R => Boolean):List[R] = {
      list.map(f1(_)).filter(f2(_))
    }

    def my_map[R](f: S => R): List[R] = {
      processList(f)(x=>true)
    }

    def my_filter(f: S => Boolean): List[S] = {
      processList(x=>x)(f)
    }

    def my_forall(f: S => Boolean): Boolean = {
      processList(x=>x)(f).length == list.length
    }

    def my_exists(f: S => Boolean): Boolean = {
      processList(x=>x)(f).nonEmpty
    }
  }

  var list: List[Integer] = List(1, 2, 3, 4, 5, 6) //> list  : List[Integer] = List(1, 2, 3, 4, 5, 6)

  var expressionMap: Integer => Integer = x => x * 2
  println("Map result")
  list.map(expressionMap).foreach(println(_)) //> 24681012
  println("MYMap result")
  list.my_map(expressionMap).foreach(println(_)) //> 24681012
  assert(list.map(expressionMap) == list.my_map(expressionMap)) //> 24681012

  var expressionFilter: Integer => Boolean = x => x <= 2
  println("Filter result")
  list.filter(expressionFilter).foreach(println(_)) //> 24681012
  println("MyFilter result")
  list.my_filter(expressionFilter).foreach(println(_)) //> 24681012
  assert(list.my_filter(expressionFilter) == list.filter(expressionFilter)) //> res0: List[Integer] = List(1, 3, 4, 5, 6)

  var expressionForall: Integer => Boolean = x => x <= 2
  println("Forall result")
  println(list.forall(expressionForall)) //> 24681012
  println("MyForall result")
  println(list.forall(expressionForall)) //> 24681012
  assert(list.forall(expressionForall) == list.my_forall(expressionForall))

  var expressionExist: Integer => Boolean = x => x <= 2
  println("Exists result")
  println(list.exists(expressionForall)) //> 24681012
  println("MyExists result")
  println(list.my_exists(expressionForall)) //> 24681012
  assert(list.exists(expressionForall) == list.my_exists(expressionForall))
}
