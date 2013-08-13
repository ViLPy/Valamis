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

import java.awt.Image
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import com.arcusys.learn.liferay.service.asset.AssetHelper
import com.arcusys.scala.json.Json
;

class UploadService(configuration: BindingModule) extends ServletBase(configuration) with JsonSupport with FileUploadSupport {
  private val packageProcessor = new PackageProcessor()
  private val assetHelper = new AssetHelper()

  def this() = this(Configuration)

  post("/package") {
    val title = parameter("title") withDefault "New package"
    val summary = parameter("summary") withDefault ""
    val stream = fileParams.get("file").head.getInputStream // take only the first
    val userID = parameter("scormUserID").withDefault("0").toLong
    val groupID = parameter("liferayGroupID").withDefault("-1").toLong
    val courseID = parameter("courseID").intOption(-1)
    contentType = "text/plain"
    storePackage(title, summary, courseID, stream, userID, groupID)
  }

  def storePackage(title:String, summary:String, courseID:Option[Int], stream:InputStream, userID:Long, groupID:Long)={
    val packageTmpUUID = FileProcessing.getTempFileName()
    val newFilename = FileSystemUtil.getRealPath(FileSystemUtil.getTmpDir + packageTmpUUID + ".zip")
    val outFile = new File(newFilename)
    val outStream = new FileOutputStream(outFile)
    FileProcessing.copyInputStream(stream, outStream)
    val packageID = packageProcessor.processPackageAndGetID(title, summary, packageTmpUUID, courseID)
    if (groupID != -1) assetHelper.addPackage(userID, groupID, storageFactory.packageStorage.getByID(packageID).getOrElse(throw new Exception("Can't find newly created package")))
    packageID
  }

  get("/get-files") {
    val subdirectory = parameter("currentDir") withDefault ""
    val subdirectoryPath = if (!subdirectory.equals("")) subdirectory + "/" else "/"
    val listFiles = storageFactory.fileStorage.getFiles("files" + subdirectoryPath).filter(!_.filename.replaceFirst("files" + subdirectoryPath, "").contains("/"))
    val sortedFiles = listFiles.sortBy(_.content.isEmpty)
    val imagePath = servletContext.getContextPath + "/SCORMData/files" + subdirectoryPath
    val thumbPath = servletContext.getContextPath + "/SCORMData/thumb" + subdirectoryPath

    json(sortedFiles.map(file => {
      val fileName = file.getFileName
      if (!file.content.isEmpty) Map("thumb" -> (thumbPath + fileName + ".jpg"), "url" -> (imagePath + fileName), "name" -> fileName, "isDirectory" -> false)
      else Map("name" -> fileName, "isDirectory" -> true)
    }))
  }

  post("/upload-file") {
    val directory = parameter("currentDirectory") withDefault ""
    val currentDirectory = if (!directory.equals("")) directory + "/" else ""
    val stream = fileParams.get("file").head.getInputStream // take only the first
    val fullName = fileParams.get("file").head.getName // IE returns absolute path, e.g. C:/users/anonymous/Docs/pict.jpg Need to trim it
    val name = new File(fullName).getName
    val path = "files/" + currentDirectory + name
    val contentSource = scala.io.Source.fromInputStream(stream)(scala.io.Codec.ISO8859)
    val content = contentSource.map(_.toByte).toArray
    contentSource.close()
    storageFactory.fileStorage.store(path, content)

    val outThumbFile = File.createTempFile("thumb", ".jpg")
    val outThumbStream = new FileOutputStream(outThumbFile)
    val thumbPath = "thumb/" + currentDirectory + name + ".jpg"
    try {
      imageProcessor(new ByteArrayInputStream(content), outThumbStream)
      val thumbContentSource = scala.io.Source.fromFile(outThumbFile.getAbsolutePath)(scala.io.Codec.ISO8859)
      val thumbContent = thumbContentSource.map(_.toByte).toArray
      thumbContentSource.close()
      storageFactory.fileStorage.store(thumbPath, thumbContent)
      outThumbStream.close()
      outThumbFile.delete()
    } catch {
      case e: NullPointerException => {
        outThumbStream.close()
        outThumbFile.delete()
      }
    }

    val imageName = servletContext.getContextPath + "/SCORMData/" + path
    val thumbName = servletContext.getContextPath + "/SCORMData/" + thumbPath
    contentType = "text/plain"
    Json.toJson(Map("thumb" -> thumbName, "url" -> imageName, "name" -> name, "isDirectory" -> false))
  }

  post("/create-folder") {
    contentType = "text/plain"
    val folderName = parameter("dirName") withDefault ""
    val folder = parameter("currentDirectory") withDefault ""
    val folderPath = if (!folder.equals("")) folder + "/" else folder
    storageFactory.fileStorage.store("files/" + folderPath + folderName)
    true
  }



  private def imageProcessor(input: InputStream, output: FileOutputStream) {
    val sourceImage = ImageIO.read(input)
    val height = sourceImage.getHeight
    val width = sourceImage.getWidth
    val thumbnail = if (height > width) {
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
