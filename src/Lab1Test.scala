import org.junit.Test

class Lab1Test {
  @Test def exercise1_correct() {
    val input = "-3 + 4 - 1 + 1 + 13 - 5 + 6"
    val correctResult = 15
    val result = Lab1.exercise_1(input.split(" ").toList)
    assert(result == correctResult)
  }

  @Test(expected = classOf[NumberFormatException])
  def exercise1_error() {
    val input = "#error"
    Lab1.exercise_1(input.split(" ").toList)
  }
}