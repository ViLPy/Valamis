package com.arcusys.learn.controllers.api

import com.arcusys.learn.facades.QuizFacadeContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.permission._
import com.arcusys.learn.models.request.{ QuizActionType, QuizRequest }
import com.arcusys.learn.models.{ QuizQuestionPreviewContent, QuizQuestionPreviewRedirect }
import com.arcusys.valamis.lrs.serializer.StatementSerializer
import com.escalatesoft.subcut.inject.BindingModule
import org.json4s.{ DefaultFormats, Formats }
import PermissionUtil._

class QuizApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  def quiz: QuizFacadeContract = inject[QuizFacadeContract]

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/quiz(/)") {
    val lessonRequest = QuizRequest(this)
    PermissionUtil.requirePermissionApi(ViewPermission, PortletName.LessonDesigner)

    implicit val formats: Formats = DefaultFormats + new StatementSerializer
    lessonRequest.actionType match {
      case QuizActionType.GetAll => jsonAction(quiz.getAll(lessonRequest.courseId.toInt, lessonRequest.filter, lessonRequest.sortBy,
        lessonRequest.isSortDirectionAsc, lessonRequest.page, lessonRequest.count))
      case QuizActionType.GetContent => jsonAction(quiz.getContent(lessonRequest.id))
      case QuizActionType.QuestionPreview => quiz.getQuestionPreview(lessonRequest.lessonId, lessonRequest.idString) match {
        case QuizQuestionPreviewRedirect(url: String) => redirect(url)
        case QuizQuestionPreviewContent(content: String) =>
          response.setHeader("Content-Type", "text/html")
          content
      }
    }
  }

  post("/quiz(/)")(jsonAction {
    val data = QuizRequest(this)

    data.actionType match {
      case QuizActionType.Add |
        QuizActionType.Delete |
        QuizActionType.Update |
        QuizActionType.UpdateLogo |
        QuizActionType.Clone =>
        PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.LessonDesigner)

      case QuizActionType.Publish => PermissionUtil.requirePermissionApi(PublishPermission, PortletName.LessonDesigner)
      case _                      =>
    }

    data.actionType match {
      case QuizActionType.Add                     => quiz.create(data.title, data.description, data.logoOption.getOrElse(""), data.courseId.toInt, data.maxDuration)
      case QuizActionType.Delete                  => quiz.delete(data.id)
      case QuizActionType.Publish                 => quiz.publish(data.id, getUserId, data.courseId, data.publishType, data.theme, data.randomOrdering, data.questionPerUser, data.scoreLimit)
      case QuizActionType.Update                  => quiz.update(data.id, data.title, data.description, data.maxDuration)
      case QuizActionType.UpdateLogo              => quiz.updateLogo(data.id, data.logo)
      case QuizActionType.Clone                   => quiz.clone(data.id)
      case QuizActionType.Convert                 => quiz.convert(data.id, data.courseId)

      case QuizActionType.AddCategory             => quiz.addCategory(data.lessonId, data.title)
      case QuizActionType.AddQuestion             => quiz.addQuestion(data.lessonId, data.categoryIdOption, data.bankQuestionId)
      case QuizActionType.AddQuestions            => data.bankQuestionIds.map(q => quiz.addQuestion(data.lessonId, data.categoryIdOption, q))
      case QuizActionType.AddQuestionPlainText    => quiz.addQuestionPlainText(data.lessonId, data.categoryIdOption, data.title, data.text)
      case QuizActionType.AddQuestionRevealJS     => quiz.addQuestionRevealJS(data.lessonId, data.categoryIdOption, data.title, data.text)
      case QuizActionType.AddQuestionPDF          => null
      case QuizActionType.AddQuestionExternal     => quiz.addQuestionExternal(data.lessonId, data.categoryIdOption, data.title, data.url)
      case QuizActionType.AddVideo                => quiz.addVideo(data.lessonId, data.categoryIdOption, data.title, data.url, data.videoFromDL, data.uuid, data.courseId)

      case QuizActionType.UpdateCategory          => quiz.updateCategory(data.lessonId, data.idString, data.title)
      case QuizActionType.UpdateQuestion          => quiz.updateQuestion(data.lessonId, data.idString, data.title, data.autoShowAnswer.getOrElse(false))
      case QuizActionType.UpdateQuestionPlainText => quiz.updateQuestionPlainText(data.lessonId, data.idString, data.title)
      case QuizActionType.UpdateQuestionRevealJS  => quiz.updateQuestionRevealJS(data.lessonId, data.idString, data.title)
      case QuizActionType.UpdateQuestionPDF       => quiz.updateQuestionPDF(data.lessonId, data.idString, data.title)
      case QuizActionType.UpdateQuestionPPTX      => quiz.updateQuestionPPTX(data.idString, data.title)
      case QuizActionType.UpdateQuestionExternal  => quiz.updateQuestionExternal(data.lessonId, data.idString, data.title, data.url)
      case QuizActionType.UpdateQuestionDLVideo   => quiz.updateQuestion(data.lessonId, data.idString, data.title, data.autoShowAnswer.getOrElse(false))

      case QuizActionType.DeleteCategory          => quiz.deleteCategory(data.lessonId, data.idString)
      case QuizActionType.DeleteQuestion          => quiz.deleteQuestion(data.lessonId, data.idString)

      case QuizActionType.MoveElement             => quiz.moveElement(data.lessonId, data.idString, data.categoryIdOption, data.index)
    }
  })
}
