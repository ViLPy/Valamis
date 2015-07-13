package com.arcusys.valamis.settings.model

import com.arcusys.valamis.settings.model.SettingType.SettingType

/**
 * A site which is part of certificate
 * @param key             Unique settings key
 * @param value  setting value
 */
case class Setting(
  id: Int,
  key: SettingType.Value,
  value: String)

object SettingType extends Enumeration {
  type SettingType = Value
  val IssuerName = Value("IssuerName")
  val IssuerURL = Value("IssuerURL")
  val IssuerOrganization = Value("IssuerOrganization")
  val IssuerEmail = Value("IssuerEmail")
  val DBVersion = Value("DBVersion")
  val SendMessages = Value("SendMessages")
  val GoogleClientId = Value("GoogleClientId")
  val GoogleAppId = Value("GoogleAppId")
  val GoogleApiKey = Value("GoogleApiKey")
}

object EmptySetting {
  def apply(settingType: SettingType,
    defaultValue: String = "") = Setting(0, settingType, defaultValue)
}
