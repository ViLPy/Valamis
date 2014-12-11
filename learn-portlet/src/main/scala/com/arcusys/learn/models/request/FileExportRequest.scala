package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import com.arcusys.learn.web.FileUploading

import scala.util.Try

object FileExportRequest extends BaseRequest {

  val COURSE_ID = "courseID"
  val COMPANY_ID = "companyID"
  val CATEGORY_ID = "categoryID"

  val EXPORT_ALL = "EXPORTALL"
  val EXPORT = "EXPORT"
  val DOWNLOAD = "DOWNLOAD"
  val DOWNLOAD_EXTERNAL = "DOWNLOAD_EXTERNAL"
  val CONTENT_TYPE = "contentType"

  val EXPORT_EXTENSION = ".zip"

  val LESSON = "lesson"
  val QUESTION = "question"
  val CERTIFICATE = "certificate"
  val PACKAGE = "package"

  val ID = "id"

  val GROUP_ID = "groupID"

  val PUBLISH_TYPE = "publishType"

  val THEME = "theme"
  val RANDOM_ORDERING = "randomOrdering"
  val QUESTIONS_COUNT = "questionsCount"

  def apply(scalatra: FileUploading) = new Model(scalatra)

  class Model(scalatra: FileUploading) extends BaseCollectionFilteredRequestModel(scalatra) {
    implicit val request = scalatra.request
    def action = Parameter(ACTION).required
    def contentType = Parameter(CONTENT_TYPE).required
    def courseID = Parameter(COURSE_ID).intRequired
    def companyID = Parameter(COMPANY_ID).intRequired
    def ids = Parameter(ID).multiWithEmpty.map(x => Try(x.toInt).get)
    def categoryIds = Parameter(CATEGORY_ID).multiWithEmpty.map(x => Try(x.toInt).get)
    def id = Parameter(ID).intRequired
    def publishType = PackagePublishType.withName(Parameter(PUBLISH_TYPE).required)
    def theme = Parameter(THEME).option
    def randomOrdering = Parameter(RANDOM_ORDERING).booleanOption.getOrElse(false)
    def questionPerUser = Parameter(QUESTIONS_COUNT).intOption
  }

}
