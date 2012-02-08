package com.arcusys.scorm.model.quiz

/**
 * A question from a question bank
 * @tparam AnswerType   Type of answers to use
 */
trait Question[+AnswerType<:Answer]{
  /** Unique internal ID of question */
  val id: Int
  /** ID of the category the question belongs to (None if no category) */
  val categoryID: Option[Int]
  /** Title of question (used mostly for admin purposes to quickly find question in list) */
  val title: String
  /** Question text. Formulates the problem to the user. */
  val text: String
  /** Explanation text. Describes what answer is correct and why. */
  val explanationText: String
  /** The ordered sequence of answer options or correct answers */
  val answers: Seq[AnswerType]
}
