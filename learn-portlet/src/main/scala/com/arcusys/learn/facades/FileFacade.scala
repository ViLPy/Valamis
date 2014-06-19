package com.arcusys.learn.facades

import com.arcusys.learn.filestorage.storage.FileStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.{ PackageFileRequest }
import com.arcusys.scorm.util.{ FileSystemUtil, FileProcessing }
import java.io.{ InputStream, FileOutputStream, File }
import com.arcusys.learn.models.{ FileResponse }
import sun.reflect.generics.reflectiveObjects.NotImplementedException
import com.arcusys.learn.exceptions.EntityNotFoundException
import com.arcusys.learn.service.util.PackageProcessor

/**
 * Created by Iliya Tryapitsin on 17.03.14.
 */
class FileFacade(configuration: BindingModule) extends FileFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  private val fileStorage = inject[FileStorage]
  private val packageProcessor = new PackageProcessor()

  def saveFile(folder: String, name: String, content: Array[Byte]): FileResponse = {
    fileStorage.delete("files/" + folder + "/", true)
    fileStorage.store("files/" + folder + "/" + name, content)
    new FileResponse(0, "", name, "")
  }

  def copyToFolder(sourceFolder: String, name: String, destFolder: String) {
    val content = getFileContent(sourceFolder, name)
    saveFile(destFolder, name, content)
  }

  def getFileContent(folder: String, name: String): Array[Byte] =
    fileStorage.getFile("files/" + folder + "/" + name) match {
      case Some(value) => value.content match {
        case Some(content) => content
        case None          => throw new EntityNotFoundException
      }
      case None => throw new EntityNotFoundException
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

  def savePackage(title: String,
    summary: String,
    courseId: Option[Int],
    userId: Long,
    groupId: Long,
    stream: InputStream): FileResponse = {
    val packageTmpUUID = FileProcessing.getTempFileName()
    val newFilename = FileSystemUtil.getRealPath("%s%s.%s".format(
      FileSystemUtil.getTmpDir,
      packageTmpUUID,
      PackageFileRequest.PACKAGE_FILE_EXTENSION))

    val outFile = new File(newFilename)
    val outStream = new FileOutputStream(outFile)
    FileProcessing.copyInputStream(stream, outStream)
    val result = packageProcessor.processPackageAndGetID(
      title,
      summary,
      packageTmpUUID,
      courseId,
      userId,
      groupId)

    FileResponse(
      result.packageId,
      result.packageType,
      "%s.%s".format(packageTmpUUID, PackageFileRequest.PACKAGE_FILE_EXTENSION),
      "") // TODO package url?
  }
}
