package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 17.03.14.
 */
object UploadContentType extends Enumeration {
  type UploadContentType = Value

  val ICON = Value("icon")
  val BASE64_ICON = Value("base64-icon")
  val PACKAGE = Value("scorm-package")
}