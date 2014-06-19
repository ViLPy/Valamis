package com.arcusys.learn.facades

import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.{ AnswerResponse, QuestionResponse }
import com.arcusys.learn.questionbank.storage.{ QuestionStorage, QuestionCategoryStorage }
import com.arcusys.learn.questionbank.model._
import com.arcusys.learn.questionbank.model.MatchingQuestion
import com.arcusys.learn.questionbank.model.CategorizationQuestion
import com.arcusys.learn.questionbank.model.EssayQuestion
import com.arcusys.learn.questionbank.model.NumericQuestion
import com.arcusys.learn.questionbank.model.ChoiceQuestion
import com.arcusys.learn.questionbank.model.TextQuestion
import com.arcusys.learn.questionbank.model.PositioningQuestion
import com.arcusys.learn.questionbank.model.EmbeddedAnswerQuestion

/**
 * User: Yulia.Glushonkova
 * Date: 05.05.14
 */
class QuestionFacade(configuration: BindingModule) extends QuestionFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration
  val questionStorage = inject[QuestionStorage]
  val questionCategoryStorage = inject[QuestionCategoryStorage]

  def buildQuestion(question: Question[Answer]) = {

    // buildAnswersData method using in the QuestionResponse. May be should encapsulate?
    def buildAnswersData = {
      question match {
        case e: ChoiceQuestion =>
          for (answer <- e.answers) yield new AnswerResponse(answer.text, answer.isCorrect)
        case e: TextQuestion =>
          for (answer <- e.answers) yield new AnswerResponse(answer.text)
        case e: NumericQuestion =>
          for (answer <- e.answers) yield new AnswerResponse(rangeFrom = answer.notLessThan, rangeTo = answer.notGreaterThan)
        case e: PositioningQuestion =>
          for (answer <- e.answers) yield new AnswerResponse(answerText = answer.text, isCorrect = answer.isCorrect)
        case e: MatchingQuestion =>
          for (answer <- e.answers) yield new AnswerResponse(answerText = answer.text, matchingText = answer.keyText.getOrElse(""))
        case e: CategorizationQuestion =>
          for (answer <- e.answers) yield new AnswerResponse(answerText = answer.text, matchingText = answer.answerCategoryText.getOrElse(""))
        case e: EssayQuestion          => Seq[AnswerResponse]()
        case e: EmbeddedAnswerQuestion => Seq[AnswerResponse]()
        case e: PlainText              => Seq[AnswerResponse]()
        case _                         => throw new Exception("Service: Oops! Can't recognize question type")
      }
    }

    val forceCorrectCount = question match {
      case e: ChoiceQuestion      => e.forceCorrectCount
      case e: PositioningQuestion => e.forceCorrectCount
      case _                      => false
    }

    val isCaseSensitive = question match {
      case e: TextQuestion => e.isCaseSensitive
      case _               => false
    }

    new QuestionResponse(
      id = question.id,
      entityType = "entity",
      title = question.title,
      text = question.text,
      explanationText = question.explanationText,
      forceCorrectCount = forceCorrectCount,
      isCaseSensitive = isCaseSensitive,
      answers = buildAnswersData,
      questionType = question.questionTypeCode,
      categoryID = question.categoryID.getOrElse(-1))
  }

  def getByID(id: Int): QuestionResponse = {
    val question = questionStorage.getByID(id).get
    buildQuestion(question)
  }

  def getChildren(id: Option[Int], courseID: Option[Int]): Seq[QuestionResponse] = {
    val items = questionStorage.getByCategory(id, courseID)
    items map buildQuestion
  }

  def create(categoryID: Option[Int],
    questionType: Int,
    title: String,
    text: String,
    explanationText: String,
    forceCorrectCount: Boolean,
    isCaseSensitive: Boolean,
    courseID: Option[Int]): QuestionResponse = {

    // May be create enum for questionType?
    val entity = questionType match {
      case 0 => new ChoiceQuestion(0, categoryID, title, text, explanationText, Nil, forceCorrectCount, courseID)
      case 1 => new TextQuestion(0, categoryID, title, text, explanationText, Nil, isCaseSensitive, courseID)
      case 2 => new NumericQuestion(0, categoryID, title, text, explanationText, Nil, courseID)
      case 3 => new PositioningQuestion(0, categoryID, title, text, explanationText, Nil, forceCorrectCount, courseID)
      case 4 => new MatchingQuestion(0, categoryID, title, text, explanationText, Nil, courseID)
      case 5 => new EssayQuestion(0, categoryID, title, text, explanationText, courseID)
      case 6 => new EmbeddedAnswerQuestion(0, categoryID, title, text, explanationText, courseID)
      case 7 => new CategorizationQuestion(0, categoryID, title, text, explanationText, Nil, courseID)
      case 8 => new PlainText(0, categoryID, title, text, courseID)
    }
    val question = questionStorage.getByID(questionStorage.createAndGetID(entity)).get
    buildQuestion(question)
  }

  def update(id: Int,
    categoryID: Option[Int],
    questionType: Int,
    title: String,
    text: String,
    explanationText: String,
    forceCorrectCount: Boolean,
    isCaseSensitive: Boolean,
    courseID: Option[Int],

    // Remove response model from request
    answers: List[AnswerResponse]): QuestionResponse = {

    // Duplicate: May be should create enum for a questionType?
    val entity = questionType match {
      case 0 => new ChoiceQuestion(id, categoryID, title, text, explanationText, answers.map(parseChoiceAnswer(_)), forceCorrectCount, courseID)
      case 1 => new TextQuestion(id, categoryID, title, text, explanationText, answers.map(parseTextAnswer(_)), isCaseSensitive, courseID)
      case 2 => new NumericQuestion(id, categoryID, title, text, explanationText, answers.map(parseNumericAnswer(_)), courseID)
      case 3 => new PositioningQuestion(id, categoryID, title, text, explanationText, answers.map(parsePositioningAnswer(_)), forceCorrectCount, courseID)
      case 4 => new MatchingQuestion(id, categoryID, title, text, explanationText, answers.map(parseMatchingAnswer(_)), courseID)
      case 5 => new EssayQuestion(id, categoryID, title, text, explanationText, courseID)
      case 6 => new EmbeddedAnswerQuestion(id, categoryID, title, text, explanationText, courseID)
      case 7 => new CategorizationQuestion(id, categoryID, title, text, explanationText, answers.map(parseCategorizationAnswer(_)), courseID)
      case 8 => new PlainText(id, categoryID, title, text, courseID)
    }
    questionStorage.modify(entity)
    buildQuestion(entity)
  }

  def delete(id: Int) {
    questionStorage.delete(id)
  }

  def move(id: Int,
    // Duplicate: Exist DndModeType object
    dndMode: String,
    targetID: Option[Int],
    itemType: String) {
    val moveAfterTarget = dndMode == "after"

    val siblingID = if (dndMode == "last" || (dndMode == "after" && itemType == "folder")) None
    else targetID

    val parentID = if (targetID != None && dndMode == "last") targetID
    else if (targetID != None && (dndMode == "after" && itemType == "folder")) questionCategoryStorage.getByID(targetID.get).get.parentID
    else if (siblingID != None) questionStorage.getByID(targetID.get).get.categoryID
    else None

    questionStorage.move(id, parentID, siblingID, moveAfterTarget)
    buildQuestion(questionStorage.getByID(id).get)
  }

  private def parseChoiceAnswer(data: AnswerResponse) = new ChoiceAnswer(0, data.answerText, data.isCorrect)

  private def parseTextAnswer(data: AnswerResponse) = new TextAnswer(0, data.answerText)

  private def parseNumericAnswer(data: AnswerResponse) = new NumericAnswer(0, data.rangeFrom, data.rangeTo)

  private def parsePositioningAnswer(data: AnswerResponse) = new PositioningAnswer(0, data.answerText, data.isCorrect)

  private def parseMatchingAnswer(data: AnswerResponse) = new MatchingAnswer(0, data.answerText, Some(data.matchingText))

  private def parseCategorizationAnswer(data: AnswerResponse) = new CategorizationAnswer(0, data.answerText, Some(data.matchingText))

}

