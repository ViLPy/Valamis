package com.arcusys.learn.web

import com.arcusys.learn.controllers.api.BaseApiController
import com.arcusys.valamis.file.service.FileService
import com.arcusys.valamis.util.FileSystemUtil
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import org.scalatra.servlet.FileUploadSupport
import org.scalatra.SinatraRouteMatcher

class FileStorageFilter(configuration: BindingModule) extends BaseApiController(configuration) with ServletBase with FileUploadSupport {
  def this() = this(Configuration)
  //next line fixes 404
  implicit override def string2RouteMatcher(path: String) = new SinatraRouteMatcher(path)

  private val fileService = inject[FileService]

  get("/*.*") {
    val filename = multiParams("splat").mkString(".")
    val extension = multiParams("splat").last.split('.').last
    contentType = extension match {
      case "css"  => "text/css"
      case "htm"  => "text/html"
      case "html" => "text/html"
      case "js"   => "application/javascript"
      case "png"  => "image/png"
      case "jpg"  => "image/jpeg"
      case "jpeg" => "image/jpeg"
      case "gif"  => "image/gif"
      case "swf"  => "application/x-shockwave-flash"
      case _      => FileSystemUtil.getMimeType(filename)
    }
    val fileContentOption = fileService.getFileContentOption(filename)
    if (fileContentOption.isDefined) {
      response.getOutputStream.write(fileContentOption.getOrElse(halt(405)))
    } else halt(404)
  }
}
