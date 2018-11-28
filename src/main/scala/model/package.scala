import alice.tuprolog.{Prolog, Theory}

package object model {
  implicit def characterToTheory(character: Character): Theory = {
    new Theory(character.toString)
  }

  implicit def createEngine(characters: Seq[Character]): Prolog = {
    val engine = new Prolog()

    characters foreach { c => engine.addTheory(c) }

    engine
  }
}
