package com.arcusys.learn.export.question

import java.io.FileInputStream

import com.arcusys.learn.bl.exceptions.EntityNotFoundException
import com.arcusys.learn.bl.export.ExportProcessor
import com.arcusys.learn.bl.services.QuestionServiceContract
import com.arcusys.learn.facades._
import com.arcusys.learn.models.AnswerResponse
import com.arcusys.learn.questionbank.model.{ Answer, Question, QuestionCategory }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class QuestionExportProcessor(implicit configuration: BindingModule) extends ExportProcessor[QuestionCategoryExport] with Injectable {

  override implicit def bindingModule: BindingModule = configuration

  private lazy val questionService = inject[QuestionServiceContract]

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
    val questionResponse = questionFacade.buildQuestion(question)
    QuestionExport(questionResponse.entityType,
      questionResponse.title,
      questionResponse.text,
      questionResponse.explanationText,
      questionResponse.forceCorrectCount,
      questionResponse.isCaseSensitive,
      questionResponse.answers.map(toAnswerExport),
      questionResponse.questionType,
      questionResponse.arrangementIndex)
  }

  private def toAnswerExport(answer: AnswerResponse) = {
    AnswerExport(answer.answerText, answer.isCorrect, answer.rangeFrom, answer.rangeTo, answer.matchingText, answer.score)
  }
}

