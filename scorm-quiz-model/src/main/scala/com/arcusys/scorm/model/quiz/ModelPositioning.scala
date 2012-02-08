package com.arcusys.scorm.model.quiz

/**
 * A question requiring a user to pick up and place options in correct order
 * @param id              Unique internal ID of question
 * @param categoryID      ID of the category the question belongs to (None if no category)
 * @param title           Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text            Question text. Formulates the problem to the user.
 * @param explanationText Explanation text. Describes what answer is correct and why.
 * @param answers         Ordered collection of answer options presented to the user.
 *                        The order appears while editing the question and is also the correct answer order and thus is checked during tests.
 *                        Options are always shuffled during tests. Options with isCorrect = false are not part of correct answer at all.
 * @param forceCorrectCount       If true, the user must get notified on the number of needed options and only able to pick up this number of options
 * @param position        Relative position of this question among siblings
 */
case class PositioningQuestion(id: Int,
                               categoryID: Option[Int],
                               title: String,
                               text: String,
                               explanationText: String,
                               answers: Seq[PositioningAnswer],
                               forceCorrectCount: Boolean) extends Question[PositioningAnswer]


/**
 * An option for a Positioning question
 * @param id            Unique internal ID of option/answer
 * @param text          Option text
 * @param isCorrect     True if this option should be included in the correct sequence.
 */
case class PositioningAnswer(id: Int,
                             text: String,
                             isCorrect: Boolean) extends Answer