//Lab1.calculateExpression("-3 + 4 - 1 + 1 + 13 - 5 + 6".split(" ").toList)
//Lab1.calculateExpression("3 + 3".split(" ").toList)
//Lab1.calculateExpression("#Error".split(" ").toList)

//Lab1.isExcellentNumber(6)

//Vector[Int](6, 28, 496, 8128).foreach(x => println(Lab1.isExcellentNumber(x)))
//Vector[Int](5, 27, 495, 8127).foreach(x => println(Lab1.isExcellentNumber(x)))

val n =6
(1 to math.sqrt(n).toInt).reduce((x,y) => if(n%y == 0){ x+y + (if(y*y != n)  n / y else 0)} else x)
