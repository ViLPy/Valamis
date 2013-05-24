package com.arcusys.learn.filestorage.storage

import com.arcusys.learn.scorm.tracking.model.FileRecord

trait FileStorage {
  def getFile(filename: String): Option[FileRecord]
  def getFiles(directory: String): Seq[FileRecord]

  def store(filename: String)
  def store(filename: String, content: Array[Byte])

  def delete(filename: String, asDirectory: Boolean = false)
  def renew()
}
