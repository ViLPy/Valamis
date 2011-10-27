package com.arcusys.scorm.model.quiz

/*
 * Answer types:
 * Essay - intended for short answers of a paragraph or two, that one often finds on exams
 * Matching - have a content area and a list of names or statements which must be correctly matched against another list of names or statements
 * EmbeddedAnswers - consist of a passage of text (in specific format) that has various answers embedded within it, including multiple choice, short answers and numerical answers.
 * Choice - single/multiple choice question
 * BoundedChoice - multiple choice question which limits number of answers, which user can check (used ChoiceAnswer)
 * ShortAnswer - the student types in a word or phrase in response to a question. The answer could be a word or a phrase, but it must match one of your acceptable answers exactly
 * Numerical - a numerical question looks just like a short-answer question. The difference is that numerical answers are allowed to have an accepted fixed range error
 * Positioning - user should place answers in the correct order
 */

trait Answer {
  val id: Int
}

/**
 * An option for a Choice question
 * @param id            Unique internal ID of option/answer
 * @param text          Option text
 * @param isBounded     True if this is a correct answer
 */
case class ChoiceAnswer(val id: Int,
                        text: String,
                        isCorrect: Boolean) extends Answer

/**
 * A correct answer to a Short Answer question
 * @param id            Unique internal ID of option/answer
 * @param text          Correct answer string
 */
case class ShortAnswer(val id: Int,
                       text: String) extends Answer

/**
 * A correct answer to a Numeric question
 * @param id            Unique internal ID of option/answer
 * @param range         If the user's answer falls into this range (boundaries included), it is considered to be correct
 */
case class NumericAnswer(val id: Int,
                         range: (BigDecimal, BigDecimal)) extends Answer


case class MatchingAnswer(val id: Int,
                          text: String,
                          subquestionText: Option[String]) extends Answer

case class PositioningAnswer(val id: Int,
                             text: String,
                             /** if false, then this answer will be ignored in correct answer order */
                             isCorrect: Boolean) extends Answer

// probably we doesn't need next answer classes, 'cause in these cases we can use only question class
case class EssayAnswer(val id: Int) extends Answer
case class EmbeddedAnswer(val id: Int) extends Answer