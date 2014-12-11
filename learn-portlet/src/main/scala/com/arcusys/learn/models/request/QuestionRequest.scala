package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.{ AntiSamyHelper, Parameter }
import org.scalatra.ScalatraBase

import scala.util.Try

/**
 * User: Yulia.Glushonkova
 * Date: 05.05.14
 */
object QuestionRequest extends BaseRequest {

  val COURSE_ID = "courseID"
  val NEW_COURSE_ID = "newCourseID"
  val CATEGORY_ID = "categoryID"
  val CATEGORY_IDs = "categoryIDs"

  val ID = "id"
  val QUESTION_TYPE = "questionType"
  val TITLE = "title"
  val TEXT = "text"
  val EXPLANATION_TEXT = "explanationText"
  val FORCE = "forceCorrectCount"
  val CASE = "isCaseSensitive"
  val ANSWERS = "answers"
  val INDEX = "index"
  val PARENT_ID = "parentID"
  val QUESTION_IDs = "questionIDs"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) {
    implicit val httpRequest = scalatra.request

    def action = QuestionActionType.withName(Parameter(ACTION).required.toUpperCase)

    def id = Parameter(ID).intRequired

    def idOption = Parameter(ID).intOption

    def courseID = Parameter(COURSE_ID).intOption(-1)

    def newCourseId = Parameter(NEW_COURSE_ID).intOption

    def questionType = Parameter(QUESTION_TYPE).intRequired

    def categoryID = Parameter(CATEGORY_ID).intOption(-1)

    def title = AntiSamyHelper.sanitize(Parameter(TITLE).required)

    def text = AntiSamyHelper.sanitize(Parameter(TEXT).withDefault(""))

    def explanationText = AntiSamyHelper.sanitize(Parameter(EXPLANATION_TEXT).withDefault(""))

    def forceCorrectCount = Parameter(FORCE).booleanRequired

    def isCaseSensitive = Parameter(CASE).booleanRequired

    def answers = Parameter(ANSWERS).withDefault("[]")

    def parentID = Parameter(PARENT_ID).intOption(-1)

    def index = Parameter(INDEX).intRequired

    def categoryIds = Parameter(CATEGORY_IDs).multiWithEmpty.map(x => Try(x.toInt).get)

    def questionIds = Parameter(QUESTION_IDs).multiWithEmpty.map(x => Try(x.toInt).get)
  }

}
