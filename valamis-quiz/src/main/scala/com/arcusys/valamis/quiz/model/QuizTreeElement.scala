package com.arcusys.valamis.quiz.model

/*
  Recursion model for Quiz Tree
 */
case class QuizTreeElement(id: Int,
  quizID: Int,
  elementID: String,
  isCategory: Boolean,
  parentID: Option[String],
  arrangementIndex: Int = 1)
//{
//  def apply(id: Int, quizID: Int, elementID: String, isCategory: Boolean, parentID: Option[String]) = {
//    QuizTreeElement(id, quizID: Int,
//      elementID: String,
//      isCategory: Boolean,
//      parentID: Option[String])
//  }
//}