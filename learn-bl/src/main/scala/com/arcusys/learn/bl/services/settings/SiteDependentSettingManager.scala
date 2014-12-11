package com.arcusys.learn.bl.services.settings

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.setting.storage.SiteDependentSettingStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class SiteDependentSettingManager(configuration: BindingModule) extends SiteDependentSettingManagerContract with Injectable {
  def this() = this(DomainConfiguration)

  lazy val settingsStorage = inject[SiteDependentSettingStorage]

  implicit val bindingModule = configuration

  override def setSetting(siteId: Int, name: String, value: Option[String]): Unit = {
    settingsStorage.modify(siteId, name, value)
  }

  override def getSetting(siteId: Int, name: String): Option[String] = {
    settingsStorage.getBySiteAndKey(siteId, name).flatMap(_.value)
  }
}
