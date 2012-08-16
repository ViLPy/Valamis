package com.arcusys.learn.admin.service

import java.io._
import com.arcusys.scala.scalatra.json.JsonSupport
import com.arcusys.scorm.deployer.PackageProcessor
import org.scalatra.fileupload.FileUploadSupport
import com.arcusys.scorm.util.FileSystemUtil
import com.arcusys.scorm.util.FileProcessing
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration

class UploadService(configuration: BindingModule) extends ServletBase(configuration) with JsonSupport with FileUploadSupport {
  def this() = this(Configuration)
  post("/package") {
    val title = parameter("title") withDefault "New package"
    val summary = parameter("summary") withDefault ""
    val stream = fileParams.get("file").head.getInputStream // take only the first
    val packageTmpUUID = getTempUUID()
    val newFilename = FileSystemUtil.getRealPath("/SCORMData/zipPackages/" + packageTmpUUID + ".zip")

    val outFile = new File(newFilename)
    val outStream = new FileOutputStream(outFile)
    FileProcessing.copyInputStream(stream, outStream)

    val packageID = PackageProcessor.processPackageAndGetID(title, summary, packageTmpUUID)
    json("id"->packageID)
  }

  post("/get-images") {
    //TODO: guess it's not needed due to JsonSupport
    contentType = "text/plain"
    val subdir = parameter("subdir") withDefault ""
    val subdirPath = if (!subdir.equals("")) subdir + "/" else ""
    val imagePath = servletContext.getContextPath + "/SCORMData/images/" + subdirPath
    val path = FileSystemUtil.getRealPath("/SCORMData/images/" + subdirPath)
    val listFiles = new File(path).listFiles.toSeq
    val sortedFiles = listFiles.sortBy(_.isFile)

    json(sortedFiles.map(file => {
      val fileName = file.getName
      if (!file.isDirectory) Map("subdir" -> subdirPath, "thumb" -> (imagePath + fileName), "image" -> (imagePath + fileName), "name" -> fileName, "isDirectory" -> false)
      else Map("subdir" -> subdirPath, "name" -> fileName, "isDirectory" -> true)
    }))
  }

  post("/upload-image") {
    contentType = "text/plain"
    val directory = parameter("currentDirectory") withDefault ""
    val currentDirectory = if (!directory.equals("")) directory + "/" else ""
    val stream = fileParams.get("file").head.getInputStream // take only the first
    val fullName = fileParams.get("file").head.getName // IE returns absolute path, e.g. C:/users/anonymouse/Docs/pict.jpg Need to trim it
    val name = new File(fullName).getName
    val path = FileSystemUtil.getRealPath("/SCORMData/images/" + currentDirectory + name)
    val outFile = new File(path)
    val outStream = new FileOutputStream(outFile)
    FileProcessing.copyInputStream(stream, outStream)
    val imageName = servletContext.getContextPath + "/SCORMData/images/" + currentDirectory + name
    contentType = "text/html"
    "<img src=\"" + imageName + "\"/>"
  }

  post("/upload-file") {
    contentType = "text/plain"
    val stream = fileParams.get("file").head.getInputStream // take only the first
    val name = fileParams.get("file").head.getName

    val splittedFileName = name.lastIndexOf('.') match {
      case -1 => (name, "")
      case x: Int => (name.substring(0, x), name.substring(x).toLowerCase)
    }

    val generatedName = getTempUUID(splittedFileName._1, splittedFileName._2)
    val path = FileSystemUtil.getRealPath("/SCORMData/files/" + generatedName)
    val outFile = new File(path)
    val outStream = new FileOutputStream(outFile)
    FileProcessing.copyInputStream(stream, outStream)
    val fileName = servletContext.getContextPath + "/SCORMData/files/" + generatedName
    contentType = "text/html"
    "<a href=\"" + fileName + "\" rel=\"" + name + "\" class=\"redactor_file_link redactor_file_ico_other\">" + name + "</a>"
  }

  post("/create-folder") {
    contentType = "text/plain"
    val folderName = parameter("folderName") withDefault ""
    val folder = parameter("folderPath") withDefault ""
    val folderPath = if (!folder.equals("")) folder + "/" else folder
    val path = FileSystemUtil.getRealPath("/SCORMData/images/" + folderPath + folderName)
    val result = new File(path).mkdir
    result
  }

  private def getTempUUID(fileInitialName: String = "SCORMZip", extension: String = ".tmp") = {
    val tmpFile = File.createTempFile(fileInitialName + "_", extension)
    val packageTmpUUID = tmpFile.getName
    tmpFile.delete

    packageTmpUUID
  }
}
