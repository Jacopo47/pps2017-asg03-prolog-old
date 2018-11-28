package model

case class Character(name: String,
                     genre: String,
                     wearGlasses: Boolean,
                     married: Boolean,
                     drugDealer: Boolean,
                     survive: Boolean) {
  override def toString: String = s"character('$name',$genre,$wearGlasses,$married,$drugDealer,$survive)."
}

object Character {
  def apply(term: String): Character = {
    var fromString = term
    fromString = fromString.replace("character(", "")
    fromString = fromString.substring(0, fromString.length - 1)

    val args = fromString.split(",")

    Character(args(0).replace("'", ""),
      args(1),
      args(2).equals("true"),
      args(3).equals("true"),
      args(4).equals("true"),
      args(5).equals("true"))
  }

}
