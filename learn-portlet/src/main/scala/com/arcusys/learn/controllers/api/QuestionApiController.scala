package com.arcusys.learn.controllers.api

import com.arcusys.learn.facades.QuestionFacadeContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.{ AnswerSerializer, AnswerResponse }
import com.arcusys.learn.models.request.{ QuestionActionType, QuestionRequest }
import com.escalatesoft.subcut.inject.BindingModule
import org.json4s.{ DefaultFormats, Formats }

/**
 * User: Yulia.Glushonkova
 * Date: 05.05.14
 */
class QuestionApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  lazy val questionFacade = inject[QuestionFacadeContract]

  def this() = this(Configuration)

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/questions(/)(:id)")(jsonAction {
    requireTeacherPermissions()
    val questionRequest = QuestionRequest(this)
    questionRequest.action match {
      case QuestionActionType.GET_BY_ID => questionFacade.getQuestion(questionRequest.id)

      case QuestionActionType.GET_CHILDREN =>
        questionFacade.getChildren(questionRequest.idOption, questionRequest.courseID)
    }
  })

  post("/questions(/)(:id)")(jsonAction {
    requireTeacherPermissions()
    val questionRequest = QuestionRequest(this)
    val result = questionRequest.action match {
      case QuestionActionType.ADD => questionFacade.createQuestion(
        questionRequest.categoryID,
        questionRequest.questionType,
        questionRequest.title,
        questionRequest.text,
        questionRequest.explanationText,
        questionRequest.forceCorrectCount,
        questionRequest.isCaseSensitive,
        questionRequest.courseID
      )
      case QuestionActionType.UPDATE => {
        implicit val fs: Formats = DefaultFormats + new AnswerSerializer
        val answers = parseJson[List[AnswerResponse]](questionRequest.answers).get

        questionFacade.updateQuestion(
          questionRequest.id,
          questionRequest.categoryID,
          questionRequest.questionType,
          questionRequest.title,
          questionRequest.text,
          questionRequest.explanationText,
          questionRequest.forceCorrectCount,
          questionRequest.isCaseSensitive,
          questionRequest.courseID,
          answers
        )
      }

      case QuestionActionType.DELETE => questionFacade.deleteQuestion(questionRequest.id)
      case QuestionActionType.MOVE => questionFacade.move(
        questionRequest.id,
        questionRequest.index,
        questionRequest.parentID)

      case QuestionActionType.MOVE_TO_COURSE => questionRequest.questionIds
        .foreach(id => questionFacade.moveToCourse(id, questionRequest.newCourseId))
    }
    result
  })

}
