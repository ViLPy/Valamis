package com.arcusys.learn.bl.services

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.liferay.services.FileEntryServiceHelper
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.liferay.portlet.documentlibrary.model.DLFileEntry

class FileService(configuration: BindingModule) extends Injectable with FileServiceContract {
  def this() = this(DomainConfiguration)

  implicit val bindingModule = configuration

  private val fileStorage = inject[FileStorage]

  private def getPath(folder: String, name: String): String = {
    "files/" + folder + "/" + name
  }
  private def getPath(folder: String): String = {
    "files/" + folder + "/"
  }

  //TODO: method should not remove all folder, need to check references and fix
  override def setFileContent(folder: String, name: String, content: Array[Byte], deleteFolder: Boolean = true): Unit = {
    if (deleteFolder) fileStorage.delete(getPath(folder), asDirectory = true)
    else fileStorage.delete(getPath(folder, name), asDirectory = false)
    fileStorage.store(getPath(folder, name), content)
  }

  override def replaceFileContent(folder: String, name: String, content: Array[Byte]): Unit = {
    fileStorage.delete(getPath(folder, name))
    fileStorage.store(getPath(folder, name), content)
  }

  override def getFileContentOption(name: String): Option[Array[Byte]] = {
    fileStorage.getFile(name).flatMap(_.content)
  }

  override def getFileContent(folder: String, name: String): Array[Byte] = {
    val content = getFileContentOption(getPath(folder, name))
    if (content.isEmpty) {
      throw new Exception("file not found: " + name)
    }
    content.get
  }

  def getFileContent(uuid: String, groupId: Long): Array[Byte] = {
    FileEntryServiceHelper.getFile(uuid, groupId)
  }

  override def copyFile(sourceFolder: String, sourceName: String, destFolder: String, destName: String, deleteFolder: Boolean = true): Unit = {
    setFileContent(destFolder, destName, getFileContent(sourceFolder, sourceName), deleteFolder)
  }

  override def deleteFile(folder: String, name: String): Unit = {
    fileStorage.delete(getPath(folder, name), asDirectory = false)
  }

  def addToDocumentLibrary(filename: String, groupId: Int, videoTitle: String, extension: String, mimeType: String, size: Long): String = {
    FileEntryServiceHelper.addFileToDocumentLibrary(filename, groupId, videoTitle, extension, mimeType, size)
  }

  override def getFileEntry(uuid: String, groupId: Long): DLFileEntry = {
    FileEntryServiceHelper.getFileEntry(uuid, groupId)
  }
}
