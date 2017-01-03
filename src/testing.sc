import collection.generic.CanBuildFrom

implicit class MyHelper[CC[X] <: Traversable[X], A](value: CC[A]) {
  type CanBuildTo[Elem, CC[X]] = CanBuildFrom[Nothing, Elem, CC[Elem]]

  def processList(f1: A => A)(f2: A=> Boolean)(implicit cbf: CanBuildTo[A, CC]): Traversable[A]= {
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
List(1,2,3,4).map(x=>x+1)
List(1,2,3,4).my_map(x=>x+1)
List(1,2,3,4).my_filter(x=>x<2)
List(1,2,3,4).my_forall(x=>x<1)
List(1,2,3,4).my_exists(x=>x<1)

Seq(1,2,3,4).my_map(x=>x+1)
Seq(1,2,3,4).my_filter(x=>x<2)
Seq(1,2,3,4).my_forall(x=>x<1)
Seq(1,2,3,4).my_exists(x=>x<1)