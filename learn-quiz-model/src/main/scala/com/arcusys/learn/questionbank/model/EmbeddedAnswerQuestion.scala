package com.arcusys.learn.questionbank.model

/**
 * Consist of a passage of text (in specific format) that has  various answers embedded within it,
 * including multiple choice, text answers and numerical answers.
 * Currently not fully supported
 */
class EmbeddedAnswerQuestion
(
  id: Int,
  categoryID: Option[Int],
  title: String,
  text: String,
  explanationText: String
  ) extends Question[Nothing](6, id, categoryID, title, text, explanationText, Nil)

