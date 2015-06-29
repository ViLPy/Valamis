package com.arcusys.learn.models.request

import com.arcusys.learn.liferay.permission.PermissionCredentials
import com.arcusys.learn.service.util.{ AntiSamyHelper, Parameter }
import org.scalatra.ScalatraBase

import scala.util.Try

object QuestionRequest extends BaseRequest {

  val NewCourseId = "newCourseID"
  val CategoryId = "categoryID"
  val CategoryIds = "categoryIDs"

  val Id = "id"
  val QuestionType = "questionType"
  val Title = "title"
  val Text = "text"
  val ExplanationText = "explanationText"
  val RightAnswerText = "rightAnswerText"
  val WrongAnswerText = "wrongAnswerText"
  val Force = "forceCorrectCount"
  val Case = "isCaseSensitive"
  val Answers = "answers"
  val Index = "index"
  val ParentId = "parentID"
  val QuestionIds = "questionIDs"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) {
    implicit val httpRequest = scalatra.request

    def action = QuestionActionType.withName(Parameter(Action).required.toUpperCase)

    def id = Parameter(Id).intRequired

    def idOption = Parameter(Id).intOption

    def courseId = Parameter(CourseId).intOption

    def newCourseId = Parameter(NewCourseId).intOption

    def questionType = Parameter(QuestionType).intRequired

    def categoryId = Parameter(CategoryId).intOption

    def title = AntiSamyHelper.sanitize(Parameter(Title).required)

    def text = AntiSamyHelper.sanitize(Parameter(Text).withDefault(""))

    def explanationText = AntiSamyHelper.sanitize(Parameter(ExplanationText).withDefault(""))
    
    def rightAnswerText = AntiSamyHelper.sanitize(Parameter(RightAnswerText).withDefault(""))

    def wrongAnswerText = AntiSamyHelper.sanitize(Parameter(WrongAnswerText).withDefault(""))

    def forceCorrectCount = Parameter(Force).booleanRequired

    def isCaseSensitive = Parameter(Case).booleanRequired

    def answers = Parameter(Answers).withDefault("[]")

    def parentId = Parameter(ParentId).intOption

    def index = Parameter(Index).intRequired

    def categoryIds = Parameter(CategoryIds).multiWithEmpty.map(x => Try(x.toInt).get)

    def questionIds = Parameter(QuestionIds).multiWithEmpty.map(x => Try(x.toInt).get)
  }

}
