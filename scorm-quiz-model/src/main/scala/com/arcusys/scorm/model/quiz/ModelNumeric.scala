package com.arcusys.scorm.model.quiz

/**
 * A question requiring a user to provide a number as an answer
 * @param id              Unique internal ID of question
 * @param categoryID      ID of the category the question belongs to (None if no category)
 * @param title           Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text            Question text. Formulates the problem to the user.
 * @param explanationText Explanation text. Describes what answer is correct and why.
 * @param answers         Ordered collection of correct answers (not shown to user).
 *                        The order appears while editing the question, but does not matter during tests
 *                        It is typical to have only one answer in this collection
 * @param position        Relative position of this question among siblings
 */
case class NumericQuestion(id: Int,
                           categoryID: Option[Int],
                           title: String,
                           text: String,
                           explanationText: String,
                           answers: Seq[NumericAnswer],
                           position:Int) extends Question[NumericAnswer]

/**
 * A correct answer to a Numeric question
 * @param id            Unique internal ID of option/answer
 * @param range         If the user's answer falls into this range (boundaries included), it is considered to be correct
 */
case class NumericAnswer(id: Int,
                         range: (BigDecimal, BigDecimal)) extends Answer