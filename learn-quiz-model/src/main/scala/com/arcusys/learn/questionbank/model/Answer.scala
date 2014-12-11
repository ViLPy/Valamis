package com.arcusys.learn.questionbank.model

/**
 * Base class for an answer option or correct answer for a question
 */
sealed trait Answer {
  def id: Int
  def questionId: Option[Int]
  def score: Option[Double]
}

/*
 * A correct answer to a Text question
 * @param id    Unique internal ID of option/answer
 * @param text  Correct answer string
 */

case class TextAnswer(id: Int = 0,
  text: String,
  questionId: Option[Int] = None,
  score: Option[Double] = None) extends Answer

/**
 * An option for a Positioning question
 * @param id            Unique internal ID of option/answer
 * @param text          Option text
 * @param isCorrect     True if this option is part of the correct sequence
 */
case class PositioningAnswer(id: Int = 0,
  text: String,
  isCorrect: Boolean,
  questionId: Option[Int] = None,
  score: Option[Double] = None) extends Answer

/**
 * A correct answer to a Numeric question
 * @param id              Unique internal ID of option/answer
 * @param notLessThan     Lower inclusive boundary of correct answer range
 * @param notGreaterThan  Higher inclusive boundary of correct answer range
 */
case class NumericAnswer(id: Int = 0,
  notLessThan: BigDecimal,
  notGreaterThan: BigDecimal,
  questionId: Option[Int] = None,
  score: Option[Double] = None) extends Answer

/**
 * A key-value pair for a Matching question
 * @param id            Unique internal ID of option
 * @param text          Value text
 * @param keyText  Key text for the key this option should match, or None if this value should not match any key and is rendered for distraction only
 */
case class MatchingAnswer(id: Int = 0,
  text: String,
  keyText: Option[String],
  questionId: Option[Int] = None,
  score: Option[Double] = None) extends Answer

/**
 * An option for a Choice question
 * @param id        Unique internal ID of option
 * @param text      Option text
 * @param isCorrect True if this is a correct answer
 */
case class ChoiceAnswer(id: Int = 0,
  text: String,
  isCorrect: Boolean,
  questionId: Option[Int] = None,
  score: Option[Double] = None) extends Answer

/**
 * An option for a Categorization question
 * @param id                  Unique internal ID of option
 * @param text                Option text
 * @param answerCategoryText  Category text, or None if this value should not match any category
 */
case class CategorizationAnswer(id: Int = 0,
  text: String,
  answerCategoryText: Option[String],
  questionId: Option[Int] = None,
  score: Option[Double] = None) extends Answer