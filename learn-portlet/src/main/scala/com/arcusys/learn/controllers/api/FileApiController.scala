package com.arcusys.learn.controllers.api

import java.io.InputStream
import javax.servlet.http._
import com.arcusys.learn.facades._
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.permission._
import com.arcusys.learn.liferay.services.{PermissionHelper, FileEntryServiceHelper}
import com.arcusys.learn.models.FileResponse
import com.arcusys.learn.models.request._
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.web.FileUploading
import com.arcusys.valamis.slide.service.SlideSetServiceContract
import com.escalatesoft.subcut.inject.BindingModule
import com.liferay.portal.util.PortalUtil
import org.joda.time.DateTime
import org.scalatra.servlet.MultipartConfig

class FileApiController(configuration: BindingModule) extends BaseApiController(configuration) with FileUploading {
  configureMultipartHandling(MultipartConfig(maxFileSize = Some(30 * 1024 * 1024)))

  private lazy val packageFacade = inject[PackageFacadeContract]
  private lazy val certificateFacade = inject[CertificateFacadeContract]
  private lazy val questionFacade = inject[QuestionFacadeContract]
  private lazy val quizFacade = inject[QuizFacadeContract]
  private lazy val fileFacade = inject[FileFacadeContract]
  private lazy val slideSetService = inject[SlideSetServiceContract]

  def this() = this(Configuration)

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
    val courseId = fileRequest.videoCourseId
    val uuid = fileRequest.videoUUId

    val url = PortalUtil.getPortalURL(request)
    val videosrcDL = url + "/c/document_library/get_file?uuid=" + uuid + "&groupId=" + courseId

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

  get("/files/packages/(:" + FileRequest.FileId + ")")(action {
    val fileRequest = FileRequest(this)
    fileRequest.action match {
      case FileActionType.All => {
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
      case FileActionType.Scorm => {
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
      case FileActionType.Tincan => {
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
      response.setHeader("Content-Disposition", s"attachment; filename=${nameOfFile}_${DateTime.now.toString("YYYY-MM-dd_HH-mm-ss")}${FileExportRequest.ExportExtension}")
      fileStream
    }

    val data = FileExportRequest(this)
    data.contentType match {
      case FileExportRequest.Package => {
        PermissionUtil.requirePermissionApi(ExportPermission, PortletName.LessonManager)
        data.action match {
          case FileExportRequest.ExportAll => getZipStream(packageFacade.exportAllPackages(data.courseId), "exportAllPackages")

          case FileExportRequest.Export     => getZipStream(packageFacade.exportPackages(data.idsLong), "exportPackages")
        }
      }
      case FileExportRequest.Certificate => {
        data.action match {
          case FileExportRequest.ExportAll => getZipStream(certificateFacade.exportCertificates(data.companyID), "exportAllCertificates")

          case FileExportRequest.Export     => getZipStream(certificateFacade.exportCertificate(data.companyID, data.id), "exportCertificates")
        }
      }
      case FileExportRequest.Question => {
        data.action match {
          case FileExportRequest.ExportAll => getZipStream(questionFacade.exportAllQuestionsBase(Option(data.courseId)), "exportAllQuestionBase")

          case FileExportRequest.Export =>
            getZipStream(questionFacade.exportQuestions(data.categoryIds, data.ids, Option(data.courseId)), "exportQuestions")
        }
      }
      case FileExportRequest.Lesson => {
        data.action match {
          case FileExportRequest.ExportAll => getZipStream(quizFacade.exportAllLessonsBase(data.courseId), "exportAllLessons")

          case FileExportRequest.Export     => getZipStream(quizFacade.exportLessons(data.ids), "exportLessons")

          case FileExportRequest.Download =>
            response.setHeader("Content-Type", "application/zip")
            response.setHeader("Content-Disposition", "attachment; filename=Lesson" + data.id + ".zip")
            quizFacade.download(data.id, data.courseId, data.publishType, data.theme, data.randomOrdering, data.questionPerUser, data.scoreLimit)

          case FileExportRequest.DownloadExternal =>
            response.setHeader("Content-Type", "application/zip")
            response.setHeader("Content-Disposition", "attachment; filename=Lesson" + data.id + ".zip")

            val portalURL = PortalUtil.getPortalURL(PortalUtil.getCompany(request).getVirtualHostname, PortalUtil.getPortalPort(false), false)
            quizFacade.downloadExternal(data.id, data.courseId, data.publishType, data.theme, data.randomOrdering, data.questionPerUser, data.scoreLimit, portalURL)
        }
      }
      case FileExportRequest.SlideSet =>
        data.action match {
          case FileExportRequest.Export => getZipStream(slideSetService.exportSlideSet(data.id), "ExportedSlideSet")
        }
    }
  })

  post("/files(/)")(jsonAction {

    val fileRequest = FileRequest(this)
    fileRequest.action match {
      case FileActionType.Add    => addFile(fileRequest)
      case FileActionType.Update => updateFile(PackageFileRequest(this))
      case FileActionType.Delete =>
        PermissionUtil.requirePermissionApi(ModifyPermission,
          PortletName.CertificateManager,
          PortletName.LessonDesigner,
          PortletName.LessonManager,
          PortletName.ContentManager)
        fileFacade.remove(fileRequest.id.get)
    }
  })

  private def addFile(fileRequest: FileRequest.Model) = {
    fileRequest.contentType match {

      case UploadContentType.Base64Icon =>
        PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        fileFacade.saveFile(
          fileRequest.folder,
          FileRequest.DefaultIconName,
          fileRequest.base64Content)

      case UploadContentType.Icon =>
        PermissionUtil.requirePermissionApi(
          Permission(ModifyPermission, List(PortletName.CertificateManager, PortletName.LessonDesigner, PortletName.LessonManager)),
          Permission(ViewPermission, List(PortletName.SlidesEditor))
        )
        fileFacade.saveFile(
          fileRequest.folder,
          fileRequest.fileName,
          fileRequest.fileContent)

      case UploadContentType.RevealJs =>
        PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.LessonDesigner)
        fileFacade.uploadRevealJS(
          fileRequest.fileContent,
          fileRequest.quizId,
          fileRequest.categoryId,
          fileRequest.fileName
        )

      case UploadContentType.Pdf =>
        PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.LessonDesigner)
        fileFacade.uploadPDF(
          fileRequest.fileContent,
          fileRequest.quizId,
          fileRequest.categoryId,
          fileRequest.fileName
        )

      case UploadContentType.Pptx =>
        PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.LessonDesigner)
        fileFacade.uploadPPTX(
          fileRequest.fileContent,
          fileRequest.quizId,
          fileRequest.categoryId,
          fileRequest.fileName
        )

      case UploadContentType.Package => {
        PermissionUtil.requirePermissionApi(UploadPermission, PortletName.LessonManager)
        val packageRequest = PackageFileRequest(this)
        if (fileRequest.fileName.endsWith(".zip")) {
          fileFacade.uploadPackage(
            PackageFileRequest.DefaultPackageTitle,
            PackageFileRequest.DefaultPackageDescription,
            packageRequest.courseId,
            PermissionUtil.getUserId,
            packageRequest.stream)
        } else {
          if (fileRequest.fileName.endsWith(".pptx")) {
            fileFacade.uploadPresentation(
              fileRequest.fileName,
              fileRequest.stream,
              PackageFileRequest.DefaultPackageTitle,
              PackageFileRequest.DefaultPackageDescription,
              packageRequest.courseId,
              PermissionUtil.getUserId
            )
          }
        }
      }

      case UploadContentType.DocLibrary => {
        PermissionUtil.requirePermissionApi(
          Permission(ModifyPermission, List(PortletName.CertificateManager, PortletName.LessonDesigner, PortletName.LessonManager)),
          Permission(ViewPermission, List(PortletName.SlidesEditor))
        )
        val userId = PermissionUtil.getUserId
        PermissionHelper.preparePermissionChecker(userId)

        val content = FileEntryServiceHelper.getFile(fileRequest.fileEntryId, fileRequest.fileVersion)
        fileFacade.saveFile(
          fileRequest.folder,
          fileRequest.file,
          content)

      }

      case UploadContentType.ImportLesson => {
        PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.LessonDesigner)
        fileFacade.importLessons(
          fileRequest.courseId,
          fileRequest.stream)
      }

      case UploadContentType.ImportQuestion=> {
        PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.ContentManager)
        fileFacade.importQuestions(
          fileRequest.courseId,
          fileRequest.stream)
      }

      case UploadContentType.ImportCertificate => {
        PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        fileFacade.importCertificates(
          fileRequest.companyIdRequired,
          fileRequest.stream)
      }

      case UploadContentType.ImportPackage => {
        PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.LessonManager)
        val userId = PermissionUtil.getUserId
        fileFacade.importPackages(
          fileRequest.courseId,
          fileRequest.stream,
          userId)
      }

      case UploadContentType.ImportSlideSet => {
        PermissionUtil.requirePermissionApi(ViewPermission, PortletName.SlidesEditor)
        slideSetService.importSlideSet(
          fileRequest.stream,
          fileRequest.courseId
        )
        FileResponse(-1,
          "SlideSet",
          "SlideSet",
          "")
      }

    }
  }

  private def updateFile(packageRequest: PackageFileRequest.Model) {
    packageRequest.contentType match {

      case UploadContentType.Icon | UploadContentType.Base64Icon => {
        PermissionUtil.requirePermissionApi(ModifyPermission,
          PortletName.CertificateManager, PortletName.LessonDesigner, PortletName.LessonManager)
        fileFacade.attachImageToPackage(
          packageRequest.id.get,
          packageRequest.imageID)
      }

      case UploadContentType.Package => {
        PermissionUtil.requirePermissionApi(UploadPermission, PortletName.LessonManager)
        fileFacade.updatePackage(
          packageRequest.id.get,
          packageRequest.title,
          packageRequest.summary)
      }
    }
  }
}