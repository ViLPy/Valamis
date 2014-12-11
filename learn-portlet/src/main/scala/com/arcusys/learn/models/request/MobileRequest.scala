package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import org.scalatra.ScalatraBase

/**
 * Created by igorborisov on 24.10.14.
 */
object MobileRequest extends BaseRequest {

  val USER_ID = "userId"
  val COURSE = "course"
  val PACKAGE_ID = "packageId"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) {
    implicit val httpRequest = scalatra.request

    def userId = Parameter(USER_ID).intRequired
    def course = Parameter(COURSE).required
    def packageId = Parameter(PACKAGE_ID).intRequired

  }
}
