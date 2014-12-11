package com.arcusys.learn.models.request

import org.scalatra.ScalatraBase
import com.arcusys.learn.service.util.Parameter
import scala.util.Try

object QuizRequest extends BaseCollectionFilteredRequest with BaseRequest {

  val COURSE_ID = "courseID"
  val CATEGORY_ID = "categoryId"

  val ID = "id"
  val LESSON_ID = "lessonId"
  val LESSON_IDS = "lessonIds"
  val NAME_PATTERN = "namePattern"
  val TITLE = "title"
  val DESCRIPTION = "description"
  val TEXT = "text"
  val URL = "url"
  val LOGO = "logo"
  val BANK_QUESTION_ID = "bankQuestionId"
  val BANK_QUESTION_IDS = "bankQuestionIds"
  val INDEX = "index"
  val LIFERAY_GROUP_ID = "liferayGroupID"
  val PUBLISH_TYPE = "publishType"
  val AUTO_SHOW_ANSWER = "autoShowAnswer"
  val THEME = "theme"
  val RANDOM_ORDERING = "randomOrdering"
  val QUESTIONS_COUNT = "questionsCount"
  val MAX_DURATION = "maxDuration"
  val VIDEO_FROM_DOCLIBRARY = "fromDocLibrary"
  val UUID = "uuid"
  val GROUP_ID = "groupID"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseSortableCollectionFilteredRequestModel(scalatra, s => s) {
    implicit val httpRequest = scalatra.request

    def id = Parameter(ID).intRequired
    def idString = Parameter(ID).required
    def lessonId = Parameter(LESSON_ID).intRequired
    def lessonIds = Parameter(LESSON_IDS).multiRequired.map(x => Try(x.toInt).get)
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
    def groupID = Parameter(GROUP_ID).intOption.map(_.toLong)
    def publishType = PackagePublishType.withName(Parameter(PUBLISH_TYPE).required)
    def autoShowAnswer = Parameter(AUTO_SHOW_ANSWER).booleanOption
    def theme = Parameter(THEME).option
    def randomOrdering = Parameter(RANDOM_ORDERING).booleanOption.getOrElse(false)
    def questionPerUser = Parameter(QUESTIONS_COUNT).intOption
    def maxDuration = Parameter(MAX_DURATION).intOption
    def videoFromDL = Parameter(VIDEO_FROM_DOCLIBRARY).booleanRequired
    def uuid = Parameter(UUID).option
  }
}
