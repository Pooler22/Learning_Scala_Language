package lab3

import scala.collection.generic.CanBuildFrom

object Exe4 extends App{
  implicit class MyHelper[CC[X] <: Traversable[X], A](value: CC[A]) {
    type CanBuildTo[Elem, CC[X]] = CanBuildFrom[Nothing, Elem, CC[Elem]]

    def processList(f1: A => A)(f2: A=> Boolean)(implicit cbf: CanBuildTo[A, CC]): Traversable[A] = {
      value.map(x=>f1(x)).filter(f2(_))
    }

    def my_map(f: A => A)(implicit cbf: CanBuildTo[A, CC]): Traversable[A] = {
      processList(f)(x=>true)
    }

    def my_filter(f: A => Boolean)(implicit cbf: CanBuildTo[A, CC]): Traversable[Any] = {
      processList(x=>x)(f)
    }

    def my_forall(f: A => Boolean)(implicit cbf: CanBuildTo[A, CC]): Boolean = {
      processList(x=>x)(f).size == value.size
    }

    def my_exists(f: A => Boolean)(implicit cbf: CanBuildTo[A, CC]): Boolean = {
      processList(x=>x)(f).nonEmpty
    }
  }


  //LIST

  val list = List(1, 2, 3, 4, 5, 6) //> list  : List[Integer] = List(1, 2, 3, 4, 5, 6)

  var expressionMap: Integer => Integer = x => x * 2
  println("Map result")
  list.map(x=>expressionMap(x)).foreach(println(_)) //> 24681012
  println("MYMap result")
  list.my_map(x=>expressionMap(x)).foreach(println(_)) //> 24681012
  assert(list.map(x=>expressionMap(x)) == list.my_map(x=>expressionMap(x))) //> 24681012

  var expressionFilter: Integer => Boolean = x => x <= 2
  println("Filter result")
  list.filter(x=>expressionFilter(x)).foreach(println(_)) //> 24681012
  println("MyFilter result")
  list.my_filter(x=>expressionFilter(x)).foreach(println(_)) //> 24681012
  assert(list.my_filter(x=>expressionFilter(x)) == list.filter(x=>expressionFilter(x))) //> res0: List[Integer] = List(1, 3, 4, 5, 6)

  var expressionForall: Integer => Boolean = x => x <= 2
  println("Forall result")
  println(list.forall(x=>expressionForall(x))) //> 24681012
  println("MyForall result")
  println(list.forall(x=>expressionForall(x))) //> 24681012
  assert(list.forall(x=>expressionForall(x)) == list.my_forall(x=>expressionForall(x)))

  var expressionExists: Integer => Boolean = x => x <= 2
  println("Exists result")
  println(list.exists(x=>expressionExists(x))) //> 24681012
  println("MyExists result")
  println(list.my_exists(x=>expressionExists(x))) //> 24681012
  assert(list.exists(x=>expressionExists(x)) == list.my_exists(x=>expressionExists(x)))


  //SEQ

  val seq = Seq(1, 2, 3, 4, 5, 6) //> seq  : seq[Integer] = seq(1, 2, 3, 4, 5, 6)

  println("Map result")
  seq.map(x=>expressionMap(x)).foreach(println(_)) //> 24681012
  println("MYMap result")
  seq.my_map(x=>expressionMap(x)).foreach(println(_)) //> 24681012
  assert(seq.map(x=>expressionMap(x)) == seq.my_map(x=>expressionMap(x))) //> 24681012

  println("Filter result")
  seq.filter(x=>expressionFilter(x)).foreach(println(_)) //> 24681012
  println("MyFilter result")
  seq.my_filter(x=>expressionFilter(x)).foreach(println(_)) //> 24681012
  assert(seq.my_filter(x=>expressionFilter(x)) == seq.filter(x=>expressionFilter(x))) //> res0: seq[Integer] = seq(1, 3, 4, 5, 6)

  println("Forall result")
  println(seq.forall(x=>expressionForall(x))) //> 24681012
  println("MyForall result")
  println(seq.forall(x=>expressionForall(x))) //> 24681012
  assert(seq.forall(x=>expressionForall(x)) == seq.my_forall(x=>expressionForall(x)))

  println("Exists result")
  println(seq.exists(x=>expressionExists(x))) //> 24681012
  println("MyExists result")
  println(seq.my_exists(x=>expressionExists(x))) //> 24681012
  assert(seq.exists(x=>expressionExists(x)) == seq.my_exists(x=>expressionExists(x)))


  //SET

  val set = Set(1, 2, 3, 4, 5, 6) //> set  : set[Integer] = set(1, 2, 3, 4, 5, 6)

  println("Map result")
  set.map(x=>expressionMap(x)).foreach(println(_)) //> 24681012
  println("MYMap result")
  set.my_map(x=>expressionMap(x)).foreach(println(_)) //> 24681012
  assert(set.map(x=>expressionMap(x)) == set.my_map(x=>expressionMap(x))) //> 24681012

  println("Filter result")
  set.filter(x=>expressionFilter(x)).foreach(println(_)) //> 24681012
  println("MyFilter result")
  set.my_filter(x=>expressionFilter(x)).foreach(println(_)) //> 24681012
  assert(set.my_filter(x=>expressionFilter(x)) == set.filter(x=>expressionFilter(x))) //> res0: set[Integer] = set(1, 3, 4, 5, 6)

  println("Forall result")
  println(set.forall(x=>expressionForall(x))) //> 24681012
  println("MyForall result")
  println(set.forall(x=>expressionForall(x))) //> 24681012
  assert(set.forall(x=>expressionForall(x)) == set.my_forall(x=>expressionForall(x)))

  println("Exists result")
  println(set.exists(x=>expressionExists(x))) //> 24681012
  println("MyExists result")
  println(set.my_exists(x=>expressionExists(x))) //> 24681012
  assert(set.exists(x=>expressionExists(x)) == set.my_exists(x=>expressionExists(x)))
}
