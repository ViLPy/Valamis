package com.arcusys.valamis.file.storage

import com.arcusys.valamis.file.model.FileRecord

trait FileStorage {
  def getFile(filename: String): Option[FileRecord]
  def getFiles(directory: String): Seq[FileRecord]

  //TODO: remove method
  def store(filename: String)
  def store(filename: String, content: Array[Byte])

  def delete(filename: String, asDirectory: Boolean = false)
  //TODO: remove method
  def renew()
}
