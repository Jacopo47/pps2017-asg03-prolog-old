package model

trait Question {
  def question: String
  def answers: Result
}

case class Result(private val args: String*){

  def getResults : Seq[String] = args.toSeq

  override def toString: String = {
    var app: String = "[ "
    getResults foreach(app += _ + "/" )

    app.substring(0, app.length - 1) + " ]"
  }
}