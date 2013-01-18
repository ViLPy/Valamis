package com.arcusys.learn.questionbank.model

/**
 * A question requiring a user to pick up and place options in correct order
 * @param id                Unique internal ID of question
 * @param categoryID        ID of the category the question belongs to (None if no category)
 * @param title             Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text              Question text. Formulates the problem to the user.
 * @param explanationText   Explanation text. Describes what answer is correct and why.
 * @param answers           Ordered sequence of answer options presented to the user.
 *                          The order appears while editing the question and also defines the correct answer order and thus is checked during tests.
 *                          Options are always shuffled during tests. Options with isCorrect = false are not part of correct answer at all.
 * @param forceCorrectCount If true, the user must get notified on the number of needed options and only able to to commit answer selecting this number of options
 */
class PositioningQuestion
(
  id: Int,
  categoryID: Option[Int],
  title: String,
  text: String,
  explanationText: String,
  answers: Seq[PositioningAnswer],
  val forceCorrectCount: Boolean,
  courseID: Option[Int]
  )
  extends Question[PositioningAnswer](3, id, categoryID, title, text, explanationText, answers, courseID)