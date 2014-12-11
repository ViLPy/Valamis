package com.arcusys.learn.settings.model

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.service.LFSiteDependentConfigLocalServiceUtil
import scala.collection.JavaConverters._
import com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig

trait LFSiteDependentSettingStorageImpl extends KeyedEntityStorage[SiteDependentSetting] {
  protected def doRenew() {
    LFSiteDependentConfigLocalServiceUtil.removeAll()
  }

  def extract(entity: LFSiteDependentConfig) = new SiteDependentSetting(
    entity.getId.toInt,
    entity.getSiteID,
    entity.getDataKey,
    Option(entity.getDataValue))

  def getOne(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("siteID", siteID: Int), ("key", key: String)) =>
        try {
          val lfEntity = LFSiteDependentConfigLocalServiceUtil.findBySiteIDAndDataKey(siteID, key)
          if (lfEntity == null) None else Option(extract(lfEntity))
        } catch {
          case _ => None
        }
    }
  }

  def getAll(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("key", key: String)) =>
        LFSiteDependentConfigLocalServiceUtil.findByDataKey(key).asScala.map(extract)
      case Seq(("siteID", siteID: Int)) =>
        LFSiteDependentConfigLocalServiceUtil.findBySiteID(siteID).asScala.map(extract)
      case _ =>
        LFSiteDependentConfigLocalServiceUtil.getLFSiteDependentConfigs(-1, -1).asScala.map(extract)
    }
  }

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def create(entity: Setting, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def delete(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(parameters: (String, Any)*) {
    parameters match {
      case Seq(("siteID", siteID: Int), ("key", key: String), ("value", value: Option[String])) =>
        val lfentity = LFSiteDependentConfigLocalServiceUtil.findBySiteIDAndDataKey(siteID, key)
        lfentity.setDataValue(value.getOrElse(null))
        LFSiteDependentConfigLocalServiceUtil.updateLFSiteDependentConfig(lfentity)
    }
  }

  def modify(entity: Setting, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getByID(id: Int, parameters: (String, Any)*) = {
    throw new UnsupportedOperationException
  }

  def createAndGetID(entity: SiteDependentSetting, parameters: (String, Any)*) = {
    val lfEntity = LFSiteDependentConfigLocalServiceUtil.createLFSiteDependentConfig()
    lfEntity.setSiteID(entity.siteID)
    lfEntity.setDataKey(entity.key.toString)
    entity.value.map(lfEntity.setDataValue)
    LFSiteDependentConfigLocalServiceUtil.addLFSiteDependentConfig(lfEntity).getId.toInt
  }

  def createAndGetID(parameters: (String, Any)*) = {
    throw new UnsupportedOperationException
  }

  override def modify(entity: SiteDependentSetting, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException

  override def create(entity: SiteDependentSetting, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException
}
