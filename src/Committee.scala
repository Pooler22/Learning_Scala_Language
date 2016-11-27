object Committee extends Enumeration {
  val Education, Culture, Sports, EU = Value

  override def toString() =
    this match {
      case Education => "Education"
      case Culture => "Culture"
      case Sports => "Sports"
      case EU => "EU"
    }
}

