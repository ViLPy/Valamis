package com.arcusys.learn.questionbank.model

/**
 * A question requiring a user to select a value for each key
 * In the UI it may be rendered like 'n' dropdown lists, each having the same 'm' options,
 * where 'n' is the number of answer options with defined keys, and 'm' is the total number of answer options.
 * Each dropdown list would receive the name of the category, and options would have the answer option texts.
 * @param id              Unique internal ID of question
 * @param categoryID      ID of the category the question belongs to (None if no category)
 * @param title           Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text            Question text. Formulates the problem to the user.
 * @param explanationText Explanation text. Describes what answer is correct and why.
 * @param answers         Ordered sequence of answer options presented to the user.
 *                        The order appears while editing the question and is also used during tests for ordering the keys if shuffling is off
 *                        Value list for pickup should always be shuffled
 */
class MatchingQuestion
(
  id: Int,
  categoryID: Option[Int],
  title: String,
  text: String,
  explanationText: String,
  answers: Seq[MatchingAnswer]
  )
  extends Question[MatchingAnswer](4, id, categoryID, title, text, explanationText, answers)

