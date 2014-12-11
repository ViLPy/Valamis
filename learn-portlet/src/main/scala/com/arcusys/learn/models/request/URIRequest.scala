package com.arcusys.learn.models.request

import org.scalatra.{ ScalatraServlet, ScalatraBase }
import com.arcusys.learn.service.util.Parameter
import com.arcusys.learn.models.BaseCollectionRequestModel

object URIRequest extends BaseCollectionFilteredRequest {
  val TYPE = "type"
  val ID = "id"
  val CONTENT = "content"
  val PREFIX_URI = "prefix"

  def apply(controller: ScalatraServlet) = new Model(controller)

  class Model(scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) {
    def objectType = Parameter(TYPE).required
    def id = Parameter(ID).required
    def content = Parameter(CONTENT).option
    def prefix = Parameter(PREFIX_URI).required
  }
}
