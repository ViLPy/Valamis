package com.arcusys.valamis.settings.service

import com.arcusys.valamis.settings.model.SettingType
import com.arcusys.valamis.settings.storage.SettingStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class SettingServiceImpl(implicit val bindingModule: BindingModule) extends SettingService with Injectable {

  lazy val settingStorage: SettingStorage = inject[SettingStorage]

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

  override def getIssuerEmail(): String = {
    settingStorage.getByKey(SettingType.IssuerEmail).map(_.value).getOrElse("")
  }

  override def setIssuerEmail(value: String): Unit = {
    settingStorage.modify(SettingType.IssuerEmail, value)
  }

  override def setSendMessages(value: Boolean): Unit = {
    settingStorage.modify(SettingType.SendMessages, value.toString)
  }

  override def getSendMessages(): Boolean = {
    settingStorage.getByKey(SettingType.SendMessages).exists(_.value == true.toString)
  }

  override def setGoogleClientId(value: String): Unit = {
    settingStorage.modify(SettingType.GoogleClientId, value.toString)
  }

  override def getGoogleClientId(): String = {
    settingStorage.getByKey(SettingType.GoogleClientId).map(_.value).getOrElse("")
  }

  override def setGoogleAppId(value: String): Unit = {
    settingStorage.modify(SettingType.GoogleAppId, value.toString)
  }

  override def getGoogleAppId(): String = {
    settingStorage.getByKey(SettingType.GoogleAppId).map(_.value).getOrElse("")
  }

  override def setGoogleApiKey(value: String): Unit = {
    settingStorage.modify(SettingType.GoogleApiKey, value.toString)
  }

  override def getGoogleApiKey(): String = {
    settingStorage.getByKey(SettingType.GoogleApiKey).map(_.value).getOrElse("")
  }

  override def setDBVersion(value: String): Unit = {
    settingStorage.modify(SettingType.DBVersion, value)
  }
}
