package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.tincan.model.Attachment
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment
import com.arcusys.learn.util.JsonSerializer
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsAttachmentLocalServiceUtil
import scala.collection.JavaConverters._

trait LFTincanLrsAttachmentStorageImpl extends EntityStorage[Attachment] {
  def mapper(entity: LFTincanLrsAttachment): Attachment = {
    Attachment(
      entity.getUsageType,
      JsonSerializer.deserializeLanguageMap(entity.getDisplay),
      Option(entity.getDescription).map(JsonSerializer.deserializeLanguageMap),
      entity.getContentType,
      entity.getLength,
      entity.getSha2,
      Option(entity.getFileUrl)
    )
  }

  def renew() = {
    LFTincanLrsAttachmentLocalServiceUtil.removeAll()
  }

  def create(entity: Attachment, parameters: (String, Any)*): Unit = parameters match {
    case Seq(("parentID", parentID: Int)) => {
      val lfEntity = LFTincanLrsAttachmentLocalServiceUtil.createLFTincanLrsAttachment()

      lfEntity.setUsageType(entity.usageType)
      lfEntity.setDisplay(JsonSerializer.serializeLanguageMap(entity.display))
      entity.description.foreach(d => lfEntity.setDescription(JsonSerializer.serializeLanguageMap(d)))
      lfEntity.setContentType(entity.contentType)
      lfEntity.setLength(entity.length)
      lfEntity.setSha2(entity.sha2)
      entity.fileUrl.foreach(lfEntity.setFileUrl)
      lfEntity.setParentID(parentID)

      LFTincanLrsAttachmentLocalServiceUtil.addLFTincanLrsAttachment(lfEntity)
    }
  }

  def getAll(parameters: (String, Any)*): Seq[Attachment] = parameters match {
    case Seq(("parentID", parentID: Int)) => {
      LFTincanLrsAttachmentLocalServiceUtil.findByParentID(parentID).asScala.map(mapper)
    }
  }

  def delete(parameters: (String, Any)*): Unit = parameters match {
    case Seq(("parentID", parentID: Int)) => {
      LFTincanLrsAttachmentLocalServiceUtil.findByParentID(parentID).asScala
        .foreach(LFTincanLrsAttachmentLocalServiceUtil.deleteLFTincanLrsAttachment)
    }
  }

  def getOne(parameters: (String, Any)*): Option[Attachment] = throw new UnsupportedOperationException()

  def create(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def modify(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def modify(entity: Attachment, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def execute(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[Attachment] = throw new UnsupportedOperationException()

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[Attachment] = throw new UnsupportedOperationException()

  def modify(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()
}
