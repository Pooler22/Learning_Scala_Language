package lab2

object Exe4and5 extends App{

  class MyList[A](var _list:List[A] = Nil){
    var sizeValue = _list.length
    def size:Integer = sizeValue

    def list = _list
    def list_= (value:List[A]):List[A] = {sizeValue = value.length; _list = value; _list}

    def :+(element:A): Unit ={
      _list = _list :+ element
    }

    def isEmpty : scala.Boolean = list.isEmpty
    def head : A = list.head
    def tail : scala.collection.immutable.List[A] = list.tail
    def ::[B >: A](x : B) : scala.collection.immutable.List[B] = { list.:: (x) }
    def :::[B >: A](prefix : scala.collection.immutable.List[B]) : scala.collection.immutable.List[B] = { list.:::(prefix)}
//    override def ++[B >: A, That](that : scala.collection.GenTraversableOnce[B])(implicit bf : scala.collection.generic.CanBuildFrom[scala.collection.immutable.List[A], B, That]) : That = { /* compiled code */ }
//    override def +:[B >: A, That](elem : B)(implicit bf : scala.collection.generic.CanBuildFrom[scala.collection.immutable.List[A], B, That]) : That = { /* compiled code */ }


    def isLongerThanN(n:Integer):Boolean = sizeValue > n
    def isShorterThanN(n:Integer):Boolean = sizeValue < n

    def <(n:Integer):Boolean = sizeValue < n
    def >(n:Integer):Boolean = sizeValue > n

    def <=(n:Integer):Boolean = sizeValue <= n
    def >=(n:Integer):Boolean = sizeValue >= n
  }

  var sample:MyList[Integer] = new MyList[Integer]()
  sample.list = List(1 ,2 ,3)
  sample.size

  sample.isLongerThanN(2)
  sample.isShorterThanN(2)

  sample <= 3

  //sample.list = sample.list :+ 5
  sample.size



}
