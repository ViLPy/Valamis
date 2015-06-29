package com.arcusys.learn.models.request

import org.scalatra.ScalatraBase
import com.arcusys.learn.service.util.Parameter
import scala.util.Try

object LiferayRequest extends BaseCollectionFilteredRequest with BaseRequest {
  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseSortableCollectionFilteredRequestModel(scalatra, s => s) {
    implicit val httpRequest = scalatra.request
    def action = Parameter(Action).required

    def courseId = Parameter(CourseId).intRequired
  }
}
