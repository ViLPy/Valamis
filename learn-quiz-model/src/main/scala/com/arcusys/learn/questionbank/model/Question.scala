package com.arcusys.learn.questionbank.model

/**
 * Base class for a question in a question bank
 * @tparam AnswerType       Type of answers to use
 * @param questionTypeCode  Integer representation of question type
 * @param id                Unique internal ID of question
 * @param categoryID        ID of the category the question belongs to (None if question is in root of bank)
 * @param title             Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text              Question text. Formulates the problem to the user.
 * @param explanationText   Explanation text. Describes what answer is correct and why. Not to be displayed when asking answer from user
 * @param answers           Ordered sequence of answer options or correct answers (depending on question type)
 */
abstract class Question[+AnswerType <: Answer]
(
  val questionTypeCode: Int,
  val id: Int,
  val categoryID: Option[Int],
  val title: String,
  val text: String,
  val explanationText: String,
  val answers: Seq[AnswerType]
  )