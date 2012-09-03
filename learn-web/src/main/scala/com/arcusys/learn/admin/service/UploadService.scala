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

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

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

    contentType = "text/plain"
    PackageProcessor.processPackageAndGetID(title, summary, packageTmpUUID)
    //val data = json("id" -> )
  }

  get("/get-files") {
    //TODO: guess it's not needed due to JsonSupport
    val subdir = parameter("currentDir") withDefault ""
    val subdirPath = if (!subdir.equals("")) subdir + "/" else ""
    val imagePath = servletContext.getContextPath + "/SCORMData/files/" + subdirPath
    val imageThumbPath = servletContext.getContextPath + "/SCORMData/thumb/" + subdirPath
    val path = FileSystemUtil.getRealPath("/SCORMData/files/" + subdirPath)
    val listFiles = new File(path).listFiles.toSeq
    val sortedFiles = listFiles.sortBy(_.isFile)

    json(sortedFiles.map(file => {
      val fileName = file.getName
      if (!file.isDirectory) Map("thumb" -> (imageThumbPath + fileName + ".jpg"), "url" -> (imagePath + fileName), "name" -> fileName, "isDirectory" -> false)
      else Map("name" -> fileName, "isDirectory" -> true)
    }))
  }

  post("/upload-file") {
    val directory = parameter("currentDirectory") withDefault ""
    val currentDirectory = if (!directory.equals("")) directory + "/" else ""
    val stream = fileParams.get("file").head.getInputStream // take only the first
    val fullName = fileParams.get("file").head.getName // IE returns absolute path, e.g. C:/users/anonymouse/Docs/pict.jpg Need to trim it
    val name = new File(fullName).getName
    val path = FileSystemUtil.getRealPath("/SCORMData/files/" + currentDirectory + name)
    val outFile = new File(path)
    val outStream = new FileOutputStream(outFile)
    FileProcessing.copyInputStream(stream, outStream)

    val pathThumb = FileSystemUtil.getRealPath("/SCORMData/thumb/" + currentDirectory + name + ".jpg")
    val inThumbFile = new File(path)
    val inThumbStream = new FileInputStream(inThumbFile)
    val outThumbFile = new File(pathThumb)
    val outThumbStream = new FileOutputStream(outThumbFile)
    try {
      imageProcessor(inThumbStream, outThumbStream)
      inThumbStream.close()
      outThumbStream.close()
    } catch {
      case e:Exception => {
        inThumbStream.close()
        outThumbStream.close()
        outThumbFile.delete()
      }
    }

    val imageName = servletContext.getContextPath + "/SCORMData/files/" + currentDirectory + name
    val thumbName = servletContext.getContextPath + "/SCORMData/thumb/" + currentDirectory + name + ".jpg"
    json(Map("thumb" -> thumbName, "url" -> imageName, "name" -> name, "isDirectory" -> false))
  }

  post("/create-folder") {
    contentType = "text/plain"
    val folderName = parameter("dirName") withDefault ""
    val folder = parameter("currentDirectory") withDefault ""
    val folderPath = if (!folder.equals("")) folder + "/" else folder
    val path = FileSystemUtil.getRealPath("/SCORMData/files/" + folderPath + folderName)
    val result = new File(path).mkdir

    // create also for thumb directory
    val pathThumb = FileSystemUtil.getRealPath("/SCORMData/thumb/" + folderPath + folderName)
    new File(pathThumb).mkdir

    result
  }

  private def getTempUUID(fileInitialName: String = "SCORMZip", extension: String = ".tmp") = {
    val tmpFile = File.createTempFile(fileInitialName + "_", extension)
    val packageTmpUUID = tmpFile.getName
    tmpFile.delete

    packageTmpUUID
  }

  private def imageProcessor(input: FileInputStream, output: FileOutputStream) {
    val sourceImage = ImageIO.read(input)
    val height = sourceImage.getHeight
    val width = sourceImage.getWidth
    val thumbnail = if (height>width) {
      sourceImage.getScaledInstance(-1, 128, Image.SCALE_SMOOTH)
    } else {
      sourceImage.getScaledInstance(128, -1, Image.SCALE_SMOOTH)
    }
    val bufferedThumbnail = new BufferedImage(thumbnail.getWidth(null),
      thumbnail.getHeight(null),
      BufferedImage.TYPE_INT_RGB)
    bufferedThumbnail.getGraphics.drawImage(thumbnail, 0, 0, null)
    ImageIO.write(bufferedThumbnail, "jpeg", output)
  }
}
