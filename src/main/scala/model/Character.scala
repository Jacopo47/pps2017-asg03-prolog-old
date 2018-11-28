package model

class Character(name: String,
                genre: String,
                wearGlasses: Boolean,
                married: Boolean,
                criminal: Boolean,
                survive: Boolean) {

}

object Character {
  def apply(name: String,
            genre: String,
            wearGlasses: Boolean,
            married: Boolean,
            criminal: Boolean,
            survive: Boolean): Character = new Character(name, genre, wearGlasses, married, criminal, survive)


  def apply(term: String): Character = {
    var fromString = term
    fromString = fromString.replace("character(", "")
    fromString = fromString.substring(0, fromString.length - 1)

    val args = fromString.split(",")

    new Character(args(0).replace("'", ""),
      args(1),
      args(2).equals("y"),
      args(3).equals("y"),
      args(4).equals("y"),
      args(5).equals("y"))
  }
}
