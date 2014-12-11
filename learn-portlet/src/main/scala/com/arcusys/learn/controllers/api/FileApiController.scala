package com.arcusys.learn.controllers.api

import java.io.InputStream
import javax.servlet.http._

import com.arcusys.learn.facades._
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.services.FileEntryServiceHelper
import com.arcusys.learn.models.request._
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.web.FileUploading
import com.escalatesoft.subcut.inject.BindingModule
import com.liferay.portal.security.auth.PrincipalThreadLocal
import com.liferay.portal.security.permission.{ PermissionCheckerFactoryUtil, PermissionThreadLocal }
import com.liferay.portal.service.UserLocalServiceUtil
import com.liferay.portal.util.PortalUtil
import org.joda.time.DateTime
import org.scalatra.servlet.MultipartConfig

class FileApiController(configuration: BindingModule) extends BaseApiController(configuration) with FileUploading {
  configureMultipartHandling(MultipartConfig(maxFileSize = Some(30 * 1024 * 1024)))

  def this() = this(Configuration)

  val fileFacade = inject[FileFacadeContract]
  private lazy val packageFacade = inject[PackageFacadeContract]
  private lazy val certificateFacade = inject[CertificateFacadeContract]
  private lazy val questionFacade = inject[QuestionFacadeContract]
  private lazy val quizFacade = inject[QuizFacadeContract]

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/files/images")(action {
    response.reset()
    response.setStatus(HttpServletResponse.SC_OK)
    response.setContentType("image/png")

    val fileRequest = FileRequest(this)
    val content = fileFacade.getFileContent(fileRequest.folder, fileRequest.file)
    response.getOutputStream.write(content)
  })

  get("/files/video")(action {
    response.reset()
    response.setStatus(HttpServletResponse.SC_OK)
    response.setContentType("text/html")

    val fileRequest = FileRequest(this)
    val groupId = fileRequest.videoGroupID
    val uuid = fileRequest.videoUUID

    val url = PortalUtil.getPortalURL(request)
    val videosrcDL = url + "/c/document_library/get_file?uuid=" + uuid + "&groupId=" + groupId

    val styles = "video::-webkit-media-controls-fullscreen-button { display: none!important;}"

    <html>
      <head>
        <style>
          { styles }
        </style>
      </head>
      <body style="margin:0; background: black;">
        <video width="100%" height="100%" controls="true">
          <source src={ videosrcDL }/>
        </video>
      </body>
    </html>

  })

  get("/files/packages/(:" + FileRequest.FILE_ID + ")")(action {
    val fileRequest = FileRequest(this)
    fileRequest.action match {
      case FileActionType.ALL => {
        val packages = fileFacade.getPackages(
          fileRequest.skip,
          fileRequest.count,
          fileRequest.filter,
          fileRequest.isSortDirectionAsc)

        val total = fileFacade.packageCount(
          fileRequest.skip,
          fileRequest.count,
          fileRequest.filter)

        CollectionResponse(
          fileRequest.page,
          packages,
          total)
      }
      case FileActionType.SCORM => {
        if (fileRequest.id.isDefined)
          fileFacade.getScormPackage(fileRequest.id.get)
        else {
          val packages = fileFacade.getScormPackages(
            fileRequest.skip,
            fileRequest.count,
            fileRequest.filter,
            fileRequest.isSortDirectionAsc)

          val total = fileFacade.scormPackageCount(
            fileRequest.skip,
            fileRequest.count,
            fileRequest.filter)

          CollectionResponse(
            fileRequest.page,
            packages,
            total)
        }
      }
      case FileActionType.TINCAN => {
        if (fileRequest.id.isDefined)
          fileFacade.getTincanPackage(fileRequest.id.get)
        else {
          val packages = fileFacade.getTincanPackages(
            fileRequest.skip,
            fileRequest.count,
            fileRequest.filter,
            fileRequest.isSortDirectionAsc)

          val total = fileFacade.tincanPackageCount(
            fileRequest.skip,
            fileRequest.count,
            fileRequest.filter)

          CollectionResponse(
            fileRequest.page,
            packages,
            total)
        }
      }
    }
  })

  get("/files/export(/)")(action {

    def getZipStream(fileStream: InputStream, nameOfFile: String) = {
      response.setHeader("Content-Type", "application/zip")
      response.setHeader("Content-Disposition", s"attachment; filename=${nameOfFile}_${DateTime.now.toString("YYYY-MM-dd_HH-mm-ss")}${FileExportRequest.EXPORT_EXTENSION}")
      fileStream
    }

    val data = FileExportRequest(this)
    data.contentType match {
      case FileExportRequest.PACKAGE => {
        data.action match {
          case FileExportRequest.EXPORT_ALL => getZipStream(packageFacade.exportAllPackages(data.courseID), "exportAllPackages")

          case FileExportRequest.EXPORT     => getZipStream(packageFacade.exportPackages(data.ids), "exportPackages")
        }
      }
      case FileExportRequest.CERTIFICATE => {
        data.action match {
          case FileExportRequest.EXPORT_ALL => getZipStream(certificateFacade.exportCertificates(data.companyID), "exportAllCertificates")

          case FileExportRequest.EXPORT     => getZipStream(certificateFacade.exportCertificate(data.companyID, data.id), "exportCertificates")
        }
      }
      case FileExportRequest.QUESTION => {
        data.action match {
          case FileExportRequest.EXPORT_ALL => getZipStream(questionFacade.exportAllQuestionsBase(Option(data.courseID)), "exportAllQuestionBase")

          case FileExportRequest.EXPORT =>
            getZipStream(questionFacade.exportQuestions(data.categoryIds, data.ids, Option(data.courseID)), "exportQuestions")
        }
      }
      case FileExportRequest.LESSON => {
        data.action match {
          case FileExportRequest.EXPORT_ALL => getZipStream(quizFacade.exportAllLessonsBase(data.courseID), "exportAllLessons")

          case FileExportRequest.EXPORT     => getZipStream(quizFacade.exportLessons(data.ids), "exportLessons")

          case FileExportRequest.DOWNLOAD =>
            response.setHeader("Content-Type", "application/zip")
            response.setHeader("Content-Disposition", "attachment; filename=Lesson" + data.id + ".zip")
            quizFacade.download(data.id, data.courseID, data.publishType, data.theme, data.randomOrdering, data.questionPerUser)

          case FileExportRequest.DOWNLOAD_EXTERNAL =>
            response.setHeader("Content-Type", "application/zip")
            response.setHeader("Content-Disposition", "attachment; filename=Lesson" + data.id + ".zip")

            val portalURL = PortalUtil.getPortalURL(PortalUtil.getCompany(request).getVirtualHostname, PortalUtil.getPortalPort(false), false)
            quizFacade.downloadExternal(data.id, data.courseID, data.publishType, data.theme, data.randomOrdering, data.questionPerUser, portalURL)
        }
      }
    }
  })

  post("/files(/)")(jsonAction {
    requireTeacherPermissions()
    val fileRequest = FileRequest(this)
    fileRequest.action match {
      case FileActionType.ADD    => addFile(fileRequest)
      case FileActionType.UPDATE => updateFile(PackageFileRequest(this))
      case FileActionType.DELETE => fileFacade.remove(fileRequest.id.get)
    }
  })

  private def addFile(fileRequest: FileRequest.Model) = {
    fileRequest.contentType match {
      case UploadContentType.BASE64_ICON => fileFacade.saveFile(
        fileRequest.folder,
        FileRequest.DEFAULT_ICON_NAME,
        fileRequest.base64Content)

      case UploadContentType.ICON => fileFacade.saveFile(
        fileRequest.folder,
        fileRequest.fileName,
        fileRequest.fileContent)

      case UploadContentType.REVEALJS => fileFacade.uploadRevealJS(
        fileRequest.fileContent,
        fileRequest.quizID,
        fileRequest.categoryID,
        fileRequest.fileName
      )

      case UploadContentType.PDF => fileFacade.uploadPDF(
        fileRequest.fileContent,
        fileRequest.quizID,
        fileRequest.categoryID,
        fileRequest.fileName
      )

      case UploadContentType.PPTX => fileFacade.uploadPPTX(
        fileRequest.fileContent,
        fileRequest.quizID,
        fileRequest.categoryID,
        fileRequest.fileName
      )

      case UploadContentType.PACKAGE => {
        val packageRequest = PackageFileRequest(this)
        if (fileRequest.fileName.endsWith(".zip")) {
          fileFacade.savePackage(
            PackageFileRequest.DEFAULT_PACKAGE_TITLE,
            PackageFileRequest.DEFAULT_PACKAGE_DESCRIPTION,
            packageRequest.courseID,
            getUserId,
            packageRequest.groupID,
            packageRequest.stream)
        } else {
          if (fileRequest.fileName.endsWith(".pptx")) {
            fileFacade.savePresentation(
              fileRequest.fileName,
              fileRequest.fileContent,
              PackageFileRequest.DEFAULT_PACKAGE_TITLE,
              PackageFileRequest.DEFAULT_PACKAGE_DESCRIPTION,
              packageRequest.courseID,
              getUserId,
              packageRequest.groupID
            )
          }
        }
      }

      case UploadContentType.DOC_LIBRARY => {
        val userID = getUserId
        val user = UserLocalServiceUtil.getUserById(userID)
        val permissionChecker = PermissionCheckerFactoryUtil.create(user)
        PermissionThreadLocal.setPermissionChecker(permissionChecker)
        PrincipalThreadLocal.setName(user.getUserId)

        val content = FileEntryServiceHelper.getFile(fileRequest.fileEntryID, fileRequest.fileVersion)
        fileFacade.saveFile(
          fileRequest.folder,
          fileRequest.file,
          content)

      }

      case UploadContentType.IMPORT_LESSON => {
        fileFacade.importLessons(
          fileRequest.courseIDRequired,
          fileRequest.stream)
      }

      case UploadContentType.IMPORT_QUESTION => {
        fileFacade.importQuestions(
          fileRequest.courseIDRequired,
          fileRequest.stream)
      }

      case UploadContentType.IMPORT_CERTIFICATE => {
        fileFacade.importCertificates(
          fileRequest.companyIDRequired,
          fileRequest.stream)
      }

      case UploadContentType.IMPORT_PACKAGE => {
        fileFacade.importPackages(
          fileRequest.courseIDRequired,
          fileRequest.stream)
      }
    }
  }

  private def updateFile(packageRequest: PackageFileRequest.Model) {
    packageRequest.contentType match {
      case UploadContentType.ICON | UploadContentType.BASE64_ICON => {
        fileFacade.attachImageToPackage(
          packageRequest.id.get,
          packageRequest.imageID)
      }

      case UploadContentType.PACKAGE => {
        fileFacade.updatePackage(
          packageRequest.id.get,
          packageRequest.title,
          packageRequest.summary)
      }
    }
  }
}