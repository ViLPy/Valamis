package com.arcusys.learn.models.request

import java.io.{ File, InputStream }

import com.arcusys.learn.liferay.util.Base64Helper
import com.arcusys.learn.service.util.Parameter
import com.arcusys.learn.web.FileUploading

object FileRequest extends BaseRequest {
  val UserId = "userID"
  val CompanyId = "companyID"
  val QuizId = "quizID"
  val CategoryId = "categoryID"

  val Stream = "stream"
  val File = "file"
  val ContentType = "contentType"
  val FileId = "fileId"
  val FolderId = "folderId"
  val Base64Content = "inputBase64"
  val FileEntryId = "fileEntryID"
  val FileVersion = "fileVersion"

  val VideoUUId = "uuid"

  val DefaultIconName = "icon.png"

  val ExportExtension = ".zip"

  def apply(scalatra: FileUploading) = new Model(scalatra)

  class Model(scalatra: FileUploading) extends BaseCollectionFilteredRequestModel(scalatra) {
    implicit val request = scalatra.request

    def action = FileActionType.withName(Parameter(Action).required)

    def fileName = {
      // IE returns absolute path, e.g. C:/users/anonymous/Docs/pict.jpg Need to trim it
      getFileItem.fold("")(f => new File(f.getName).getName.replaceAll(" ", "_"))
    }

    def fileContent = {
      val contentSource = scala.io.Source.fromInputStream(stream)(scala.io.Codec.ISO8859)
      val content = contentSource.map(_.toByte).toArray
      contentSource.close()

      content
    }

    def stream = {
      getFileItem match {
        case Some(item) => item.getInputStream
        case None => new InputStream {
          override def read(): Int = 0
        }
      }
    }

    private def getFileItem = scalatra.fileParams.headOption.map(_._2)

    def id = Parameter(FileId).intOption

    def folder = Parameter(FolderId).required

    def fileEntryId = Parameter(FileEntryId).longRequired

    def fileVersion = Parameter(FileVersion).required

    def file = Parameter(File).required

    def quizId = Parameter(QuizId).intRequired

    def categoryId = Parameter(CategoryId).option

    def videoCourseId = Parameter(CourseId).intRequired

    def videoUUId = Parameter(VideoUUId).required

    def courseId = Parameter(CourseId).intRequired

    def userId = Parameter(UserId).intRequired

    def companyIdRequired = Parameter(CompanyId).intRequired

    def base64Content = {
      val inputBase64 = Parameter(Base64Content).required.replace("data:image/png;base64,", "")
      val position = inputBase64.indexOf(";")
      val base64 = if (position == -1) inputBase64 else inputBase64.substring(0, position)
      Base64Helper.decode(base64)
    }

    def contentType = {
      val cType = Parameter("contentType").required
      UploadContentType.withName(cType)
      //      getFileItem.
      //        map { f => {println(f.getContentType); UploadContentType.withName(Parameter(ContentType).required) }}.
      //        getOrElse { throw new FileUploadingException(s"Wrong content type. It is undefined for file uploading }") }
    } //UploadContentType.withName(Parameter(ContentType).required)
  }

}
