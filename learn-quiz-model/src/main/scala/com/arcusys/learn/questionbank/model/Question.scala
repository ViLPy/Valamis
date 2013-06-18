package com.arcusys.learn.questionbank.model

/**
 * Base class for a question in a question bank
 * @tparam AnswerType       Type of answers to use
 */
sealed trait Question[+AnswerType <: Answer] {
  /**
   * Integer representation of question type
   */
  def questionTypeCode: Int
  /**
   * Unique internal ID of question
   */
  def id: Int
  /**
   * ID of the category the question belongs to (None if question is in root of bank)
   */
  def categoryID: Option[Int]
  /**
   *  Title of question (used mostly for admin purposes to quickly find question in list)
   */
  def title: String
  /**
   *  Question text. Formulates the problem to the user.
   */
  def text: String
  /**
   *  Explanation text. Describes what answer is correct and why. Not to be displayed when asking answer from user
   */
  def explanationText: String
  /**
   * Ordered sequence of answer options or correct answers (depending on question type)
   */
  def answers: Seq[AnswerType]
  /**
   * Course ID
   */
  def courseID: Option[Int]

  def arrangementIndex: Int
}

/**
   * Consist of a passage of text (in specific format) that has  various answers embedded within it,
   * including multiple choice, text answers and numerical answers.
   * Currently not fully supported
   */
case class EmbeddedAnswerQuestion (
                                    id: Int,
                                    categoryID: Option[Int],
                                    title: String,
                                    text: String,
                                    explanationText: String,
                                    courseID: Option[Int],
                                    arrangementIndex: Int = 1
    ) extends Question[Nothing]{
  val questionTypeCode = 6
  val answers = Nil
}

/**
   * Essay - intended for short answers of a paragraph or two, that one often finds on exams
   * Currently not fully supported
   */
case class EssayQuestion
  (
    id: Int,
    categoryID: Option[Int],
    title: String,
    text: String,
    explanationText: String,
    courseID: Option[Int],
    arrangementIndex: Int = 1

    ) extends Question[Nothing]{
  val questionTypeCode = 5
  val answers = Nil
}

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
case class MatchingQuestion
  (
    id: Int,
    categoryID: Option[Int],
    title: String,
    text: String,
    explanationText: String,
    override val answers: Seq[MatchingAnswer],
    courseID: Option[Int],
    arrangementIndex: Int = 1
    )
    extends Question[MatchingAnswer] {
  val questionTypeCode = 4
}

/**
   * A question requiring a user to provide a number as an answer
   * In the UI will most likely be rendered as a text box which accepts only numbers
   * @param id              Unique internal ID of question
   * @param categoryID      ID of the category the question belongs to (None if no category)
   * @param title           Title of question (used mostly for admin purposes to quickly find question in list)
   * @param text            Question text. Formulates the problem to the user.
   * @param explanationText Explanation text. Describes what answer is correct and why.
   * @param answers         Ordered sequence of correct answers (not shown to user).
   *                        The order appears while editing the question, but does not matter during tests
   *                        It is typical to have only one answer in this collection
   */
case class NumericQuestion
  (
    id: Int,
    categoryID: Option[Int],
    title: String,
    text: String,
    explanationText: String,
    override val answers: Seq[NumericAnswer],
    courseID: Option[Int],
    arrangementIndex: Int = 1
    )
    extends Question[NumericAnswer] {
  val questionTypeCode = 2
}

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
case class PositioningQuestion
  (
    id: Int,
    categoryID: Option[Int],
    title: String,
    text: String,
    explanationText: String,
    override val answers: Seq[PositioningAnswer],
    forceCorrectCount: Boolean,
    courseID: Option[Int],
    arrangementIndex: Int = 1
    )
    extends Question[PositioningAnswer] {
  val questionTypeCode = 3
}

/**
   * A question requiring a user to provide a textual string as an answer
   * In the UI will most likely be rendered as a text box
   * @param id              Unique internal ID of question
   * @param categoryID      ID of the category the question belongs to (None if no category)
   * @param title           Title of question (used mostly for admin purposes to quickly find question in list)
   * @param text            Question text. Formulates the problem to the user.
   * @param explanationText Explanation text. Describes what answer is correct and why.
   * @param answers         Ordered sequence of correct answers (not shown to user).
   *                        The order appears while editing the question, but does not matter during tests.
   *                        It is typical to have only one answer in this collection
   * @param isCaseSensitive If true, the check whether the answer is correct or not is case-sensitive. If false, the check is case-insensitive
   */
case class TextQuestion
  (
    id: Int,
    categoryID: Option[Int],
    title: String,
    text: String,
    explanationText: String,
    override val answers: Seq[TextAnswer],
    isCaseSensitive: Boolean,
    courseID: Option[Int],
    arrangementIndex: Int = 1
    )
    extends Question[TextAnswer] {
  val questionTypeCode = 1
}

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
case class ChoiceQuestion
  (
    id: Int,
    categoryID: Option[Int],
    title: String,
    text: String,
    explanationText: String,
    override val answers: Seq[ChoiceAnswer],
    forceCorrectCount: Boolean,
    courseID: Option[Int],
    arrangementIndex: Int = 1
    )
    extends Question[ChoiceAnswer] {
  val questionTypeCode = 0
}

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
case class CategorizationQuestion
  (
    id: Int,
    categoryID: Option[Int],
    title: String,
    text: String,
    explanationText: String,
    override val answers: Seq[CategorizationAnswer],
    courseID: Option[Int],
    arrangementIndex: Int = 1
    ) extends Question[CategorizationAnswer] {
  val questionTypeCode = 7
}


/**
   * PlainText - just plain text page
   */
case class PlainText
  (
    id: Int,
    categoryID: Option[Int],
    title: String,
    text: String,
    courseID: Option[Int],
    arrangementIndex: Int = 1

    ) extends Question[Nothing]{
  val questionTypeCode = 8
  val answers = Nil
  val explanationText = ""
}
