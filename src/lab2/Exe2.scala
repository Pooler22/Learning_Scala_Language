package lab2

object Exe2 extends App {
  val loadedData = io.Source.fromFile("C:\\Users\\pooler\\IdeaProjects\\jispdr\\src\\lab2\\jispdr-wydatki.csv")
  for (line <- loadedData.getLines.drop(1)) {
    print(line)
  }
  loadedData.close
}
