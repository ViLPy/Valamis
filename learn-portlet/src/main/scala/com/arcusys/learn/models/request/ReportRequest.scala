package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import org.scalatra.ScalatraBase
import com.arcusys.learn.models.request.ReportActionType._
import com.arcusys.learn.exceptions.BadRequestException

object ReportRequest extends BaseCollectionFilteredRequest with BaseRequest {

  val COURSE_ID = "courseId"
  val SCOPE = "scope"

  val OFFSET = "offset"
  val AMOUNT = "amount"
  val PERIOD = "period"
  val FROM = "from"
  val TO = "to"
  val GROUP_BY = "groupBy"
  val GROUP_PERIOD = "groupPeriod"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) {

    def actionType: ReportActionType = ReportActionType.withName(Parameter(ACTION).required.toUpperCase)

    def offset = try {
      Parameter(OFFSET).withDefault("0").toInt
    } catch {
      case n: NumberFormatException => throw new BadRequestException //("Invalid number format for offset")
    }

    def amount = try {
      Parameter(AMOUNT).withDefault("5").toInt
    } catch {
      case n: NumberFormatException => throw new BadRequestException //("Invalid number format for amount")
    }

    def courseID = Parameter(COURSE_ID).intOption

    def groupBy = Parameter(GROUP_BY).required

    def groupPeriod = Parameter(GROUP_PERIOD).option

    def period = Parameter(PERIOD).required

    def from = Parameter(FROM).longRequired

    def to = Parameter(TO).longRequired

    def isInstanceScope = Parameter(SCOPE).option match {
      case Some(value) => value == "instance"
      case None        => false
    }

  }

}

