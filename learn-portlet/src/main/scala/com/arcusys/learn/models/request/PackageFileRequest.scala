package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.{ AntiSamyHelper, Parameter }
import com.arcusys.learn.web.FileUploading

/**
 * Created by Iliya Tryapitsin on 17.03.14.
 */
object PackageFileRequest {
  val TITLE = "title"
  val SUMMARY = "summary"
  val IMAGE_ID = "imageId"
  val SCORM_USER_ID = "scormUserID"
  val LIFERAY_GROUP_ID = "liferayGroupID"
  val COURSE_ID = "courseID"
  val SCOPE = "scope"

  val DEFAULT_PACKAGE_TITLE = "New package"
  val DEFAULT_PACKAGE_DESCRIPTION = ""
  val DEFAULT_INT = "0"
  val DEFAULT_LIFERAY_GROUP_ID = "-1"
  val DEFAULT_COURSE_ID = "-1"
  val PACKAGE_FILE_EXTENSION = "zip"

  def apply(scalatra: FileUploading) = new Model(scalatra)

  class Model(scalatra: FileUploading) extends FileRequest.Model(scalatra) {
    def title = Parameter(TITLE).option

    def summary: Option[String] = {
      Parameter(SUMMARY).option match {
        case Some(value) => Option(AntiSamyHelper.sanitize(value))
        case None        => None
      }
    }

    def userID = Parameter(SCORM_USER_ID)
      .withDefault(DEFAULT_INT)
      .toLong

    def groupID = Parameter(LIFERAY_GROUP_ID)
      .withDefault(DEFAULT_LIFERAY_GROUP_ID)
      .toLong

    def courseID = Parameter(COURSE_ID).intOption(-1)

    def imageID = Parameter(IMAGE_ID).intRequired //.intOption(DEFAULT_INT)

    def scope = Parameter(SCOPE)
  }
}
