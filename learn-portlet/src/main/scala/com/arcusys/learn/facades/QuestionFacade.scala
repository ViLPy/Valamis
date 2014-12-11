package com.arcusys.learn.facades

import java.io.InputStream

import com.arcusys.learn.bl.services.QuestionServiceContract
import com.arcusys.learn.export.question.{ QuestionImportProcessor, QuestionExportProcessor }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.{ AnswerResponse, QuestionResponse }
import com.arcusys.learn.questionbank.model.{ CategorizationQuestion, ChoiceQuestion, EmbeddedAnswerQuestion, EssayQuestion, MatchingQuestion, NumericQuestion, PositioningQuestion, TextQuestion, _ }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

import scala.util.Try

class QuestionFacade(configuration: BindingModule) extends QuestionFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  val questionService = inject[QuestionServiceContract]

  def buildQuestion(question: Question[Answer]) = {

    // buildAnswersData method using in the QuestionResponse. May be should encapsulate?
    def buildAnswersData = {

      question match {
        case e: ChoiceQuestion =>
          e.answers.map(answer => {
            new AnswerResponse(answerText = answer.text, isCorrect = answer.isCorrect, questionId = e.id, score = answer.score)
          })
        case e: TextQuestion =>
          e.answers.map(answer => {
            new AnswerResponse(answerText = answer.text, questionId = e.id, score = answer.score)
          })
        case e: NumericQuestion =>
          e.answers.map(answer => {
            new AnswerResponse(rangeFrom = answer.notLessThan, rangeTo = answer.notGreaterThan, questionId = e.id, score = answer.score)
          })
        case e: PositioningQuestion =>
          e.answers.map(answer => {
            new AnswerResponse(answerText = answer.text, isCorrect = answer.isCorrect, questionId = e.id, score = answer.score)
          })
        case e: MatchingQuestion =>
          e.answers.map(answer => {
            new AnswerResponse(answerText = answer.text, matchingText = answer.keyText.getOrElse(""), questionId = e.id, score = answer.score)
          })
        case e: CategorizationQuestion =>
          e.answers.map(answer => {
            new AnswerResponse(answerText = answer.text, matchingText = answer.answerCategoryText.getOrElse(""), questionId = e.id, score = answer.score)
          })
        case e: EssayQuestion          => Seq[AnswerResponse]()
        case e: EmbeddedAnswerQuestion => Seq[AnswerResponse]()
        case e: PlainText              => Seq[AnswerResponse]()
        case e: PurePlainText          => Seq[AnswerResponse]()
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

  def getQuestion(id: Int): QuestionResponse = {
    buildQuestion(questionService.getQuestion(id))
  }

  def getChildren(categoryID: Option[Int], courseID: Option[Int]): Seq[QuestionResponse] = {
    questionService.getQuestionsByCategory(categoryID, courseID) map buildQuestion
  }

  def createQuestion(categoryID: Option[Int],
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
      case 9 => new PurePlainText(0, categoryID, title, text, courseID)
    }
    buildQuestion(questionService.createQuestion(entity))
  }

  def updateQuestion(id: Int,
    categoryID: Option[Int],
    questionType: Int,
    title: String,
    text: String,
    explanationText: String,
    forceCorrectCount: Boolean,
    isCaseSensitive: Boolean,
    courseID: Option[Int],
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
      case 9 => new PurePlainText(id, categoryID, title, text, courseID)
    }
    var question = questionService.updateQuestion(entity)

    buildQuestion(question)
  }

  def deleteQuestion(id: Int) {
    questionService.deleteQuestion(id)
  }

  def move(id: Int, index: Int, parentID: Option[Int]) {
    var question = questionService.moveQuestion(id, index, parentID)
    buildQuestion(question)
  }

  def moveToCourse(id: Int, courseID: Option[Int]) {
    questionService.moveQuestionToCourse(id, courseID, true)
  }

  //  def createAnswer(
  //    questionId: Long,
  //    answerText: String,
  //    isCorrect: Boolean,
  //    rangeFrom: BigDecimal,
  //    rangeTo: BigDecimal,
  //    matchingText: String,
  //    score: Option[Double]): AnswerResponse = {
  //
  //    val question = questionStorage.getByID(questionId.toInt).get
  //
  //    val entity = question.questionTypeCode match {
  //      case 0 => new ChoiceAnswer(0, answerText, isCorrect, Some(questionId.toInt))
  //      case 1 => new TextAnswer(0, answerText, Some(questionId.toInt))
  //      case 2 => new NumericAnswer(0, rangeFrom, rangeTo, Some(questionId.toInt))
  //      case 3 => new PositioningAnswer(0, answerText, isCorrect, Some(questionId.toInt))
  //      case 4 => new MatchingAnswer(0, answerText, Some(matchingText), Some(questionId.toInt))
  //      case 7 => new CategorizationAnswer(0, answerText, Some(matchingText), Some(questionId.toInt))
  //    }
  //    val answer = answerRepository.create(entity)
  //
  //    score.foreach(value => answerScoreRepository.create(
  //      new AnswerScore(answer.id, value)))
  //
  //    AnswerResponse(entity.id, answerText, isCorrect, rangeFrom, rangeTo, matchingText, score)
  //  }
  //
  //  def updateAnswer(answerId: Long,
  //    answerText: String,
  //    isCorrect: Boolean,
  //    rangeFrom: BigDecimal,
  //    rangeTo: BigDecimal,
  //    matchingText: String,
  //    score: Option[Double]): AnswerResponse = {
  //    val answer = answerRepository.get(answerId)
  //    val question = questionStorage.getByID(answer.questionId.get).get
  //
  //    val entity = question.questionTypeCode match {
  //      case 0 => new ChoiceAnswer(0, answerText, isCorrect)
  //      case 1 => new TextAnswer(0, answerText)
  //      case 2 => new NumericAnswer(0, rangeFrom, rangeTo)
  //      case 3 => new PositioningAnswer(0, answerText, isCorrect)
  //      case 4 => new MatchingAnswer(0, answerText, Some(matchingText))
  //      case 7 => new CategorizationAnswer(0, answerText, Some(matchingText))
  //    }
  //
  //    answerRepository.modify(entity)
  //
  //    score.foreach(value => {
  //      val answerScore = answerScoreRepository.getScoreEntity(answerId)
  //      answerScoreRepository.modify(answerScore.copy(score = value))
  //    })
  //
  //    AnswerResponse(entity.id, answerText, isCorrect, rangeFrom, rangeTo, matchingText, score)
  //  }
  //
  //  def deleteAnswer(answerId: Long) = {
  //    val answer = answerRepository.get(answerId)
  //    answerRepository.delete(answer)
  //
  //    Try {
  //      val answerScore = answerScoreRepository.getScoreEntity(answerId)
  //      answerScoreRepository.delete(answerScore)
  //    }
  //  }

  private def parseChoiceAnswer(data: AnswerResponse) = new ChoiceAnswer(0, data.answerText, data.isCorrect, score = data.score)

  private def parseTextAnswer(data: AnswerResponse) = new TextAnswer(0, data.answerText, score = data.score)

  private def parseNumericAnswer(data: AnswerResponse) = new NumericAnswer(0, data.rangeFrom, data.rangeTo, score = data.score)

  private def parsePositioningAnswer(data: AnswerResponse) = new PositioningAnswer(0, data.answerText, data.isCorrect, score = data.score)

  private def parseMatchingAnswer(data: AnswerResponse) = new MatchingAnswer(0, data.answerText, Some(data.matchingText), score = data.score)

  private def parseCategorizationAnswer(data: AnswerResponse) = new CategorizationAnswer(0, data.answerText, Some(data.matchingText), score = data.score)

  override def exportAllQuestionsBase(courseID: Option[Int]): InputStream = {
    new QuestionExportProcessor().exportAll(courseID)
  }

  override def importQuestions(filename: String, courseID: Int): Unit = {
    new QuestionImportProcessor().importItems(filename, courseID)
  }

  override def exportQuestions(categoryIds: Seq[Int], questionIds: Seq[Int], courseID: Option[Int]): InputStream = {
    new QuestionExportProcessor().exportIds(categoryIds, questionIds, courseID)
  }

}