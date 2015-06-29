package com.arcusys.valamis.settings.storage

import com.arcusys.valamis.settings.model.SiteDependentSetting

trait SiteDependentSettingStorage {
  def getAll: Seq[SiteDependentSetting]
  def getByKey(key: String): Seq[SiteDependentSetting]
  def getBySite(siteID: Int): Seq[SiteDependentSetting]
  def getBySiteAndKey(siteID: Int, key: String): Option[SiteDependentSetting]
  def createAndGetID(entity: SiteDependentSetting): Int
  def modify(siteID: Int, key: String, value: Option[String])
  def renew()
}
