package com.arcusys.learn.filestorage.storage.impl.orbroker

import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import org.orbroker.Row
import com.arcusys.learn.scorm.tracking.model.FileRecord
import java.io.File

class FileStorageImpl extends GenericEntityStorageImpl[FileRecord]("FileStorage") with FileStorage {

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

  def extract(row: Row) = FileRecord(row.string("filename").get, row.binary("content"))

  private def stripSlashes(filename: String) = """/{2,}""".r replaceAllIn(filename, "/")
}
