package controller

import model._

class Interviewer {
  val questions = Seq[Question](
    GenreQuestion(),
    GlassQuestion(),
    CriminalQuestion(),
    MarriedQuestion(),
    SurviveQuestion()
  )
  
  
  def makeQuestion(): Unit = {
    makeQuestion(questions.head)
  }
  
  private def makeQuestion(question: Question): Unit = {
    println(question.question + " " + question.answers + ": ")

    val input = scala.io.StdIn.readLine()

    if(question.answers.getResults.contains(input.trim)) {
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
    println(Seeker().solve())

    false
  }
}

object Interviewer {
  def apply(): Interviewer = new Interviewer()
}
