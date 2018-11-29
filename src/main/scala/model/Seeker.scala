package model

import alice.tuprolog.{Prolog, SolveInfo, Term}


object Seeker {
  def apply(): Term => Stream[Term] = solve



  def solve: Term => Stream[Term] = {
    val engine: Prolog = Character.getCharacters

    goal =>
      new Iterable[Term] {

        override def iterator: Iterator[Term] = new Iterator[Term] {
          var solution: SolveInfo = engine.solve(goal)

          override def hasNext: Boolean = if (solution != null) {
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
                case _: Throwable => solution = null
              }
            }
        }
      }.toStream
  }
}
