package com.arcusys.valamis.slide.service.export

import java.io.{ ByteArrayInputStream, File, InputStream }
import java.util.regex.Pattern
import com.arcusys.valamis.file.service.FileService
import com.arcusys.valamis.questionbank.model._
import com.arcusys.valamis.questionbank.service.QuestionService
import com.arcusys.valamis.slide.model._
import com.arcusys.valamis.util.FileSystemUtil
import com.arcusys.valamis.utils.JsonSupport._
import com.arcusys.valamis.slide.model.SlideEntityType

case class QuestionResponse(tpe: Int, json: String)
case class ExportFormat(version: Option[String], questions: List[QuestionResponse], slideSet: SlideSetModel)

object QuestionExternalFormat {
  def exportQuestion(question: Question[Answer]): QuestionResponse = {
    QuestionResponse(question.questionTypeCode, question.toJson.get)
  }
  def importQuestion(questionResponse: QuestionResponse): Question[Answer] = {
    questionResponse.tpe match {
      case 0 => parseJson[ChoiceQuestion](questionResponse.json).get
      case 1 => parseJson[TextQuestion](questionResponse.json).get
      case 2 => parseJson[NumericQuestion](questionResponse.json).get
      case 3 => parseJson[PositioningQuestion](questionResponse.json).get
      case 4 => parseJson[MatchingQuestion](questionResponse.json).get
      case 5 => parseJson[EssayQuestion](questionResponse.json).get
      case 6 => parseJson[EmbeddedAnswerQuestion](questionResponse.json).get
      case 7 => parseJson[CategorizationQuestion](questionResponse.json).get
      case 8 => parseJson[PlainText](questionResponse.json).get
      case 9 => parseJson[PurePlainText](questionResponse.json).get
    }
  }
}

trait SlideSetExportUtils {
  protected def questionService: QuestionService
  protected def fileService: FileService

  protected val slidesVersion = Some("2.0")

  protected def getRequiredQuestions(slides: List[SlideModel]) = slides.flatMap { slide =>
    slide.slideElements.filter { _.slideEntityType == com.arcusys.valamis.slide.model.SlideEntityType.Question }
      .filter { _.content != "" }
      .map { question => questionService.getQuestion(question.content.toInt) }
  }

  protected def getFromPath(content: String) = {
    if (content == "") None
    else if (content.contains("/delegate/files")) {
      val folderRegExprStr = "folderId=([^&]*)"
      val fileRegExprStr = "file=([^&\"\\)]*)"

      getFileTuple(content, (folderRegExprStr, fileRegExprStr))
    }
    else if (content.contains("/learn-portlet/preview-resources/pdf/")) {
      val folderRegExprStr = "files/([^/]*)"
      val fileRegExprStr = "files/[^/]*/([^/]*)"

      getFileTuple(content, (folderRegExprStr, fileRegExprStr))
    } else if (content.contains("/documents/")) {
        if(content.contains("groupId")) {
          val groupIdRegExprStr = "groupId=([^&]*)"
          val fileRegExprStr = "/(.*)/.*$"
          val uuidRegExprStr = ".*/([^/?]*)"

          getFileTuple(content, (groupIdRegExprStr, fileRegExprStr, uuidRegExprStr))
        }
        else {
          val fileEntryRegExpr = "entryId=([^&]*)"
          val fileVersionRegExpr = "version=([^&]*)"
          val fileRegExpr = "/documents/[^/]*/[^/]*/([^/]*)"
          val extRegExpr = "ext=([^&]*)\""

          getFileTuple(content, (fileEntryRegExpr, fileVersionRegExpr, fileRegExpr, extRegExpr))
        }
    } else if(content.contains("http://") || content.contains("https://")) {
      None
    } else throw new UnsupportedOperationException(s"Unknown path to image: $content")
  }

  protected def getFileTuple(content: String, any: Product) = any match {
    case (folderRegExprStr: String, fileRegExprStr: String)                                                          =>
      val folderName =
        folderRegExprStr.r
          .findFirstMatchIn(content)
          .map(_.group(1))
          .getOrElse(throw new IllegalArgumentException("parameter folderId should be provided"))
      val fileName =
        fileRegExprStr.r
          .findFirstMatchIn(content)
          .map(_.group(1))
          .getOrElse(throw new IllegalArgumentException("parameter file should be provided"))
      Some((folderName, fileName))
    case (groupIdRegExprStr: String, fileRegExprStr: String, uuidRegExprStr: String)                                 =>
      val uuid =
        uuidRegExprStr.r
          .findFirstMatchIn(content)
          .map(_.group(1))
          .getOrElse(throw new IllegalArgumentException("parameter entryId should be provided"))
      val groupId =
        groupIdRegExprStr.r
          .findFirstMatchIn(content)
          .map(_.group(1))
          .getOrElse(throw new IllegalArgumentException("parameter version should be provided"))
          .toLong
      val fileName =
        fileRegExprStr.r
          .findFirstMatchIn(content)
          .map(_.group(1))
          .getOrElse(throw new IllegalArgumentException("parameter file should be provided"))
      Some((uuid, groupId, fileName.replaceAll("""\s+""", "_")))
    case (fileEntryRegExprStr: String, fileVersionRegExprStr: String, fileRegExprStr: String, extRegExprStr: String) =>
      val fileEntryId =
        fileEntryRegExprStr.r
          .findFirstMatchIn(content)
          .map(_.group(1))
          .getOrElse(throw new IllegalArgumentException("parameter entryId should be provided"))
          .toLong
      val fileVersion =
        fileVersionRegExprStr.r
          .findFirstMatchIn(content)
          .map(_.group(1))
          .getOrElse(throw new IllegalArgumentException("parameter version should be provided"))
      val fileName =
        fileRegExprStr.r
          .findFirstMatchIn(content)
          .map(_.group(1))
          .getOrElse(throw new IllegalArgumentException("parameter file should be provided"))
      val fileExt =
        extRegExprStr.r
          .findFirstMatchIn(content)
          .map(_.group(1))
          .getOrElse(throw new IllegalArgumentException("parameter file should be provided"))
      Some((fileEntryId, fileVersion, fileName + "." + fileExt))
  }

  protected def composeFileEntity(fileEntity: SlideElementModel): Option[(String, InputStream)] = composeFile(fileEntity.content)

  private def composeFile(content: String): Option[(String, InputStream)] = getFromPath(content).map(getPathAndInputStream)

  protected def getFileName(any: Product) = any match {
    case (folderName: String, fileName: String)                     => fileName
    case (fileEntryId: Long, fileVersion: String, fileName: String) => fileName
    case (uuid: String, groupId: Long, fileName: String)            => fileName
  }

  protected def getPath(any: Product, version: Option[String]) = any match {
    case (folderName: String, fileName: String)                     =>
      val folderPrefix = version match {
          case Some(v) => "resources"
          case _       => "images"
        }
      s"$folderPrefix/$folderName/$fileName"
    case (fileEntryId: Long, fileVersion: String, fileName: String) =>
      s"resources/$fileEntryId/$fileName"
  }

  protected def getPathAndInputStream(any: Product) = any match {
    case (folderName: String, fileName: String)                     =>
      val fromOldVersion = Pattern.compile("slide_\\d+_.*").matcher(folderName).find
      val folderPrefix = if (fromOldVersion) "images" else "resources"
      s"$folderPrefix/$folderName/$fileName" -> new ByteArrayInputStream(fileService.getFileContent(folderName, fileName))
    case (fileEntryId: Long, fileVersion: String, fileName: String) =>
      s"resources/$fileEntryId/$fileName" -> new ByteArrayInputStream(fileService.getFileContent(fileEntryId, fileVersion))
    case (uuid: String, groupId: Long, fileName: String)            =>
      s"resources/$uuid/$fileName." +
        fileService.getFileEntry(uuid, groupId).getExtension -> new ByteArrayInputStream(fileService.getFileContent(uuid, groupId))
  }

  protected def getRequiredFiles(slides: List[SlideModel]) =
    getRequiredFileModels(slides).flatten

  private def getRequiredFileModels(slides: List[SlideModel]): List[Option[(String, InputStream)]] =
    slides.flatMap { slide =>
      val slideResource = slide.bgImage.flatMap(composeFile)
      val slideElementResources =
        slide
          .slideElements
          .filter(x => SlideEntityType.AvailableExternalFileTypes.contains(x.slideEntityType))
          .map(composeFileEntity)

      slideResource :: slideElementResources
    }

  protected def slideElementDir(id: Long, version: Option[String]) = s"slide_item_$id"
  protected def slideSetLogoDir(id: Long, version: Option[String]) = {
    val prefix = version match {
      case Some(v) => "slideset_logo_"
      case _       => "slide_logo"
    }
    s"$prefix$id"
  }
  protected def slideBgImageDir(id: Long, version: Option[String]) = s"slide_$id"

  protected def getUrl(folderId: String, fileName: String) = s"""url("/delegate/files/images?folderId=${folderId}&file=${fileName}")"""
  protected def getDisplayMode(url: String) = url.reverse.takeWhile(_ != ' ').reverse

  protected def addSlideEntityImageToFileService = addImageToFileService(slideElementDir) _
  protected def addSlideLogoToFileService = addImageToFileService(slideSetLogoDir) _
  protected def addSlideBgImageToFileService = addImageToFileService(slideBgImageDir) _
  protected def addImageToFileService(folderPrefix: (Long, Option[String]) => String)(newSlideId: Long, version: Option[String], fileName: String, path: String): String = {
    val folder = folderPrefix(newSlideId, slidesVersion)
    fileService.setFileContent(
      folder = folder,
      name = fileName,
      content = FileSystemUtil.getFileContent(new File(path)),
      deleteFolder = false)
    getUrl(folder, fileName)
  }

  protected def omitFileDuplicates(files: List[(String, InputStream)]): List[(String, InputStream)] = {
    files.groupBy(_._1).map(_._2.head).toList
  }
}