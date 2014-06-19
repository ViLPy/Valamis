package com.arcusys.learn.filestorage.storage.impl

import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.storage.impl.EntityStorageExt
import com.arcusys.learn.scorm.tracking.model.FileRecord

/**
 * User: dkudinov
 * Date: 14.3.2013
 */
trait FileRecordEntityStorage extends FileStorage with EntityStorageExt[FileRecord] {

  def getFile(filename: String): Option[FileRecord] = getOne("filename" -> stripSlashes(filename))

  def getFiles(directory: String): Seq[FileRecord] = getAll("directory" -> (stripSlashes(directory) + "%"))

  def store(filename: String) {
    if (getFile(filename).isDefined) delete(filename, asDirectory = true)
    create("filename" -> stripSlashes(filename))
  }

  def store(filename: String, content: Array[Byte]) {
    if (getFile(filename).isDefined) delete(filename, asDirectory = true)
    create("filename" -> stripSlashes(filename), "content" -> content)
  }

  def delete(filename: String, asDirectory: Boolean = false) {
    if (asDirectory) delete("filename" -> (filename + "%"), "deleteByDirectory" -> true)
    else delete("filename" -> stripSlashes(filename))
  }

  private def stripSlashes(filename: String) = """/{2,}""".r replaceAllIn (filename, "/")
}
