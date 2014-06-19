package com.arcusys.learn.controllers.api

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.{ QuizActionType, QuizRequest }
import com.arcusys.learn.facades.{ QuizFacade, QuizFacadeContract }
import org.json4s.{ DefaultFormats, Formats }
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer.StatementSerializer
import com.arcusys.learn.models.{ QuizQuestionPreviewRedirect, QuizQuestionPreviewContent }

class QuizApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  def quiz: QuizFacadeContract = new QuizFacade

  get("/") {
    val lessonRequest = QuizRequest(this)

    implicit val formats: Formats = DefaultFormats + new StatementSerializer
    lessonRequest.actionType match {
      case QuizActionType.GetAll => jsonAction(quiz.getAll(lessonRequest.filter, lessonRequest.sortBy,
        lessonRequest.isSortDirectionAsc, lessonRequest.page, lessonRequest.count))
      case QuizActionType.GetContent => jsonAction(quiz.getContent(lessonRequest.id))
      case QuizActionType.Download =>
        response.setHeader("Content-Type", "application/zip")
        quiz.download(lessonRequest.id, lessonRequest.courseID)
      case QuizActionType.QuestionPreview => quiz.getQuestionPreview(lessonRequest.idString) match {
        case QuizQuestionPreviewRedirect(url: String) => redirect(url)
        case QuizQuestionPreviewContent(content: String) =>
          response.setHeader("Content-Type", "text/html")
          content
      }
    }
  }

  post("/")(jsonAction {
    val lessonRequest = QuizRequest(this)

    lessonRequest.actionType match {
      case QuizActionType.Add                     => quiz.create(lessonRequest.title, lessonRequest.description, lessonRequest.logo, lessonRequest.courseID)
      case QuizActionType.Delete                  => quiz.delete(lessonRequest.id)
      case QuizActionType.Publish                 => quiz.publish(lessonRequest.id, getSessionUserID, lessonRequest.groupID)
      case QuizActionType.Update                  => quiz.update(lessonRequest.id, lessonRequest.title, lessonRequest.description, lessonRequest.logo)
      case QuizActionType.Clone                   => quiz.clone(lessonRequest.id)

      case QuizActionType.AddCategory             => quiz.addCategory(lessonRequest.lessonId, lessonRequest.title)
      case QuizActionType.AddQuestion             => quiz.addQuestion(lessonRequest.lessonId, lessonRequest.categoryIdOption, lessonRequest.bankQuestionId)
      case QuizActionType.AddQuestions            => lessonRequest.bankQuestionIds.foreach(q => quiz.addQuestion(lessonRequest.lessonId, lessonRequest.categoryIdOption, q))
      case QuizActionType.AddQuestionPlainText    => quiz.addQuestionPlainText(lessonRequest.lessonId, lessonRequest.categoryIdOption, lessonRequest.title, lessonRequest.text)
      case QuizActionType.AddQuestionRevealJS     => quiz.addQuestionRevealJS(lessonRequest.lessonId, lessonRequest.categoryIdOption, lessonRequest.title, lessonRequest.text)
      case QuizActionType.AddQuestionExternal     => quiz.addQuestionExternal(lessonRequest.lessonId, lessonRequest.categoryIdOption, lessonRequest.title, lessonRequest.url)

      case QuizActionType.UpdateCategory          => quiz.updateCategory(lessonRequest.lessonId, lessonRequest.idString, lessonRequest.title)
      case QuizActionType.UpdateQuestion          => quiz.updateQuestion(lessonRequest.lessonId, lessonRequest.idString, lessonRequest.title)
      case QuizActionType.UpdateQuestionPlainText => quiz.updateQuestionPlainText(lessonRequest.lessonId, lessonRequest.idString, lessonRequest.title)
      case QuizActionType.UpdateQuestionRevealJS  => quiz.updateQuestionRevealJS(lessonRequest.lessonId, lessonRequest.idString, lessonRequest.title, lessonRequest.text)
      case QuizActionType.UpdateQuestionExternal  => quiz.updateQuestionExternal(lessonRequest.lessonId, lessonRequest.idString, lessonRequest.title, lessonRequest.url)

      case QuizActionType.DeleteCategory          => quiz.deleteCategory(lessonRequest.lessonId, lessonRequest.idString)
      case QuizActionType.DeleteQuestion          => quiz.deleteQuestion(lessonRequest.lessonId, lessonRequest.idString)

      case QuizActionType.MoveElement             => quiz.moveElement(lessonRequest.lessonId, lessonRequest.idString, lessonRequest.categoryIdOption, lessonRequest.index)
    }
  })
}
