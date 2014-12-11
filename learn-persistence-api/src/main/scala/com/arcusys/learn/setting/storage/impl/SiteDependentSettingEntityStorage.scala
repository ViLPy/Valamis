package com.arcusys.learn.setting.storage.impl

import com.arcusys.learn.storage.impl.{ EntityStorageExt, KeyedEntityStorageExt }
import com.arcusys.learn.setting.storage.SiteDependentSettingStorage
import com.arcusys.learn.settings.model.SiteDependentSetting

trait SiteDependentSettingEntityStorage extends SiteDependentSettingStorage
    with KeyedEntityStorageExt[SiteDependentSetting] with EntityStorageExt[SiteDependentSetting] {
  def getByKey(key: String): Seq[SiteDependentSetting] = {
    getAll("key" -> key.toString)
  }

  def getBySite(siteID: Int): Seq[SiteDependentSetting] = {
    getAll("siteID" -> siteID)
  }

  def getBySiteAndKey(siteID: Int, key: String): Option[SiteDependentSetting] = {
    getOne("siteID" -> siteID, "key" -> key.toString)
  }

  def modify(siteID: Int, key: String, value: Option[String]) {
    val item = getBySiteAndKey(siteID, key)
    if (item.isDefined) modify("siteID" -> siteID, "key" -> key.toString, "value" -> value)
    else createAndGetID(SiteDependentSetting(0, siteID, key, value), Seq(): _*)
  }
}
