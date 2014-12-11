package com.arcusys.learn.models.request

import org.scalatra.ScalatraBase
import com.arcusys.learn.service.util.Parameter
import scala.util.Try

object LiferayRequest extends BaseCollectionFilteredRequest with BaseRequest {

  val GROUP_ID = "groupID"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseSortableCollectionFilteredRequestModel(scalatra, s => s) {
    implicit val httpRequest = scalatra.request
    def action = Parameter(ACTION).required
    def groupID = Parameter(GROUP_ID).intOption
  }
}
