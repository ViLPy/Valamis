package com.arcusys.valamis.quiz.model

case class QuizInfo(title: String, description: String) {
  def this(quiz: Quiz) = this(quiz.title, quiz.description)
}

