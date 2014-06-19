package com.arcusys.learn.facades

import com.arcusys.learn.models._
import com.arcusys.learn.models.QuizResponse
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.models.QuizCategoryResponse
import java.io.InputStream

trait QuizFacadeContract {
  def getAll(filter: String, sortBy: String, sortDirectionAsc: Boolean, pageNumber: Int, pageSize: Int): CollectionResponse[QuizResponse]

  def create(title: String, description: String, logo: String, courseID: Int): QuizResponse

  def delete(quizID: Int): Unit

  def publish(quizID: Int, userID: Long, groupID: Option[Long]): QuizPublishStatusResponse

  def download(quizID: Int, courseID: Long): InputStream

  def update(quizID: Int, title: String, description: String, logo: String): Unit

  def clone(quizID: Int): Unit

  def getContent(quizID: Int): Seq[QuizContentResponse]

  def getQuestionPreview(questionID: String): QuizQuestionPreview

  def addCategory(quizID: Int, title: String): QuizCategoryResponse

  def addQuestion(quizID: Int, categoryID: Option[String], questionID: Int): QuizQuestionResponse

  def addQuestionPlainText(quizID: Int, categoryID: Option[String], title: String, text: String): QuizQuestionResponse

  def addQuestionRevealJS(quizID: Int, categoryID: Option[String], title: String, text: String): QuizQuestionResponse

  def addQuestionExternal(quizID: Int, categoryID: Option[String], title: String, url: String): QuizQuestionResponse

  def moveElement(quizID: Int, elementID: String, parentID: Option[String], index: Int)

  def updateCategory(quizID: Int, categoryID: String, title: String): Unit

  def updateQuestion(quizID: Int, questionID: String, title: String): Unit

  def updateQuestionPlainText(quizID: Int, questionID: String, title: String): Unit

  def updateQuestionRevealJS(quizID: Int, questionID: String, title: String, text: String): Unit

  def updateQuestionExternal(quizID: Int, questionID: String, title: String, url: String): Unit

  def deleteCategory(quizID: Int, categoryID: String): Unit

  def deleteQuestion(quizID: Int, questionID: String): Unit
}
