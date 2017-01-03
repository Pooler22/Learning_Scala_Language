package lab3

import scala.collection.TraversableLike

object Exe4 extends App{
  implicit class MyHelper[ElementType,TypeOfCollection[ElementType]](collection: TraversableLike[ElementType,TypeOfCollection[ElementType]]) {

    def processList[NewElementType](f1: ElementType => NewElementType)(f2: NewElementType => Boolean):TypeOfCollection[ElementType] = {
      collection.filter(x=>f2(x))
    }

//    def processList[NewElementType](f1: ElementType => NewElementType)(f2: NewElementType => Boolean):TraversableLike[ElementType,TypeOfCollection]= {
//      collection.map(x=>f1(x))//.filter(f2(_))
//    }

//    def my_map[NewElementType,NewTypeOfCollection](f: ElementType => NewElementType): TypeOfCollection = {
//      //processList(f)(x=>true)
//      collection.map(x=>f(x))
//    }

    def my_filter(f: ElementType => Boolean): TypeOfCollection[ElementType] = {
      //collection.filter(x=>f(x))
      processList(x=>x)(f)
    }

    def my_forall(f: ElementType => Boolean): Boolean = {
      //collection.forall(x=>f(x))
      processList(x=>x)(f). == collection.size
    }

    def my_exists(f: ElementType => Boolean): Boolean = {
      //collection.exists(x=>f(x))
      processList(x=>x)(f).nonEmpty
    }
  }

  var list:TraversableLike[Integer,List[Integer]] = List(1, 2, 3, 4, 5, 6) //> list  : List[Integer] = List(1, 2, 3, 4, 5, 6)

  var expressionMap: Integer => Integer = x => x * 2
  println("Map result")
  list.map(expressionMap).foreach(println(_)) //> 24681012
  println("MYMap result")
  //list.my_map(expressionMap).foreach(println(_)) //> 24681012
//  assert(list.map(expressionMap) == list.my_map(expressionMap)) //> 24681012

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
