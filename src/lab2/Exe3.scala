package lab2

import util.Random

object Exe3 extends App  {
  val size = 1000
  var exampleList:List[Integer] = List.fill(1000)(Random.nextInt())
  var exampleSeq:Seq[Integer] = exampleList.toSeq

  def measureTime[T](expression: => T): String = {
    val t0 = System.nanoTime()
    val result = expression
    val t1 = System.nanoTime()
    "Time: " + (t1 - t0) + "ns result: " + result
  }

  println(measureTime(exampleList.last))
  println(measureTime(exampleSeq.last))

  println(measureTime(exampleList.size))
  println(measureTime(exampleSeq.size))

  println(measureTime(exampleList.min))
  println(measureTime(exampleSeq.min))

  println(measureTime(exampleList.max))
  println(measureTime(exampleSeq.max))

}
