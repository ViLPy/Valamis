package com.arcusys.learn.models.request

import com.arcusys.learn.scorm.tracking.model.PermissionType
import com.arcusys.learn.scorm.tracking.model.PermissionType.PermissionType
import com.arcusys.learn.service.util.Parameter
import org.scalatra.ScalatraBase

object SettingsRequest {
  val SiteID = "siteID"
  val KeyID = "keyID"
  val Value = "value"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) {
    implicit val _scalatra = scalatra

    def siteID = Parameter(SiteID).intRequired

    def keyID = Parameter(KeyID).required

    def value = Parameter(Value).option
  }
}
