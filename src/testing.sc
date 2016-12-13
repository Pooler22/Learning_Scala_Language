val loadedData = io.Source.fromFile("C:\\Users\\pooler\\IdeaProjects\\jispdr\\src\\lab2\\jispdr-wydatki.csv")

var tmp:String
for (line <- loadedData.getLines.drop(1)) {
  print(line)

}
loadedData.close
