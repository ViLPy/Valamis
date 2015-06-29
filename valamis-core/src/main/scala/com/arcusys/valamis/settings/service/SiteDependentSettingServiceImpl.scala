package com.arcusys.valamis.settings.service

import com.arcusys.valamis.settings.storage.SiteDependentSettingStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class SiteDependentSettingServiceImpl(implicit val bindingModule: BindingModule) extends SiteDependentSettingService with Injectable {

  lazy val settingsStorage = inject[SiteDependentSettingStorage]

  override def setSetting(siteId: Int, name: String, value: Option[String]): Unit = {
    settingsStorage.modify(siteId, name, value)
  }

  override def getSetting(siteId: Int, name: String): Option[String] = {
    settingsStorage.getBySiteAndKey(siteId, name).flatMap(_.value)
  }
}
