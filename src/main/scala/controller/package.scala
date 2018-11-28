import alice.tuprolog.Term

package object controller {
  val MAX_TERM_NUMBER: Int = 5

  implicit def argsToQuery(args: Seq[String]): Term = {
    var query: String = "character(X,"
    0 until MAX_TERM_NUMBER foreach { i =>
      try {
        args(i) match {
          case "y" => query += "true,"
          case "n" => query += "false,"
          case _ => query += args(i) + ","
        }
      } catch {
        case _: Throwable => query += "_,"
      }
    }

    println(query.substring(0, query.length - 1) + ")")
    Term.createTerm(query.substring(0, query.length - 1) + ")")
  }
}
