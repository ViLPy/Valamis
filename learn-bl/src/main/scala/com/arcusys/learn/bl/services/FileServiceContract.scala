package com.arcusys.learn.bl.services

import com.liferay.portlet.documentlibrary.model.DLFileEntry

trait FileServiceContract {

  // method should not remove all folder, need to check references and fix
  def setFileContent(folder: String, name: String, content: Array[Byte], deleteFolder: Boolean = true): Unit

  //I didn't want to deal with setFileContent, because I needed folders.
  def replaceFileContent(folder: String, name: String, content: Array[Byte]): Unit

  def getFileContentOption(name: String): Option[Array[Byte]]

  def getFileContent(folder: String, name: String): Array[Byte]

  def getFileContent(uuid: String, groupId: Long): Array[Byte]

  def getFileEntry(uuid: String, groupId: Long): DLFileEntry

  def copyFile(sourceFolder: String, sourceName: String, destFolder: String, destName: String, deleteFolder: Boolean = true): Unit

  def deleteFile(folder: String, name: String): Unit

  def addToDocumentLibrary(filename: String, groupId: Int, videoTitle: String, extension: String, mimeType: String, size: Long): String
}
