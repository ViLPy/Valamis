package com.arcusys.learn.facades

import java.io.InputStream

import com.arcusys.learn.models.{ QuizCategoryResponse, QuizResponse, _ }
import com.arcusys.learn.models.request.PackagePublishType
import com.arcusys.learn.models.response.CollectionResponse

trait QuizFacadeContract {
  def getAll(courseID: Int, filter: String, sortBy: String, sortDirectionAsc: Boolean, pageNumber: Int, pageSize: Int): CollectionResponse[QuizResponse]

  def create(title: String, description: String, logo: String, courseID: Int, maxDuration: Option[Int]): QuizResponse

  def delete(quizID: Int): Unit

  def publish(quizID: Int, userID: Long, groupID: Option[Long], publishType: PackagePublishType.Value,
    theme: Option[String], randomOrdering: Boolean, questionsPerUser: Option[Int]): QuizPublishStatusResponse

  def download(quizID: Int, courseID: Long, publishType: PackagePublishType.Value, theme: Option[String], randomOrdering: Boolean, questionsPerUser: Option[Int]): InputStream
  def downloadExternal(quizID: Int, courseID: Long, publishType: PackagePublishType.Value, theme: Option[String], randomOrdering: Boolean, questionsPerUser: Option[Int], portalURL: String): InputStream

  def update(quizID: Int, title: String, description: String, maxDuration: Option[Int]): Unit
  def updateLogo(quizId: Int, newLogo: String)

  def clone(quizID: Int): Unit

  def getContent(quizID: Int): Seq[QuizContentResponse]

  def getQuestionPreview(quizID: Int, questionID: String): QuizQuestionPreview

  def addCategory(quizID: Int, title: String): QuizCategoryResponse

  def addQuestion(quizID: Int, categoryID: Option[String], questionID: Int): QuizQuestionResponse

  def addQuestionPlainText(quizID: Int, categoryID: Option[String], title: String, text: String): QuizQuestionResponse

  def addQuestionRevealJS(quizID: Int, categoryID: Option[String], title: String, text: String): QuizQuestionResponse

  def addQuestionPDF(quizID: Int, categoryID: Option[String], title: String, filename: String): QuizQuestionResponse

  def addQuestionExternal(quizID: Int, categoryID: Option[String], title: String, url: String): QuizQuestionResponse

  def addVideo(quizID: Int, categoryID: Option[String], title: String, url: String, fromDL: Boolean, uuid: Option[String], groupId: Option[Long]): QuizQuestionResponse

  def moveElement(quizID: Int, elementID: String, parentID: Option[String], index: Int)

  def updateCategory(quizID: Int, categoryID: String, title: String): Unit

  def updateQuestion(quizID: Int, questionID: String, title: String, autoShowAnswer: Boolean): Unit

  def updateQuestionPlainText(quizID: Int, questionID: String, title: String): Unit

  def updateQuestionRevealJS(quizID: Int, questionID: String, title: String): Unit

  def updateQuestionPDF(quizID: Int, questionID: String, title: String): Unit

  def updateQuestionPPTX(questionID: String, title: String): Unit

  def updateQuestionExternal(quizID: Int, questionID: String, title: String, url: String): Unit

  def deleteCategory(quizID: Int, categoryID: String): Unit

  def deleteQuestion(quizID: Int, questionID: String): Unit

  def exportAllLessonsBase(courseID: Int): InputStream

  def exportLessons(quizIds: Seq[Int]): InputStream

  def importLessons(raw: String, courseID: Int): Unit
}
