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
  /** The ordered collection of answer options or correct answers */
  val answers: Seq[AnswerType]
}

/**
 * A question requiring a user to choose from a number of options
 * @param id            Unique internal ID of question
 * @param categoryID    ID of the category the question belongs to (None if no category)
 * @param title         Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text          Question text. Formulates the problem to the user.
 * @param answers       Ordered collection of answer options presented to the user.
 *                      The order appears while editing the question and is also used during tests if shuffling is off
 * @param isBounded     If true, the user must get notified on the number of correct options and only able to select this number of options
 */
case class ChoiceQuestion(val id: Int,
                          val categoryID: Option[Int],
                          val title: String,
                          val text: String,
                          val answers: Seq[ChoiceAnswer],
                          isBounded: Boolean) extends Question[ChoiceAnswer]

/**
 * A question requiring a user to provide a textual string as an answer
 * @param id            Unique internal ID of question
 * @param categoryID    ID of the category the question belongs to (None if no category)
 * @param title         Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text          Question text. Formulates the problem to the user.
 * @param answers       Ordered collection of correct answers (not shown to user).
 *                      The order appears while editing the question, but does not matter during tests.
 *                      It is typical to have only one answer in this collection
 * @param isCaseSensitive     If true, the check whether the answer is correct or not is case-sensitive. If false, the check is case-insensitive
 */
case class ShortAnswerQuestion(val id: Int,
                               val categoryID: Option[Int],
                               val title: String,
                               val text: String,
                               val answers: Seq[ShortAnswer],
                               isCaseSensitive: Boolean) extends Question[ShortAnswer]

/**
 * A question requiring a user to provide a number as an answer
 * @param id            Unique internal ID of question
 * @param categoryID    ID of the category the question belongs to (None if no category)
 * @param title         Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text          Question text. Formulates the problem to the user.
 * @param answers       Ordered collection of correct answers (not shown to user).
 *                      The order appears while editing the question, but does not matter during tests
 *                      It is typical to have only one answer in this collection
 */
case class NumericQuestion(val id: Int,
                           val categoryID: Option[Int],
                           val title: String,
                           val text: String,
                           val answers: Seq[NumericAnswer]) extends Question[NumericAnswer]

/**
 * A question requiring a user to pick up and place options in correct order
 * @param id            Unique internal ID of question
 * @param categoryID    ID of the category the question belongs to (None if no category)
 * @param title         Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text          Question text. Formulates the problem to the user.
 * @param answers       Ordered collection of answer options presented to the user.
 *                      The order appears while editing the question and is also the correct answer order and thus is checked during tests.
 *                      Options are always shuffled during tests
 * @param isBounded     If true, the user must get notified on the number of needed options and only able to pick up this number of options
 */
case class PositioningQuestion(val id: Int,
                               val categoryID: Option[Int],
                               val title: String,
                               val text: String,
                               val answers: Seq[PositioningAnswer],
                               isBounded: Boolean) extends Question[PositioningAnswer]

/**
 * A question requiring a user to select a value for each key
 * @param id            Unique internal ID of question
 * @param categoryID    ID of the category the question belongs to (None if no category)
 * @param title         Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text          Question text. Formulates the problem to the user.
 * @param answers       Ordered collection of answer options presented to the user.
 *                      The order appears while editing the question and is also used during tests for ordering the keys if shuffling is off
 *                      Value list for pickup should always be shuffled
 */
case class MatchingQuestion(val id: Int,
                            val categoryID: Option[Int],
                            val title: String,
                            val text: String,
                            val answers: Seq[MatchingAnswer]) extends Question[MatchingAnswer]

case class EssayQuestion(val id: Int,
                         val categoryID: Option[Int],
                         val title: String,
                         val text: String,
                         val answers: Seq[EssayAnswer]) extends Question[EssayAnswer]
      
case class EmbeddedAnswerQuestion(val id: Int,
                                  val categoryID: Option[Int],
                                  val title: String,
                                  val text: String,
                                  val answers: Seq[EmbeddedAnswer]) extends Question[EmbeddedAnswer]