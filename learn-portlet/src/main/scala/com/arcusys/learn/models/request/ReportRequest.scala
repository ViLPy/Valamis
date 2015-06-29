package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import org.scalatra.ScalatraBase
import com.arcusys.learn.models.request.ReportActionType._
import com.arcusys.learn.exceptions.BadRequestException

object ReportRequest extends BaseCollectionFilteredRequest with BaseRequest {

  val Scope = "scope"

  val Offset = "offset"
  val Amount = "amount"
  val Period = "period"
  val From = "from"
  val To = "to"
  val GroupBy = "groupBy"
  val GroupPeriod = "groupPeriod"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(val scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) with OAuthModel {

    def actionType: ReportActionType = ReportActionType.withName(Parameter(Action).required.toUpperCase)

    def offset = try {
      Parameter(Offset).withDefault("0").toInt
    } catch {
      case n: NumberFormatException => throw new BadRequestException //("Invalid number format for offset")
    }

    def amount = try {
      Parameter(Amount).withDefault("5").toInt
    } catch {
      case n: NumberFormatException => throw new BadRequestException //("Invalid number format for amount")
    }

    def courseId = Parameter(CourseId).intOption

    def groupBy = Parameter(GroupBy).required

    def groupPeriod = Parameter(GroupPeriod).option

    def period = Parameter(Period).required

    def from = Parameter(From).longRequired

    def to = Parameter(To).longRequired

    def isInstanceScope = Parameter(Scope).option match {
      case Some(value) => value == "instance"
      case None        => false
    }

  }

}

