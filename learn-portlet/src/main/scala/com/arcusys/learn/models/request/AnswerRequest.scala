package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.{ AntiSamyHelper, Parameter }
import org.scalatra.ScalatraBase

/**
 * Created by Iliya Tryapitsin on 08.09.2014.
 */
object AnswerRequest {
  val ID = "id"
  val QUESTION_ID = "questionID"
  val TEXT = "text"
  val IS_CORRECT = "isCorrect"
  val RANGE_FROM = "rangeFrom"
  val RANGE_TO = "rangeTo"
  val MATCHING_TEXT = "matchingText"
  val SCORE = "score"
  val TYPE = "type"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseRequest {
    implicit val httpRequest = scalatra.request
    implicit val _scalatra = scalatra

    def action = QuestionActionType.withName(Parameter(ACTION).required.toUpperCase)

    def id = Parameter(ID).intRequired

    def questionID = Parameter(QUESTION_ID).longRequired

    def text = AntiSamyHelper.sanitize(Parameter(TEXT).withDefault(""))

    def isCorrect = Parameter(IS_CORRECT).booleanOption.getOrElse(false)

    def rangeFrom = Parameter(RANGE_FROM).bigDecimalOption.getOrElse(BigDecimal(0))

    def rangeTo = Parameter(RANGE_TO).bigDecimalOption.getOrElse(BigDecimal(0))

    def matchingText = AntiSamyHelper.sanitize(Parameter(MATCHING_TEXT).withDefault(""))

    def score = Parameter(SCORE).doubleOption

    def questionType = Parameter(TYPE).intRequired
  }

}
