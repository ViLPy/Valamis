package com.arcusys.learn.questionbank.model

/**
 * Essay - intended for short answers of a paragraph or two, that one often finds on exams
 * Currently not fully supported
 */
class EssayQuestion
(
  id: Int,
  categoryID: Option[Int],
  title: String,
  text: String,
  explanationText: String,
  courseID: Option[Int]
  ) extends Question[Nothing](5, id, categoryID, title, text, explanationText, Nil, courseID)

