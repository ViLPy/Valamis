package com.arcusys.learn.controllers.api

import com.arcusys.learn.facades.QuestionFacadeContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.permission.{ PortletName, PermissionUtil, ModifyPermission, ViewPermission }
import com.arcusys.learn.models.{ AnswerSerializer, AnswerResponse }
import com.arcusys.learn.models.request.{ QuestionActionType, QuestionRequest }
import com.escalatesoft.subcut.inject.BindingModule
import org.json4s.{ DefaultFormats, Formats }

class QuestionApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  lazy val questionFacade = inject[QuestionFacadeContract]

  def this() = this(Configuration)

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/questions(/)(:id)")(jsonAction {
    val questionRequest = QuestionRequest(this)
    PermissionUtil.requirePermissionApi(ViewPermission,
      PortletName.ContentManager,
      PortletName.LessonDesigner,
      PortletName.SlidesEditor)
    questionRequest.action match {
      case QuestionActionType.GetById => questionFacade.getQuestion(questionRequest.id)

      case QuestionActionType.GetChildren =>
        questionFacade.getChildren(questionRequest.idOption, questionRequest.courseId)
    }
  })

  post("/questions(/)(:id)")(jsonAction {
    val questionRequest = QuestionRequest(this)
    PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.ContentManager)
    val result = questionRequest.action match {

      case QuestionActionType.Add =>
        implicit val fs: Formats = DefaultFormats + new AnswerSerializer
        val answers = parseJson[List[AnswerResponse]](questionRequest.answers).get

        questionFacade.createQuestion(
          questionRequest.categoryId,
          questionRequest.questionType,
          questionRequest.title,
          questionRequest.text,
          questionRequest.explanationText,
          questionRequest.rightAnswerText,
          questionRequest.wrongAnswerText,
          questionRequest.forceCorrectCount,
          questionRequest.isCaseSensitive,
          questionRequest.courseId,
          answers
        )
      case QuestionActionType.Update =>
        implicit val fs: Formats = DefaultFormats + new AnswerSerializer
        val answers = parseJson[List[AnswerResponse]](questionRequest.answers).get

        questionFacade.updateQuestion(
          questionRequest.id,
          questionRequest.categoryId,
          questionRequest.questionType,
          questionRequest.title,
          questionRequest.text,
          questionRequest.explanationText,
          questionRequest.rightAnswerText,
          questionRequest.wrongAnswerText,
          questionRequest.forceCorrectCount,
          questionRequest.isCaseSensitive,
          questionRequest.courseId,
          answers
        )
      case QuestionActionType.Delete => questionFacade.deleteQuestion(questionRequest.id)
      case QuestionActionType.Move => questionFacade.move(
        questionRequest.id,
        questionRequest.index,
        questionRequest.parentId)
      case QuestionActionType.MoveToCourse => questionRequest.questionIds
        .foreach(id => questionFacade.moveToCourse(id, questionRequest.newCourseId))
    }
    result
  })
}
