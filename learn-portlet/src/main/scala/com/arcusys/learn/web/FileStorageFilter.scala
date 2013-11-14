package com.arcusys.learn.web

import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.scorm.util.FileSystemUtil
import org.scalatra.fileupload.FileUploadSupport

class FileStorageFilter(configuration: BindingModule) extends ServletBase(configuration) with FileUploadSupport {
  def this() = this(Configuration)

  import storageFactory._

  get("/*.*") {
    val filename = multiParams("splat").mkString(".")
    val extension = multiParams("splat").last.split('.').last
    contentType = extension match {
      case "css" => "text/css"
      case "htm" => "text/html"
      case "html" => "text/html"
      case "js" => "application/javascript"
      case _ => FileSystemUtil.getMimeType(filename)
    }
    val fileContentOption = fileStorage.getFile(filename)
    if (fileContentOption.isDefined) {
      response.getOutputStream.write(fileContentOption.get.content.getOrElse(halt(405)))
    } else halt(404)
  }
}
