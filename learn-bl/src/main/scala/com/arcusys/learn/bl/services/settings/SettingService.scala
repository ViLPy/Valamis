package com.arcusys.learn.bl.services.settings

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.setting.storage.SettingStorage
import com.arcusys.learn.settings.model.SettingType
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class SettingService(configuration: BindingModule) extends SettingServiceContract with Injectable {
  def this() = this(DomainConfiguration)

  lazy val settingStorage: SettingStorage = inject[SettingStorage]

  implicit val bindingModule = configuration

  override def setIssuerName(value: String): Unit = {
    settingStorage.modify(SettingType.IssuerName, value)
  }

  override def getIssuerName(): String = {
    settingStorage.getByKey(SettingType.IssuerName).map(_.value).getOrElse("")
  }

  override def setIssuerOrganization(value: String): Unit = {
    settingStorage.modify(SettingType.IssuerOrganization, value)
  }

  override def getIssuerOrganization(): String = {
    settingStorage.getByKey(SettingType.IssuerOrganization).map(_.value).getOrElse("")
  }

  override def setIssuerURL(value: String): Unit = {
    settingStorage.modify(SettingType.IssuerURL, value)
  }

  override def getIssuerURL(): String = {
    settingStorage.getByKey(SettingType.IssuerURL).map(_.value).getOrElse("")
  }

  override def setSendMessages(value: Boolean): Unit = {
    settingStorage.modify(SettingType.SendMessages, value.toString)
  }

  override def getSendMessages(): Boolean = {
    settingStorage.getByKey(SettingType.SendMessages).exists(_.value == true.toString)
  }

  override def setDBVersion(value: String): Unit = {
    settingStorage.modify(SettingType.DBVersion, value)
  }
}
