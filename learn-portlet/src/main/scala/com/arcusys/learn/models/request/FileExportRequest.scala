package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import com.arcusys.learn.web.FileUploading

import scala.util.Try

object FileExportRequest extends BaseRequest {

  val CompanyId = "companyID"
  val CategoryId = "categoryID"

  val ExportAll = "EXPORTALL"
  val Export = "EXPORT"
  val Download = "DOWNLOAD"
  val DownloadExternal = "DOWNLOAD_EXTERNAL"
  val ContentType = "contentType"

  val ExportExtension = ".zip"

  val SlideSet = "SLIDE_SET"
  val Lesson = "lesson"
  val Question = "question"
  val Certificate = "certificate"
  val Package = "package"

  val Id = "id"

  val PublishType = "publishType"

  val Theme = "theme"
  val RandomOrdering = "randomOrdering"
  val QuestionsCount = "questionsCount"
  val ScoreLimit = "scoreLimit"

  def apply(scalatra: FileUploading) = new Model(scalatra)

  class Model(scalatra: FileUploading) extends BaseCollectionFilteredRequestModel(scalatra) {
    implicit val request = scalatra.request
    def action = Parameter(Action).required
    def contentType = Parameter(ContentType).required
    def courseId = Parameter(CourseId).intRequired
    def companyID = Parameter(CompanyId).intRequired
    def ids = Parameter(Id).multiWithEmpty.map(x => Try(x.toInt).get)
    def idsLong = Parameter(Id).multiWithEmpty.map(x => Try(x.toLong).get)
    def categoryIds = Parameter(CategoryId).multiWithEmpty.map(x => Try(x.toInt).get)
    def id = Parameter(Id).intRequired
    def publishType = PackagePublishType.withName(Parameter(PublishType).required)
    def theme = Parameter(Theme).option
    def randomOrdering = Parameter(RandomOrdering).booleanOption.getOrElse(false)
    def questionPerUser = Parameter(QuestionsCount).intOption
    def scoreLimit = Parameter(ScoreLimit).doubleOption
  }

}
