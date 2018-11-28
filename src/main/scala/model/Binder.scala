package model

case class GenreQuestion(question: String = "Is male or female?", answers: Result = Result("male", "female")) extends Question
case class GlassQuestion(question: String = "Wear glasses?", answers: Result = Result("y", "n")) extends Question
case class CriminalQuestion(question: String = "Is a criminal?", answers: Result = Result("y", "n")) extends Question
case class MarriedQuestion(question: String = "Is married?", answers: Result = Result("y", "n")) extends Question
case class SurviveQuestion(question: String = "Survive?", answers: Result = Result("y", "n")) extends Question