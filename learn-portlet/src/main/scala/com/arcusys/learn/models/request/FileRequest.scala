package com.arcusys.learn.models.request

import java.io.{ File, InputStream }

import com.arcusys.learn.liferay.util.Base64Helper
import com.arcusys.learn.service.util.Parameter
import com.arcusys.learn.web.FileUploading

object FileRequest extends BaseRequest {

  val COURSE_ID = "courseID"
  val COMPANY_ID = "companyID"
  val QUIZ_ID = "quizID"
  val CATEGORY_ID = "categoryID"

  val STREAM = "stream"
  val FILE = "file"
  val CONTENT_TYPE = "contentType"
  val FILE_ID = "fileId"
  val FOLDER_ID = "folderId"
  val BASE64_CONTENT = "inputBase64"
  val FILE_ENTRY_ID = "fileEntryID"
  val FILE_VERSION = "fileVersion"

  val GROUP_ID = "groupId"
  val VIDEO_UUID = "uuid"

  val DEFAULT_ICON_NAME = "icon.png"

  val EXPORT_EXTENSION = ".zip"

  def apply(scalatra: FileUploading) = new Model(scalatra)

  class Model(scalatra: FileUploading) extends BaseCollectionFilteredRequestModel(scalatra) {
    implicit val request = scalatra.request

    def action = FileActionType.withName(Parameter(ACTION).required)

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

    def id = Parameter(FILE_ID).intOption
    def folder = Parameter(FOLDER_ID).required
    def fileEntryID = Parameter(FILE_ENTRY_ID).longRequired
    def fileVersion = Parameter(FILE_VERSION).required
    def file = Parameter(FILE).required
    def quizID = Parameter(QUIZ_ID).intRequired
    def categoryID = Parameter(CATEGORY_ID).option
    def videoGroupID = Parameter(GROUP_ID).intRequired
    def videoUUID = Parameter(VIDEO_UUID).required

    def courseIDRequired = Parameter(COURSE_ID).intRequired
    def companyIDRequired = Parameter(COMPANY_ID).intRequired

    def base64Content = {
      val inputBase64 = Parameter(BASE64_CONTENT).required.replace("data:image/png;base64,", "")
      val position = inputBase64.indexOf(";")
      val base64 = if (position == -1) inputBase64 else inputBase64.substring(0, position)
      Base64Helper.decode(base64)
    }

    def contentType = {
      val cType = Parameter("contentType").required
      UploadContentType.withName(cType)
      //      getFileItem.
      //        map { f => {println(f.getContentType); UploadContentType.withName(Parameter(CONTENT_TYPE).required) }}.
      //        getOrElse { throw new FileUploadingException(s"Wrong content type. It is undefined for file uploading }") }
    } //UploadContentType.withName(Parameter(CONTENT_TYPE).required)

    def stream = {
      getFileItem match {
        case Some(item) => item.getInputStream
        case None => new InputStream {
          override def read(): Int = 0
        }
      }
    }

    private def getFileItem = scalatra.fileParams.headOption.map(_._2)
  }

}
