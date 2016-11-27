object Lab1 extends App{
  def exercise_1(x: List[String]): Int = x match {
    case x1 :: "+" :: x2 :: rest => exercise_1((x1.toInt + x2.toInt).toString :: rest)
    case x1 :: "-" :: x2 :: rest => exercise_1((x1.toInt - x2.toInt).toString :: rest)
    case x1 :: Nil               => x1.toInt
    case _                       => throw new NumberFormatException("allowed int numbers and + - operators")
  }

};
