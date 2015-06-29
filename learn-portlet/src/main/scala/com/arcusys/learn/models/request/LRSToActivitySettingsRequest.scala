package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import org.scalatra.ScalatraBase

object LRSToActivitySettingsRequest extends BaseRequest {
  val Title = "title"
  val MappedActivity = "mappedActivity"
  val MappedVerb = "mappedVerb"
  val Id = "id"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) {
    implicit val _scalatra = scalatra

    def courseId = Parameter(CourseId).intRequired

    def title = Parameter(Title).required

    def mappedActivity = Parameter(MappedActivity).option

    def mappedVerb = Parameter(MappedVerb).option

    def action = {
      Parameter(Action).option match {
        case Some(value) => LRSToActivitySettingActionType.withName(value.toUpperCase)
        case None        => None
      }
    }

    def id = Parameter(Id).intRequired
  }
}
