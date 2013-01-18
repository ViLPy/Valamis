package com.arcusys.learn.questionbank.model

/**
 * A question requiring a user to choose from a number of options.
 * In the UI will most likely be rendered as a list of radio buttons
 * (is there's only one correct answer and force correct count is set to True)
 * or by a list of checkboxes (in all other cases)
 * @param id                      Unique internal ID of question
 * @param categoryID              ID of the category the question belongs to (None if no category)
 * @param title                   Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text                    Question text. Formulates the problem to the user.
 * @param explanationText         Explanation text. Describes what answer is correct and why.
 * @param answers                 Ordered sequence of answer options presented to the user.
 *                                The order appears while editing the question and is also used during tests if shuffling is off
 * @param forceCorrectCount	      If true, the user must get informed on the number of correct options and only able to commit answer selecting this number of options
 */
class ChoiceQuestion
(
  id: Int,
  categoryID: Option[Int],
  title: String,
  text: String,
  explanationText: String,
  answers: Seq[ChoiceAnswer],
  val forceCorrectCount: Boolean,
  courseID: Option[Int]
  )
  extends Question[ChoiceAnswer](0, id, categoryID, title, text, explanationText, answers, courseID)