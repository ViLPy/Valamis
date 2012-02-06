package com.arcusys.scorm.model.quiz

/**
 * A question requiring a user to provide a textual string as an answer
 * @param id              Unique internal ID of question
 * @param categoryID      ID of the category the question belongs to (None if no category)
 * @param title           Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text            Question text. Formulates the problem to the user.
 * @param explanationText Explanation text. Describes what answer is correct and why.
 * @param answers         Ordered collection of correct answers (not shown to user).
 *                        The order appears while editing the question, but does not matter during tests.
 *                        It is typical to have only one answer in this collection
 * @param isCaseSensitive If true, the check whether the answer is correct or not is case-sensitive. If false, the check is case-insensitive
 * @param position        Relative position of this question among siblings
 */
case class ShortAnswerQuestion(id: Int,
                               categoryID: Option[Int],
                               title: String,
                               text: String,
                               explanationText: String,
                               answers: Seq[ShortAnswer],
                               isCaseSensitive: Boolean,
                               position:Int) extends Question[ShortAnswer]

/**
 * A correct answer to a Short Answer question
 * @param id            Unique internal ID of option/answer
 * @param text          Correct answer string
 */
case class ShortAnswer(id: Int,
                       text: String) extends Answer