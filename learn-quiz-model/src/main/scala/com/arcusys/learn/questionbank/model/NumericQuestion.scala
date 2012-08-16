package com.arcusys.learn.questionbank.model

/**
 * A question requiring a user to provide a number as an answer
 * In the UI will most likely be rendered as a text box which accepts only numbers
 * @param id              Unique internal ID of question
 * @param categoryID      ID of the category the question belongs to (None if no category)
 * @param title           Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text            Question text. Formulates the problem to the user.
 * @param explanationText Explanation text. Describes what answer is correct and why.
 * @param answers         Ordered sequence of correct answers (not shown to user).
 *                        The order appears while editing the question, but does not matter during tests
 *                        It is typical to have only one answer in this collection
 */
class NumericQuestion
(
  id: Int,
  categoryID: Option[Int],
  title: String,
  text: String,
  explanationText: String,
  answers: Seq[NumericAnswer]
  )
  extends Question[NumericAnswer](2, id, categoryID, title, text, explanationText, answers)