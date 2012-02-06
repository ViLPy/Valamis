package com.arcusys.scorm.model.quiz

/**
 * A question requiring a user to select a value for each key
 * @param id              Unique internal ID of question
 * @param categoryID      ID of the category the question belongs to (None if no category)
 * @param title           Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text            Question text. Formulates the problem to the user.
 * @param explanationText Explanation text. Describes what answer is correct and why.
 * @param answers         Ordered collection of answer options presented to the user.
 *                        The order appears while editing the question and is also used during tests for ordering the keys if shuffling is off
 *                        Value list for pickup should always be shuffled
 */
case class MatchingQuestion(id: Int,
                            categoryID: Option[Int],
                            title: String,
                            text: String,
                            explanationText: String,
                            answers: Seq[MatchingAnswer],
                            position:Int) extends Question[MatchingAnswer]

/**
 * A key-value pair for a Matching question
 */
case class MatchingAnswer(id: Int,
                          text: String,
                          matchingText: Option[String]) extends Answer