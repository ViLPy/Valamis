package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import org.scalatra.ScalatraBase

object LRSToActivitySettingsRequest {
  val CourseID = "courseID"
  val Title = "title"
  val MappedActivity = "mappedActivity"
  val MappedVerb = "mappedVerb"
  val Action = "action"
  val ID = "id"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) {
    implicit val _scalatra = scalatra

    def courseID = Parameter(CourseID).intRequired

    def title = Parameter(Title).required

    def mappedActivity = Parameter(MappedActivity).option

    def mappedVerb = Parameter(MappedVerb).option

    def action = {
      Parameter(Action).option match {
        case Some(value) => LRSToActivitySettingActionType.withName(value.toUpperCase)
        case None        => None
      }
    }

    def id = Parameter(ID).intRequired
  }
}
