package com.arcusys.learn.filestorage.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFFileStorageLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFFileStorage
import collection.JavaConverters._
import com.arcusys.learn.scorm.tracking.model.FileRecord
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.liferay.util.Base64Helper

/**
 * User: dkudinov
 * Date: 8.3.2013
 */
trait LFFileRecordStorageImpl extends EntityStorage[FileRecord] {
  protected def doRenew() { LFFileStorageLocalServiceUtil.removeAll()}


  def getOne(parameters: (String, Any)*) = {
    val searchResult = parameters match {
      case Seq(("filename", value: String)) => LFFileStorageLocalServiceUtil.findByFilename(value, 0, 1)
    }
    searchResult.asScala.headOption map { extract }
  }

  def extract(entity: LFFileStorage) = FileRecord(entity.getFilename,
    Base64Helper.stringToObject(entity.getContent) match {
      case null => None
      case x: Array[Byte] => Some(x)
    })

  def getAll(parameters: (String, Any)*) = {
    val searchResult = parameters match {
      case Seq(("filename", value: String)) => LFFileStorageLocalServiceUtil.findByFilename(value)
      case Seq(("directory", value: String)) => LFFileStorageLocalServiceUtil.findByDirectory(value)
    }
    searchResult.asScala map { extract }
  }

  def create(parameters: (String, Any)*) {
    val newEntity: LFFileStorage = LFFileStorageLocalServiceUtil.createLFFileStorage()
    parameters.foreach {
      case ("filename", value: String) => newEntity.setFilename(value)
      case ("content", value: Array[Byte]) => newEntity.setContent(Base64Helper.objectToString(value))
    }
    LFFileStorageLocalServiceUtil.addLFFileStorage(newEntity)
  }

  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("filename", value: String)) => LFFileStorageLocalServiceUtil.removeByFilename(value)
      case Seq(("filename", filenameMask: String), ("deleteByDirectory", true)) => LFFileStorageLocalServiceUtil.removeByDirectory(filenameMask)
    }
  }

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def create(entity: FileRecord, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def modify(entity: FileRecord, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
