package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import org.scalatra.ScalatraBase

object SettingsRequest extends BaseRequest {
  val KeyId = "keyID"
  val Value = "value"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) {
    implicit val _scalatra = scalatra

    def courseId = Parameter(CourseId).intRequired

    def keyId = Parameter(KeyId).required

    def value = Parameter(Value).option
  }
}
