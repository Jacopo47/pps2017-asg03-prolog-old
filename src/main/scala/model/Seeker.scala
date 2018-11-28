package model

import alice.tuprolog.{Prolog, Theory}

import scala.collection.mutable.ListBuffer

class Seeker {
  val engine = new Prolog()
  engine.addTheory(new Theory("character('Walther White', male, y, y, y, n)."))
  engine.addTheory(new Theory("character('Skyler White', female, y, y, y, y)."))

  def solve(): Seq[Character] = {
    var info = engine.solve("character(X, _, _, _, _, _).")
    val result = ListBuffer[Character]()
    while (info.isSuccess) {
      println("solution: " + info.getSolution + " - bindings: " + info)
      println(info.getVarValue("X"))
      result += Character(info.getSolution.toString)
      if (engine.hasOpenAlternatives) {
        info = engine.solveNext()
      } else {
        return result
      }
    }

    return result
  }
}

object Seeker {
  def apply(): Seeker = new Seeker()
}
