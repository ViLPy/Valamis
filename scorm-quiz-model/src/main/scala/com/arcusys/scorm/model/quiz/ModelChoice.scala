package com.arcusys.scorm.model.quiz

/**
 * A question requiring a user to choose from a number of options
 * @param id                      Unique internal ID of question
 * @param categoryID              ID of the category the question belongs to (None if no category)
 * @param title                   Title of question (used mostly for admin purposes to quickly find question in list)
 * @param text                    Question text. Formulates the problem to the user.
 * @param explanationText         Explanation text. Describes what answer is correct and why.
 * @param answers                 Ordered collection of answer options presented to the user.
 *                                The order appears while editing the question and is also used during tests if shuffling is off
 * @param forceCorrectCount   If true, the user must get notified on the number of correct options and only able to select this number of options
 * @param position                Relative position of this question among siblings
 */
case class ChoiceQuestion(id: Int,
                          categoryID: Option[Int],
                          title: String,
                          text: String,
                          explanationText: String,
                          answers: Seq[ChoiceAnswer],
                          forceCorrectCount: Boolean,
                          position:Int) extends Question[ChoiceAnswer]

/**
 * An option for a Choice question
 * @param id            Unique internal ID of option/answer
 * @param text          Option text
 * @param isCorrect     True if this is a correct answer
 */
case class ChoiceAnswer(id: Int,
                        text: String,
                        isCorrect: Boolean) extends Answer