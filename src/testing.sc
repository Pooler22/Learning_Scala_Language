implicit class MyList[A](private var _list:List[A] = Nil){
  private var _size: Int = _list.length

  def list: List[A] = _list

  def list_= (value:List[A]):List[A] = {_size = value.length; _list = value; _list}

  def size:Integer = _size

  private def updateSize:Unit = _size = _list.length

  def :+(element:A): MyList[A] = {_list = _list :+ element; this.updateSize; this}

  def isEmpty : scala.Boolean = list.isEmpty

  def head : A = list.head

  def tail : List[A] = list.tail

//  def ::[B >: A](x : B) : MyList[B] = new MyList[B](list.:: (x))
//
//  def :::[B >: A](prefix : List[B]) : List[B] = { list.:::(prefix)}
//
//  def ++[B >: A, That](that : GenTraversableOnce[B])(implicit bf : CanBuildFrom[List[A], B, That]) : That = { list.++(that) }
//  def +:[B >: A, That](elem : B)(implicit bf : CanBuildFrom[List[A], B, That]) : That = { list.+:(elem) }


  //  Exercise 5
  def isLongerThanN(n:Integer):Boolean = _size > n

  def isShorterThanN(n:Integer):Boolean = _size < n

  def <(n:Integer):Boolean = _size < n

  def >(n:Integer):Boolean = _size > n

  def <=(n:Integer):Boolean = _size <= n

  def >=(n:Integer):Boolean = _size >= n
}

def measureTime[T](expression: => T): String = {
  val t0 = System.nanoTime()
  val result = expression
  val t1 = System.nanoTime()
  "Time: " + (t1 - t0) + "ns result: " + result
}


var sample:MyList[Integer] = new MyList[Integer]()
assert(sample.isEmpty)

sample.list = List(1 ,2 ,3)
assert(sample.size == 3)
assert(sample.head == 1)
assert(sample.tail == List(2,3))
assert(!sample.isEmpty)

sample = sample :+ 2
assert(sample.size == 4)

//sample = sample :: 0
//assert(sample.head == 0)

assert(sample.isLongerThanN(2))

assert(sample.isShorterThanN(10))

assert(sample <= 10)

assert(sample >= 2)

val list = List.fill(1000)(0)
val myList = MyList(list)

measureTime(list.size)
measureTime(myList.size)
