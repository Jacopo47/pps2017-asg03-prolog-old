package model

case class Character(name: String,
                     genre: String,
                     wearGlasses: Boolean,
                     married: Boolean,
                     drugDealer: Boolean,
                     survive: Boolean,
                     blonde: Boolean,
                     layer: Boolean) {
  override def toString: String = s"character('$name',$genre,$drugDealer,$survive,$wearGlasses,$married,$blonde,$layer)."
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
      args(5).equals("true"),
      args(6).equals("true"),
      args(7).equals("true"))
  }

  def getCharacters: Seq[Character] = Seq[Character](
    Character("Walther White", "male", wearGlasses = true, married = true, drugDealer = true, survive = false, layer = false, blonde = false),
    Character("Skyler White", "female", wearGlasses = false, married = true, drugDealer = false, survive = true, layer = false, blonde = true),
    Character("Jesse Pinkman", "male", wearGlasses = false, married = false, drugDealer = true, survive = true, layer = false, blonde = false),
    Character("Hank Schrader", "male", wearGlasses = false, married = true, drugDealer = false, survive = false, layer = false, blonde = false),
    Character("Marie Schrader", "female", wearGlasses = false, married = true, drugDealer = false, survive = true, layer = false, blonde = false),
    Character("Walter White Jr.", "male", wearGlasses = false, married = false, drugDealer = false, survive = true, layer = false, blonde = false),
    Character("Saul Goodman", "male", wearGlasses = false, married = false, drugDealer = false, survive = true, layer = true, blonde = false),
    Character("Gustavo Fring", "male", wearGlasses = true, married = false, drugDealer = true, survive = false, layer = false, blonde = false)
  )
}
