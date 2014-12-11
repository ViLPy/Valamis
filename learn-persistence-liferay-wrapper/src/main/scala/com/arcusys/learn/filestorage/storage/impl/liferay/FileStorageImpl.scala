package com.arcusys.learn.filestorage.storage.impl.liferay

import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.liferay.util.Base64Helper
import com.arcusys.learn.persistence.liferay.model.LFFileStorage
import com.arcusys.learn.persistence.liferay.service.LFFileStorageLocalServiceUtil
import com.arcusys.learn.scorm.tracking.model.FileRecord
import scala.collection.JavaConverters._

/**
 * Created by mminin on 17.10.14.
 */
class FileStorageImpl extends FileStorage {

  override def renew(): Unit = {
    LFFileStorageLocalServiceUtil.removeAll()
  }

  override def getFile(filename: String): Option[FileRecord] = {
    LFFileStorageLocalServiceUtil.findByFilename(stripSlashes(filename), 0, 1).asScala
      .headOption map extract
  }

  override def getFiles(directory: String): Seq[FileRecord] = {
    LFFileStorageLocalServiceUtil.findByDirectory(stripSlashes(directory) + "%").asScala
      .map(extract)
  }

  override def store(filename: String) {
    if (getFile(filename).isDefined)
      delete(filename, asDirectory = true)

    val newEntity: LFFileStorage = LFFileStorageLocalServiceUtil.createLFFileStorage()
    newEntity.setFilename(stripSlashes(filename))
    LFFileStorageLocalServiceUtil.addLFFileStorage(newEntity)
  }

  override def store(filename: String, content: Array[Byte]) {
    if (getFile(filename).isDefined)
      delete(filename, asDirectory = true)

    val newEntity: LFFileStorage = LFFileStorageLocalServiceUtil.createLFFileStorage()
    newEntity.setFilename(stripSlashes(filename))
    newEntity.setContent(Base64Helper.objectToString(content))
    LFFileStorageLocalServiceUtil.addLFFileStorage(newEntity)
  }

  override def delete(filename: String, asDirectory: Boolean = false) {
    if (asDirectory)
      LFFileStorageLocalServiceUtil.removeByDirectory(filename + "%")
    else
      LFFileStorageLocalServiceUtil.removeByFilename(stripSlashes(filename))
  }

  private def stripSlashes(filename: String) = """/{2,}""".r replaceAllIn (filename, "/")

  private def extract(entity: LFFileStorage) = {
    FileRecord(entity.getFilename,
      if (entity.getContent == null || entity.getContent.isEmpty)
        None
      else
        Base64Helper.stringToObject(entity.getContent) match {
          case null           => None
          case x: Array[Byte] => Some(x)
        })
  }
}
