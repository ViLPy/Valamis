package com.arcusys.learn.models.request

import org.scalatra.ScalatraBase
import com.arcusys.learn.service.util.{ AntiSamyHelper, Parameter }
import com.arcusys.learn.models.AnswerResponse

/**
 * User: Yulia.Glushonkova
 * Date: 05.05.14
 */
object QuestionRequest extends BaseRequest {
  val ID = "id"
  val COURSE_ID = "courseId"
  val QUESTION_TYPE = "questionType"
  val CATEGORY_ID = "categoryID"
  val TITLE = "title"
  val TEXT = "text"
  val EXPLANATION_TEXT = "explanationText"
  val FORCE = "forceCorrectCount"
  val CASE = "isCaseSensitive"
  val ANSWERS = "answers"
  val DNDMODE = "dndMode"
  val TARGET_ID = "targetID"
  val ITEM_TYPE = "itemType"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) {
    implicit val httpRequest = scalatra.request

    def action = QuestionActionType.withName(Parameter(ACTION).required.toUpperCase)

    def id = Parameter(ID).intRequired
    def idOption = Parameter(ID).intOption

    def courseID = Parameter(COURSE_ID).intOption(-1)

    def questionType = Parameter(QUESTION_TYPE).intRequired

    def categoryID = Parameter(CATEGORY_ID).intOption(-1)

    def title = AntiSamyHelper.sanitize(Parameter(TITLE).required)

    def text = AntiSamyHelper.sanitize(Parameter(TEXT).withDefault(""))

    def explanationText = AntiSamyHelper.sanitize(Parameter(EXPLANATION_TEXT).withDefault(""))

    def forceCorrectCount = Parameter(FORCE).booleanRequired

    def isCaseSensitive = Parameter(CASE).booleanRequired

    def answers = Parameter(ANSWERS).withDefault("[]")

    def dndMode = Parameter(DNDMODE).required

    def targetID = Parameter(TARGET_ID).intOption(-1)

    def itemType = Parameter(ITEM_TYPE).required
  }

}
