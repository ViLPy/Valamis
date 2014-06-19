package com.arcusys.learn.models.request

import org.scalatra.{ ScalatraServlet, ScalatraBase }
import com.arcusys.learn.service.util.Parameter
import com.arcusys.learn.models.BaseCollectionRequestModel

/**
 * Created by Iliya Tryapitsin on 29.05.2014.
 */
object CourseRequest extends BaseCollectionFilteredRequest {
  val COMPANY_ID = "companyID"

  def apply(controller: ScalatraServlet) = new Model(controller)

  class Model(scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) {
    def companyId = Parameter(COMPANY_ID).intRequired
  }
}
