package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.{ AntiSamyHelper, Parameter }
import com.arcusys.learn.web.FileUploading

/**
 * Created by Iliya Tryapitsin on 17.03.14.
 */
object PackageFileRequest extends BaseRequest {

  val LiferayGroupId = "liferayGroupID"
  val Scope = "scope"

  val Title = "title"
  val Summary = "summary"
  val ImageId = "imageId"

  val DefaultPackageTitle = "New package"
  val DefaultPackageDescription = ""
  val DefaultInt = "0"
  val DefaultLiferayGroupId = "-1"
  val DefaultCourseId = "-1"
  val PackageFileExtension = "zip"

  def apply(scalatra: FileUploading) = new Model(scalatra)

  class Model(scalatra: FileUploading) extends FileRequest.Model(scalatra) {
    def title = Parameter(Title).option

    def summary: Option[String] = {
      Parameter(Summary).option match {
        case Some(value) => Option(AntiSamyHelper.sanitize(value))
        case None        => None
      }
    }

    def groupID = Parameter(LiferayGroupId)
      .withDefault(DefaultLiferayGroupId)
      .toLong

    def imageID = Parameter(ImageId).intRequired //.intOption(DefaultInt)

    def scope = Parameter(Scope)
  }
}
