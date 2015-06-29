package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.{ AntiSamyHelper, Parameter }
import org.scalatra.ScalatraBase

/**
 * Created by Iliya Tryapitsin on 08.09.2014.
 */
object AnswerRequest {
  val Id = "id"
  val QuestionId = "questionID"
  val Text = "text"
  val IsCorrect = "isCorrect"
  val RangeFrom = "rangeFrom"
  val RangeTo = "rangeTo"
  val MatchingText = "matchingText"
  val Scope = "score"
  val Type = "type"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseRequest {
    implicit val httpRequest = scalatra.request
    implicit val _scalatra = scalatra

    def action = QuestionActionType.withName(Parameter(Action).required.toUpperCase)

    def id = Parameter(Id).intRequired

    def questionID = Parameter(QuestionId).longRequired

    def text = AntiSamyHelper.sanitize(Parameter(Text).withDefault(""))

    def isCorrect = Parameter(IsCorrect).booleanOption.getOrElse(false)

    def rangeFrom = Parameter(RangeFrom).bigDecimalOption.getOrElse(BigDecimal(0))

    def rangeTo = Parameter(RangeTo).bigDecimalOption.getOrElse(BigDecimal(0))

    def matchingText = AntiSamyHelper.sanitize(Parameter(MatchingText).withDefault(""))

    def score = Parameter(Scope).doubleOption

    def questionType = Parameter(Type).intRequired
  }

}
