package controller

import alice.tuprolog.Term
import model._

import scala.collection.mutable.ListBuffer

class Interviewer {
  val questions = Seq[Question](
    GenreQuestion(),
    GlassQuestion(),
    MarriedQuestion(),
    CriminalQuestion(),
    SurviveQuestion()
  )

  val responses: ListBuffer[String] = ListBuffer()

  
  def makeQuestion(): Unit = {
    makeQuestion(questions.head)
  }
  
  private def makeQuestion(question: Question): Unit = {
    println(question.question + " " + question.answers + ": ")

    val input = scala.io.StdIn.readLine()

    if(question.answers.getResults.contains(input.trim)) {
      responses += input.trim
      if (! searchCharacter()) {
        try {
          makeQuestion(questions(questions.indexOf(question) + 1))
        } catch {
          case _: Throwable => println("Finish!!")
        }
      }
    } else {
      println("Input not valid! Repeat..")
      makeQuestion(question)
    }
  }


  private def searchCharacter(): Boolean = {
    val engine: Term => Stream[Term] = Seeker()
    println("Elements -> " + engine(responses).size)

    false
  }
}

object Interviewer {
  def apply(): Interviewer = new Interviewer()
}
