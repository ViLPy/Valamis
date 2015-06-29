package com.arcusys.learn.export.question

import java.io.FileInputStream
import com.arcusys.learn.facades._
import com.arcusys.learn.models.AnswerResponse
import com.arcusys.valamis.exception.EntityNotFoundException
import com.arcusys.valamis.export.ExportProcessor
import com.arcusys.valamis.questionbank.model.{ QuestionCategory, Question, Answer }
import com.arcusys.valamis.questionbank.service.QuestionService
import com.arcusys.valamis.util.ZipBuilder
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class QuestionExportProcessor(implicit val bindingModule: BindingModule) extends ExportProcessor[QuestionCategoryExport, QuestionCategoryExport] with Injectable {

  override protected def exportItemsImpl(zip: ZipBuilder, items: Seq[QuestionCategoryExport]): Seq[QuestionCategoryExport] = items

  private lazy val questionService = inject[QuestionService]

  private lazy val questionFacade = inject[QuestionFacadeContract]

  def exportAll(courseID: Option[Int]): FileInputStream = {
    val questionsWithoutCategory = questionService.getQuestionsByCategory(None, courseID)
    var items = Seq(QuestionCategoryExport("root", "", questionsWithoutCategory.map(toQuestionExport)))

    val categories = questionService.getCategories(courseID)

    items = items ++ categories.map(toCategoryExport(_, courseID))

    if (items.size == 0)
      throw new EntityNotFoundException("No questions to export")
    exportItems(items)
  }

  def exportIds(categoryIDs: Seq[Int], questionIds: Seq[Int], courseID: Option[Int]): FileInputStream = {

    var items = Seq[QuestionCategoryExport]()

    val categories = categoryIDs.map(questionService.getCategory)
    val questions = questionIds.map(questionService.getQuestion)
    val questionCategories = questions.map(q => q.categoryID).distinct.filter(cID => cID.isDefined && !categoryIDs.contains(cID.get)).map(_.get)

    var rootCategoryQuestions = Seq[QuestionExport]()

    questions.foreach(q => {
      if (!q.categoryID.isDefined) {
        rootCategoryQuestions = Seq(toQuestionExport(q)) ++ rootCategoryQuestions
      }
    })

    items = items ++ Seq(QuestionCategoryExport("root", "", rootCategoryQuestions))
    items = items ++ categories.map(toCategoryExport(_, courseID))

    questionCategories.foreach(qc => {
      val category = questionService.getCategory(qc)
      items = items ++ Seq(QuestionCategoryExport(
        category.title,
        category.description,
        questions.filter(q => q.categoryID.isDefined && q.categoryID.get == category.id).map(toQuestionExport),
        "folder",
        category.arrangementIndex))
    })

    if (items.size == 0)
      throw new EntityNotFoundException("No questions to export")
    exportItems(items)

  }

  private def toCategoryExport(category: QuestionCategory, courseID: Option[Int]) = {
    val questions = questionService.getQuestionsByCategory(Option(category.id), courseID)
    QuestionCategoryExport(
      category.title,
      category.description,
      questions.map(toQuestionExport),
      "folder",
      category.arrangementIndex)
  }

  private def toQuestionExport(question: Question[Answer]) = {
    val questionResponse = questionFacade.buildQuestionResponse(question)
    QuestionExport(entityType = questionResponse.entityType,
      title = questionResponse.title,
      text = questionResponse.text,
      explanationText = questionResponse.explanationText,
      rightAnswerText = Some(questionResponse.rightAnswerText),
      wrongAnswerText = Some(questionResponse.wrongAnswerText),
      forceCorrectCount = questionResponse.forceCorrectCount,
      isCaseSensitive = questionResponse.isCaseSensitive,
      answers = questionResponse.answers.map(toAnswerExport),
      questionType = questionResponse.questionType,
      arrangementIndex = questionResponse.arrangementIndex)
  }

  private def toAnswerExport(answer: AnswerResponse) = {
    AnswerExport(answer.answerText, answer.isCorrect, answer.rangeFrom, answer.rangeTo, answer.matchingText, answer.score)
  }

}

