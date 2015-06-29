package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import org.scalatra.ScalatraBase
import com.arcusys.learn.models.request.PrintActionType._

object PrintRequest extends BaseCollectionFilteredRequest with BaseRequest {
  val PrintTranscript = "PRINT_TRANSCRIPT"
  val CompanyId = "companyID"
  val UserId = "userID"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(val scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) with OAuthModel{

    def actionType: PrintActionType = PrintActionType.withName(Parameter(Action).required.toUpperCase)

    def companyId = Parameter(CompanyId).intRequired

    def userId = Parameter(UserId).intRequired

    def courseId = Parameter(CourseId).longRequired
  }

}

