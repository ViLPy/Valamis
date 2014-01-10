package com.arcusys.learn.admin.service

import java.io._
import com.arcusys.scala.scalatra.json.JsonSupport

import org.scalatra.fileupload.FileUploadSupport
import com.arcusys.scorm.util.FileSystemUtil
import com.arcusys.scorm.util.FileProcessing
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration

import com.arcusys.scala.json.Json
import com.arcusys.learn.service.util.{AntiSamyHelper, SessionHandler}
import com.liferay.portal.kernel.util.Base64
import com.arcusys.learn.admin.service.deployer.PackageProcessor

class UploadService(configuration: BindingModule) extends ServletBase(configuration) with JsonSupport with FileUploadSupport {
  private val packageProcessor = new PackageProcessor()

  def this() = this(Configuration)

  post("/package") {
    //requireAdmin()

    val title = parameter("title") withDefault "New package"
    val summary = AntiSamyHelper.sanitize(parameter("summary") withDefault "")
    val stream = fileParams.get("file").head.getInputStream // take only the first
    val userID = parameter("scormUserID").withDefault("0").toLong
    val groupID = parameter("liferayGroupID").withDefault("-1").toLong
    val courseID = parameter("courseID").intOption(-1)
    contentType = "text/plain"
    storePackage(title, summary, courseID, stream, userID, groupID)
  }

  def storePackage(title: String, summary: String, courseID: Option[Int], stream: InputStream, userID: Long, groupID: Long) = {
    val packageTmpUUID = FileProcessing.getTempFileName()
    val newFilename = FileSystemUtil.getRealPath(FileSystemUtil.getTmpDir + packageTmpUUID + ".zip")
    val outFile = new File(newFilename)
    val outStream = new FileOutputStream(outFile)
    FileProcessing.copyInputStream(stream, outStream)
    val result = packageProcessor.processPackageAndGetID(title, summary, packageTmpUUID, courseID, userID, groupID)
    Json.toJson(Map(
      "id"-> result.packageId,
      "type"-> result.packageType
    ))
  }

  get("/get-files") {
    val subdirectory = parameter("currentDir") withDefault ""
    val subdirectoryPath = if (!subdirectory.equals("")) subdirectory + "/" else "/"
    val listFiles = storageFactory.fileStorage.getFiles("files" + subdirectoryPath).filter(!_.filename.replaceFirst("files" + subdirectoryPath, "").contains("/"))
    val sortedFiles = listFiles.sortBy(_.content.isEmpty)
    val imagePath = servletContext.getContextPath + "/SCORMData/files" + subdirectoryPath
    val thumbPath = servletContext.getContextPath + "/SCORMData/thumb" + subdirectoryPath

    Json.toJson(sortedFiles.map(file => {
      val fileName = file.getFileName
      if (!file.content.isEmpty) Map("thumb" -> (thumbPath + fileName + ".jpg"), "url" -> (imagePath + fileName), "name" -> fileName, "isDirectory" -> false)
      else Map("name" -> fileName, "isDirectory" -> true)
    }))
  }

  post("/upload-file") {
    requireAdmin()

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

  post("/base64-icon/:folderID"){
    requireAdmin()

    val directory = parameter("folderID").intRequired
    val inputBase64 = parameter("inputBase64").required.replace("data:image/png;base64,", "")
    val position = inputBase64.indexOf(";")
    val base64 = if (position == -1) inputBase64 else inputBase64.substring(0, position)
    val outputData = Base64.decode(base64)

    saveLogo(directory, "icon.png", outputData)
  }

  post("/upload-icon/:folderID") {
    requireAdmin()

    val directory = parameter("folderID").intRequired
    val stream = fileParams.get("file").head.getInputStream // take only the first
    val fullName = fileParams.get("file").head.getName // IE returns absolute path, e.g. C:/users/anonymous/Docs/pict.jpg Need to trim it
    val name = new File(fullName).getName.replaceAll(" ", "_")
    val contentSource = scala.io.Source.fromInputStream(stream)(scala.io.Codec.ISO8859)
    val content = contentSource.map(_.toByte).toArray
    contentSource.close()

    saveLogo(directory, name, content)

    json(Map("name" -> name))
  }

  private def saveLogo(directory: Int, name: String, content: Array[Byte]){
    storageFactory.fileStorage.delete("files/" + directory, true)
    storageFactory.fileStorage.store("files/" + directory + "/" + name, content)
    storageFactory.certificateStorage.saveLogo(directory, name)
  }

  post("/create-folder") {
    requireAdmin()

    contentType = "text/plain"
    val folderName = parameter("dirName") withDefault ""
    val folder = parameter("currentDirectory") withDefault ""
    val folderPath = if (!folder.equals("")) folder + "/" else folder
    storageFactory.fileStorage.store("files/" + folderPath + folderName)
    true
  }


  //TODO: I added JAVA_OPTS="-Djava.awt.headless=true" to setenv.bat to get it worked. Ask Vitaly about it
  private def imageProcessor(input: InputStream, output: FileOutputStream) {
    // System.setProperty("java.awt.headless", "true")
    // val tk = Toolkit.getDefaultToolkit()
    // val ge = GraphicsEnvironment.getLocalGraphicsEnvironment()
    //System.out.println("Headless mode: " + ge.isHeadlessInstance);

    /*  val sourceImage = ImageIO.read(input)
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
  ImageIO.write(bufferedThumbnail, "jpeg", output)*/
  }
}
