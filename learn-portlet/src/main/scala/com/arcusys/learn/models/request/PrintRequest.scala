package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import org.scalatra.ScalatraBase
import com.arcusys.learn.models.request.PrintActionType._

object PrintRequest extends BaseCollectionFilteredRequest with BaseRequest {
  val PRINT_TRANSCRIPT = "PRINT_TRANSCRIPT"
  val COMPANY_ID = "companyID"
  val USER_ID = "userID"
  val COURSE_ID = "courseID"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) {

    def actionType: PrintActionType = PrintActionType.withName(Parameter(ACTION).required.toUpperCase)

    def companyId = Parameter(COMPANY_ID).intRequired

    def userId = Parameter(USER_ID).intRequired

    def courseId = Parameter(COURSE_ID).longRequired
  }

}

