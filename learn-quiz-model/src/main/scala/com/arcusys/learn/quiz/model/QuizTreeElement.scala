package com.arcusys.learn.quiz.model

/*
  Recursion model for Quiz Tree
 */
case class QuizTreeElement(id: Int,
  quizID: Int,
  elementID: String,
  isCategory: Boolean,
  parentID: Option[String],
  arrangementIndex: Int = 1)