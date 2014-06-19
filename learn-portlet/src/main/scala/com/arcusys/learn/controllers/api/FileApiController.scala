package com.arcusys.learn.controllers.api

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request._
import com.arcusys.learn.facades.FileFacadeContract
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.web.FileUploading

import org.scalatra.servlet.MultipartConfig
import org.scalatra.FlashMapSupport
import javax.servlet.http._

class FileApiController(configuration: BindingModule) extends BaseApiController(configuration) with FileUploading with FlashMapSupport {
  configureMultipartHandling(MultipartConfig(maxFileSize = Some(3 * 1024 * 1024)))

  def this() = this(Configuration)

  val fileFacade = inject[FileFacadeContract]

  get("/images")(action {
    response.reset()
    response.setStatus(HttpServletResponse.SC_OK)
    response.setContentType("image/png")

    val fileRequest = FileRequest(this)
    val content = fileFacade.getFileContent(fileRequest.folder, fileRequest.file)
    response.getOutputStream.write(content)
  })

  get("/packages/(:" + FileRequest.FILE_ID + ")")(action {
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

  post("/")(jsonAction {
    requireAdmin()
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

      case UploadContentType.PACKAGE => {
        val packageRequest = PackageFileRequest(this)
        fileFacade.savePackage(
          PackageFileRequest.DEFAULT_PACKAGE_TITLE,
          PackageFileRequest.DEFAULT_PACKAGE_DESCRIPTION,
          packageRequest.courseID,
          packageRequest.userID,
          packageRequest.groupID,
          packageRequest.stream)
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