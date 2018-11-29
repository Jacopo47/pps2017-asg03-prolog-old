package controller

import alice.tuprolog.Term
import model._

import scala.collection.mutable.ListBuffer

class Interviewer {
  val questions = Seq[Question](
    GenreQuestion(),
    CriminalQuestion(),
    SurviveQuestion(),
    GlassQuestion(),
    MarriedQuestion(),
    BlondeQuestion(),
    LayerQuestion()
  )

  val engine: Term => Stream[Term] = Seeker()
  val responses: ListBuffer[String] = ListBuffer()

  
  def makeQuestion(): Unit = {
    println("Think about one of this characters:")
    Character.getCharacters foreach {e => println(s"\t- ${e.name.toUpperCase}")}


    1 to 10 foreach {_ => Console.print("."); Console.flush();Thread.sleep(500)}
    println("Let's go!\n")
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
    val characters = engine(responses)

    characters.size match {
      case 0 =>
        println("The character about you're thinking isn't in the database... sorry!")
        true
      case 1 =>
        println("You're thinking about -> " + Character(characters.head.toString).name.toUpperCase)
        true
      case _ => false
    }

  }
}

object Interviewer {
  def apply(): Interviewer = new Interviewer()
}
