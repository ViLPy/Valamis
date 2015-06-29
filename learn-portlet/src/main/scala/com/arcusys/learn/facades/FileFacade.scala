package com.arcusys.learn.facades

import java.io._
import java.net.URLEncoder
import java.util.UUID
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.{ FileRequest, PackageFileRequest }
import com.arcusys.learn.models.{ FileResponse, PPTXResponse, PPTXSlideResponse }
import com.arcusys.learn.utils.PresentationProcessorContract
import com.arcusys.valamis.file.service.FileService
import com.arcusys.valamis.lesson.model.LessonType
import com.arcusys.valamis.lesson.service.PackageUploadManager
import com.arcusys.valamis.quiz.service.QuizService
import com.arcusys.valamis.util.FileSystemUtil
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import sun.reflect.generics.reflectiveObjects.NotImplementedException

class FileFacade(configuration: BindingModule) extends FileFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  private val fileService = inject[FileService]
  private val quizFacade = inject[QuizFacadeContract]
  private val certificateFacade = inject[CertificateFacadeContract]
  private val questionFacade = inject[QuestionFacadeContract]
  private val packageFacade = inject[PackageFacadeContract]
  private val quizService = inject[QuizService]
  private val packageUploadService = new PackageUploadManager()
  private val presentationProcessor = inject[PresentationProcessorContract]

  def saveFile(folder: String, name: String, content: Array[Byte]): FileResponse = {
    fileService.setFileContent(folder, name, content)
    new FileResponse(0, "", name, "")
  }

  def uploadPDF(content: Array[Byte], quizID: Int, categoryID: Option[String], filename: String): FileResponse = {
    def idFromCategory(id: String) = id.replace("c_", "").toInt

    fileService.setFileContent("quizData" + quizID, filename, content, false)
    val question = quizService.createQuestionPDF(quizID, categoryID.map(idFromCategory), "", filename)

    new FileResponse(question.id, "", filename, "")
  }

  def uploadPPTX(content: Array[Byte], quizID: Int, categoryID: Option[String], filename: String): PPTXResponse = {
    def idFromCategory(id: String) = id.replace("c_", "").toInt

    val slideList = presentationProcessor.convert(new ByteArrayInputStream(content))
    val folderName = "quizData" + quizID
    val pptxSlides = slideList.zipWithIndex.map {
      case (slide, i) =>
        val uuid = UUID.randomUUID()
        fileService.replaceFileContent(folderName, s"slide-${uuid}.png", slide.toByteArray)

        quizService.createQuestionPPTX(quizID, categoryID.map(idFromCategory), s"slide-${i + 1}.png", s"slide-${uuid}.png")
    }

    new PPTXResponse(-1, "", "", "", pptxSlides.map(slide =>
      PPTXSlideResponse(
        slide.title.getOrElse(""),
        "q_" + slide.id,
        slide.quizID,
        slide.categoryID.map("c_" + _))
    ))
  }

  def uploadRevealJS(content: Array[Byte], quizID: Int, categoryID: Option[String], title: String): FileResponse = {
    def idFromCategory(id: String) = id.replace("c_", "").toInt

    val revealContent = content.map(_.toChar).mkString
    val bodyClassRegex = """(?ims)(?<=class=")(.*?)(?=")""".r
    val sectionRegex = """(?ims)<section[^>]*>(.*)<\/section>""".r
    val scriptRegex = """(?ims)<script[^>]*>(.*?)<\/script>""".r
    val styleRegex = """(?ims)<style[^>]*>(.*?)<\/style>""".r
    val sections = sectionRegex.findAllIn(revealContent).toSeq.mkString
    val scripts = scriptRegex.findAllIn(revealContent).toSeq.mkString
    val styles = styleRegex.findAllIn(revealContent).toSeq.init.mkString
    val bodyClass = bodyClassRegex.findFirstIn(revealContent).getOrElse("")

    val setBodyScript = "<script>document.getElementsByTagName('html')[0].setAttribute('class','" + bodyClass + "')</script>"

    val text = URLEncoder.encode(styles + sections + setBodyScript + scripts, "UTF-8")

    val question = quizService.createQuestionRevealJS(quizID, categoryID.map(idFromCategory), title, text)

    new FileResponse(question.id, "", title, "")
  }

  def copyToFolder(sourceFolder: String, name: String, destFolder: String) {
    fileService.copyFile(sourceFolder, name, destFolder, name)
  }

  def getFileContent(folder: String, name: String): Array[Byte] = {
    fileService.getFileContent(folder, name)
  }

  def updatePackage(id: Int, title: Option[String], summary: Option[String]) = {
    throw new NotImplementedException
  }

  def remove(id: Int) = throw new NotImplementedException

  def attachImageToPackage(packageId: Int, imageId: Int) = throw new NotImplementedException

  def getPackages(skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean): Seq[FileResponse] = throw new NotImplementedException

  def getScormPackages(skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean): Seq[FileResponse] = throw new NotImplementedException

  def getTincanPackages(skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean): Seq[FileResponse] = throw new NotImplementedException

  def packageCount(skip: Int,
    take: Int,
    filter: String): Int = throw new NotImplementedException

  def scormPackageCount(skip: Int,
    take: Int,
    filter: String): Int = throw new NotImplementedException

  def tincanPackageCount(skip: Int,
    take: Int,
    filter: String): Int = throw new NotImplementedException

  def getScormPackage(scormPackageId: Int): FileResponse = throw new NotImplementedException

  def getTincanPackage(tincanPackageId: Int): FileResponse = throw new NotImplementedException

  def uploadPackage(title: String, summary: String, courseId: Long, userId: Long, stream: InputStream): FileResponse = {
    val file = FileSystemUtil.streamToTempFile(stream, "Upload", PackageFileRequest.PackageFileExtension)
    stream.close()
    val (packageId, packageType) = packageUploadService.uploadPackage(title, summary, courseId, userId, file)

    FileResponse(
      packageId.toInt,
      packageType match {
        case LessonType.Scorm  => "scorm"
        case LessonType.Tincan => "tincan"
      },
      "%s.%s".format(title, PackageFileRequest.PackageFileExtension),
      "") // TODO package url?
  }

  override def uploadPresentation(fileName: String, stream: InputStream, title: String, description: String, courseId: Long, userId: Long) = {

    val name = fileName.reverse.dropWhile(_ != '.').drop(1).reverse
    val packageFile = presentationProcessor.processPresentation(name, stream, title, description)

    val (packageId, packageType) = packageUploadService.uploadPackage(title, description, courseId, userId, packageFile)

    packageFile.delete()

    FileResponse(
      packageId.toInt,
      packageType match {
        case LessonType.Scorm  => "scorm"
        case LessonType.Tincan => "tincan"
      },
      "%s.%s".format(title, PackageFileRequest.PackageFileExtension),
      "") // TODO package url?
  }

  override def importLessons(courseId: Int, stream: InputStream): FileResponse = {
    val file = FileSystemUtil.streamToTempFile(stream, "Import", FileRequest.ExportExtension)
    stream.close()
    quizFacade.importLessons(file, courseId)

    FileResponse(-1, "Lesson", file.getName, "")
  }

  override def importQuestions(courseId: Int, stream: InputStream): FileResponse = {
    val file = FileSystemUtil.streamToTempFile(stream, "Import", FileRequest.ExportExtension)
    stream.close()
    questionFacade.importQuestions(file, courseId)

    FileResponse(-1, "Question", file.getName, "")
  }

  override def importPackages(courseId: Int, stream: InputStream, userId: Long): FileResponse = {
    val file = FileSystemUtil.streamToTempFile(stream, "Import", FileRequest.ExportExtension)
    stream.close()
    packageFacade.importPackages(file, courseId, userId)

    FileResponse(-1, "Package", file.getName, "")
  }

  override def importCertificates(companyId: Int, stream: InputStream): FileResponse = {
    val file = FileSystemUtil.streamToTempFile(stream, "Import", FileRequest.ExportExtension)
    stream.close()
    certificateFacade.importCertificates(file, companyId)

    FileResponse(-1, "Certificate", file.getName, "")
  }
}
