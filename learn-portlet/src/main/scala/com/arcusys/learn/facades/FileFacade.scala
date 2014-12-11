package com.arcusys.learn.facades

import java.io._

import com.arcusys.learn.bl.services.lesson.PackageUploadManager
import com.arcusys.learn.bl.services.FileServiceContract
import com.arcusys.learn.bl.utils.PresentationProcessorContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.{ PPTXSlideResponse, PPTXResponse, FileResponse }
import com.arcusys.learn.models.request.{ FileRequest, PackageFileRequest }
import com.arcusys.scorm.util.{ FileProcessing, FileSystemUtil }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import sun.reflect.generics.reflectiveObjects.NotImplementedException
import java.net.URLEncoder

class FileFacade(configuration: BindingModule) extends FileFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  private val fileService = inject[FileServiceContract]
  private val quizFacade = inject[QuizFacadeContract]
  private val certificateFacade = inject[CertificateFacadeContract]
  private val questionFacade = inject[QuestionFacadeContract]
  private val packageFacade = inject[PackageFacadeContract]
  private val quizService = inject[com.arcusys.learn.bl.services.QuizServiceContract]
  private val packageUploadService = new PackageUploadManager()
  private val presentationProcessor = inject[PresentationProcessorContract]

  private val EXPORT_EXTENSION = ".zip"

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

    val slideList = presentationProcessor.convert(content)
    val folderName = "quizData" + quizID

    val pptxSlides = slideList.zipWithIndex.map {
      case (slide, i) =>
        val slideName = s"slide-${i + 1}.png"
        fileService.replaceFileContent(folderName, slideName, slide.toByteArray)

        quizService.createQuestionPPTX(quizID, categoryID.map(idFromCategory), slideName, slideName)
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

  def savePackage(title: String, summary: String, courseId: Option[Int], userId: Long, groupId: Long, stream: InputStream): FileResponse = {

    val (packageId, packageType, packageTmpUUID) = packageUploadService.uploadPackage(title, summary, courseId, userId, groupId, stream)

    FileResponse(
      packageId,
      packageType,
      "%s.%s".format(packageTmpUUID, PackageFileRequest.PACKAGE_FILE_EXTENSION),
      "") // TODO package url?
  }

  override def savePresentation(requestFileName: String,
    requestFileContent: Array[Byte],
    packageTitle: String,
    packageDescription: String,
    courseID: Option[Int],
    userId: Long,
    groupID: Long) = {

    val zippedPackage = presentationProcessor.processPresentation(requestFileName,
      requestFileContent,
      packageTitle,
      packageDescription
    )

    val content = new FileInputStream(zippedPackage)
    savePackage(
      packageTitle,
      packageDescription,
      courseID,
      userId,
      groupID,
      content)
  }

  override def importLessons(courseId: Int, stream: InputStream): FileResponse = {
    val newFilename = getFile(stream)
    val result = quizFacade.importLessons(newFilename, courseId)

    FileResponse(
      -1,
      "Lesson",
      "%s%s".format(newFilename, FileRequest.EXPORT_EXTENSION),
      "")
  }

  override def importQuestions(courseId: Int, stream: InputStream): FileResponse = {
    val newFilename = getFile(stream)
    val result = questionFacade.importQuestions(newFilename, courseId)

    FileResponse(
      -1,
      "Question",
      "%s%s".format(newFilename, FileRequest.EXPORT_EXTENSION),
      "")
  }

  override def importPackages(courseId: Int, stream: InputStream): FileResponse = {
    val newFilename = getFile(stream)
    val result = packageFacade.importPackages(newFilename, courseId)

    FileResponse(
      -1,
      "Package",
      "%s%s".format(newFilename, FileRequest.EXPORT_EXTENSION),
      "")
  }

  override def importCertificates(companyId: Int, stream: InputStream): FileResponse = {
    val newFilename = getFile(stream)
    val result = certificateFacade.importCertificates(newFilename, companyId)

    FileResponse(
      -1,
      "Certificate",
      "%s%s".format(newFilename, FileRequest.EXPORT_EXTENSION),
      "")
  }

  private def getFile(stream: InputStream) = {
    val newFilename = FileProcessing.getTempFileName("Import", FileRequest.EXPORT_EXTENSION)
    val newFilePath = FileSystemUtil.getRealPath(s"/${newFilename}")

    val outFile = new File(newFilePath)
    val outStream = new FileOutputStream(outFile)
    FileProcessing.copyInputStream(stream, outStream)
    newFilePath
  }
}
