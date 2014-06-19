package com.arcusys.learn.models.request

import org.scalatra.ScalatraBase
import com.arcusys.learn.service.util.Parameter
import scala.util.Try

object QuizRequest extends BaseCollectionFilteredRequest with BaseRequest {
  val ID = "id"
  val LESSON_ID = "lessonId"
  val NAME_PATTERN = "namePattern"
  val TITLE = "title"
  val DESCRIPTION = "description"
  val TEXT = "text"
  val URL = "url"
  val LOGO = "logo"
  val COURSE_ID = "courseID"
  val CATEGORY_ID = "categoryId"
  val BANK_QUESTION_ID = "bankQuestionId"
  val BANK_QUESTION_IDS = "bankQuestionIds"
  val INDEX = "index"
  val LIFERAY_GROUP_ID = "liferayGroupID"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseSortableCollectionFilteredRequestModel(scalatra, s => s) {
    implicit val httpRequest = scalatra.request

    def id = Parameter(ID).intRequired
    def idString = Parameter(ID).required
    def lessonId = Parameter(LESSON_ID).intRequired
    def action = Parameter(ACTION).required
    def actionType = QuizActionType.withName(action.toUpperCase)
    def namePattern = Parameter(NAME_PATTERN).required
    def title = Parameter(TITLE).required
    def description = Parameter(DESCRIPTION).required
    def text = Parameter(TEXT).required
    def url = Parameter(URL).required
    def logo = Parameter(LOGO).required
    def courseID = Parameter(COURSE_ID).intRequired
    def categoryIdOption = Parameter(CATEGORY_ID).option
    def bankQuestionId = Parameter(BANK_QUESTION_ID).intRequired
    def bankQuestionIds = Parameter(BANK_QUESTION_IDS).multiRequired.map(x => Try(x.toInt).get)
    def index = Parameter(INDEX).intRequired
    def groupID = Parameter(LIFERAY_GROUP_ID).intOption.map(_.toLong)
  }
}
