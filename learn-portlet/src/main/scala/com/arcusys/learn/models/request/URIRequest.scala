package com.arcusys.learn.models.request

import org.scalatra.{ ScalatraServlet, ScalatraBase }
import com.arcusys.learn.service.util.Parameter

object URIRequest extends BaseCollectionFilteredRequest {
  val Type = "type"
  val Id = "id"
  val Content = "content"
  val PrefixURI = "prefix"
  val Action = "action"
  val Start = "start"
  val End = "end"

  def apply(controller: ScalatraServlet) = new Model(controller)

  class Model(scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) {
    def objectType = Parameter(Type).required
    def id = Parameter(Id).required
    def content = Parameter(Content).option
    def prefix = Parameter(PrefixURI).required
    def action = Parameter(Action).option
    def start = Parameter(Start).intOption
    def end = Parameter(End).intOption
  }
}
