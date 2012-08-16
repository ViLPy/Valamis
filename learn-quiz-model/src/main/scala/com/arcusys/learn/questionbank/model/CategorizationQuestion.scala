package com.arcusys.learn.questionbank.model

/**
 * A question requiring a user to put options in correct categories.
 * It may be rendered as a list of options which the user drags and drops onto a list of categories.
 * List of categories is currently defined by what is mentioned as a category in the answer options,
 * so it's currently impossible to have "categories for distraction" which should be empty in correct answer.
 * But it's possible to have answers which shouldn't belong to any category
 * @param id              Unique internal ID of question
 * @param categoryID      ID of the category the question belongs to (None if no category)
 * @param title           Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text            Question text. Formulates the problem to the user.
 * @param explanationText Explanation text. Describes what answer is correct and why.
 * @param answers         Ordered sequence of answer options presented to the user.
 *                        The order appears while editing the question and is also used during tests for ordering the options if shuffling is off
 *                        Category list for pickup should be displayed in alphabetic order if not shuffled
 */
class CategorizationQuestion
(
  id: Int,
  categoryID: Option[Int],
  title: String,
  text: String,
  explanationText: String,
  answers: Seq[CategorizationAnswer]
  ) extends Question[CategorizationAnswer](7, id, categoryID, title, text, explanationText, answers)

