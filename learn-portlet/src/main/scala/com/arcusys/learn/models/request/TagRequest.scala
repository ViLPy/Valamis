package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import org.scalatra.ScalatraBase

/**
 * Created by Yuriy Gatilin on 28.01.15.
 */
object TagRequest extends BaseRequest {

  val CompanyId = "companyId"
  val TagId = "tagId"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) {
    implicit val httpRequest = scalatra.request

    def companyId = Parameter(CompanyId).intRequired
    def tagId = Parameter(TagId).intRequired
  }
}
