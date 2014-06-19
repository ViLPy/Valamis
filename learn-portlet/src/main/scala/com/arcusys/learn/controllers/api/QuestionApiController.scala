package com.arcusys.learn.controllers.api

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.{ QuestionActionType, QuestionRequest }
import com.arcusys.learn.facades.QuestionFacadeContract
import com.arcusys.learn.models.{ AnswerResponse }

/**
 * User: Yulia.Glushonkova
 * Date: 05.05.14
 */
class QuestionApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  val questionFacade = inject[QuestionFacadeContract]

  get("/(:id)")(jsonAction {
    requireTeacherPermissions()
    val questionRequest = QuestionRequest(this)
    val result = questionRequest.action match {
      case QuestionActionType.GET_BY_ID    => questionFacade.getByID(questionRequest.id)

      case QuestionActionType.GET_CHILDREN => questionFacade.getChildren(questionRequest.idOption, questionRequest.courseID)
    }
    result
  })

  post("/(:id)")(jsonAction {
    requireTeacherPermissions()
    val questionRequest = QuestionRequest(this)
    val result = questionRequest.action match {
      case QuestionActionType.ADD => questionFacade.create(
        questionRequest.categoryID,
        questionRequest.questionType,
        questionRequest.title,
        questionRequest.text,
        questionRequest.explanationText,
        questionRequest.forceCorrectCount,
        questionRequest.isCaseSensitive,
        questionRequest.courseID
      )
      case QuestionActionType.UPDATE => questionFacade.update(
        questionRequest.id,
        questionRequest.categoryID,
        questionRequest.questionType,
        questionRequest.title,
        questionRequest.text,
        questionRequest.explanationText,
        questionRequest.forceCorrectCount,
        questionRequest.isCaseSensitive,
        questionRequest.courseID,
        parseJson[List[AnswerResponse]](questionRequest.answers).get
      )

      case QuestionActionType.DELETE => questionFacade.delete(questionRequest.id)
      case QuestionActionType.MOVE => questionFacade.move(questionRequest.id,
        questionRequest.dndMode,
        questionRequest.targetID,
        questionRequest.itemType)
    }
    result
  })

}
