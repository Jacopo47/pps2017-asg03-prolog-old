package model

import alice.tuprolog.{Prolog, SolveInfo, Term}


object Seeker {
  def apply(): Term => Stream[Term] = solve

  def getCharacters: Seq[Character] = Seq[Character](
    Character("Walther White", "male", wearGlasses = true, married = true, drugDealer = true, survive = false),
    Character("Skyler White", "female", wearGlasses = false, married = true, drugDealer = false, survive = true),
    Character("Jesse Pinkman", "male", wearGlasses = false, married = false, drugDealer = true, survive = true),
    Character("Hank Schrader", "male", wearGlasses = false, married = true, drugDealer = false, survive = false),
    Character("Marie Schrader", "female", wearGlasses = false, married = true, drugDealer = false, survive = true),
    Character("Walter White, Jr.", "male", wearGlasses = false, married = false, drugDealer = false, survive = true),
    Character("Saul Goodman", "male", wearGlasses = false, married = false, drugDealer = false, survive = true),
    Character("Gustavo Fring", "male", wearGlasses = true, married = false, drugDealer = true, survive = false)
  )

  def solve: Term => Stream[Term] = {
    goal =>
      new Iterable[Term] {
        val engine: Prolog = Seeker.getCharacters
        println("Hello")

        override def iterator: Iterator[Term] = new Iterator[Term] {
          var solution: SolveInfo = engine.solve(goal)
          var end: Boolean = false
          println("Hello 1")

          override def hasNext: Boolean = if (!end) {
            println(solution.getSolution)
            solution.isSuccess || solution.hasOpenAlternatives
          } else {
            false
          }


          override def next(): Term =
            try {
              solution.getSolution
            } finally {
              try {
                solution = engine.solveNext()
              } catch {
                case _:Throwable => end = true
              }
            }
        }
      }.toStream
  }
}
