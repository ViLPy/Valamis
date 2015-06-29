package com.arcusys.learn.models.request

import com.arcusys.learn.liferay.permission.PermissionCredentials
import com.arcusys.learn.models.request.QuestionRequest._
import org.scalatra.ScalatraBase
import com.arcusys.learn.service.util.Parameter
import scala.util.Try

object QuizRequest extends BaseCollectionFilteredRequest with BaseRequest {

  val CategoryId = "categoryId"

  val Id = "id"
  val LessonId = "lessonId"
  val LessonIds = "lessonIds"
  val NamePattern = "namePattern"
  val Title = "title"
  val Description = "description"
  val Text = "text"
  val Url = "url"
  val Logo = "logo"
  val BankQuestionId = "bankQuestionId"
  val BankQuestionIds = "bankQuestionIds"
  val Index = "index"
  val LiferayGroupId = "liferayGroupId"
  val PublishType = "publishType"
  val AutoShowAnswer = "autoShowAnswer"
  val Theme = "theme"
  val RandomOrdering = "randomOrdering"
  val QuestionsCount = "questionsCount"
  val ScoreLimit = "scoreLimit"
  val MaxDuration = "maxDuration"
  val VideoFromDocLibrary = "fromDocLibrary"
  val UUId = "uuid"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseSortableCollectionFilteredRequestModel(scalatra, s => s) {
    implicit val httpRequest = scalatra.request

    def id = Parameter(Id).intRequired
    def idString = Parameter(Id).required
    def lessonId = Parameter(LessonId).intRequired
    def lessonIds = Parameter(LessonIds).multiRequired.map(x => Try(x.toInt).get)

    def actionType = QuizActionType.withName(action.toUpperCase)

    def action = Parameter(Action).required

    def namePattern = Parameter(NamePattern).required
    def title = Parameter(Title).required
    def description = Parameter(Description).required
    def text = Parameter(Text).required
    def url = Parameter(Url).required
    def logo = Parameter(Logo).required
    def logoOption = Parameter(Logo).option

    def courseId = Parameter(CourseId).longRequired

    def courseIdOption = Parameter(CourseId).longOption
    def categoryIdOption = Parameter(CategoryId).option
    def bankQuestionId = Parameter(BankQuestionId).intRequired
    def bankQuestionIds = Parameter(BankQuestionIds).multiRequired.map(x => Try(x.toInt).get)
    def index = Parameter(Index).intRequired
    def publishType = PackagePublishType.withName(Parameter(PublishType).required)
    def autoShowAnswer = Parameter(AutoShowAnswer).booleanOption
    def theme = Parameter(Theme).option
    def randomOrdering = Parameter(RandomOrdering).booleanOption.getOrElse(false)
    def questionPerUser = Parameter(QuestionsCount).intOption
    def scoreLimit = Parameter(ScoreLimit).doubleOption
    def maxDuration = Parameter(MaxDuration).intOption
    def videoFromDL = Parameter(VideoFromDocLibrary).booleanRequired
    def uuid = Parameter(UUId).option
  }
}
